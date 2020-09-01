package cavista.interview.grid_viewer.core.network;

import com.crashlytics.android.Crashlytics;
import com.example.galleryactivity.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import cavista.interview.grid_viewer.core.MyApplication;
import cavista.interview.grid_viewer.core.constants.KeyConstants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkHelper {
    int timeout = 7 * 1000;

    @Inject
    public NetworkHelper() {
    }

    public <T> T createRetrofitApi(final String url, final Class<T> service) {
        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            if (BuildConfig.IS_DEBUG) {
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                logging.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            httpClient.sslSocketFactory(new TLSSocketFactory());
            httpClient.readTimeout(timeout, TimeUnit.SECONDS);
            httpClient.connectTimeout(timeout, TimeUnit.SECONDS);
            httpClient.writeTimeout(timeout, TimeUnit.SECONDS);
            if (!MyApplication.tokenBearer.isEmpty()) {
                httpClient.addInterceptor(chain -> {
                    Request request = null;
                    try {
                        Request original = chain.request();
                        request = original.newBuilder()
                                .header(KeyConstants.AUTHORIZATION_TOKEN, MyApplication.tokenBearer)
                                .build();

                        return chain.proceed(request);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Crashlytics.logException(e);
                    }
                    return chain.proceed(request);
                });
            }

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            return retrofit.create(service);
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
        return null;
    }

}
