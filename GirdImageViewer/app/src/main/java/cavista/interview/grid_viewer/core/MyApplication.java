package cavista.interview.grid_viewer.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.example.galleryactivity.BuildConfig;

import java.util.Map;

import io.fabric.sdk.android.Fabric;


/**
 * Application class for whole app
 */
public class MyApplication extends Application {

    public static String tokenBearer = "";
    @SuppressLint("StaticFieldLeak")
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        try {
            initCrashlytis();
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

    private void initCrashlytis() {
        try {

            Crashlytics crashlyticsKit = new Crashlytics.Builder()
                    .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                    .build();

            final Fabric fabric = new Fabric.Builder(this)
                    .kits(crashlyticsKit)
                    .debuggable(true)  // Enables Crashlytics debugger
                    .build();

            Fabric.with(fabric);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        get app context
    */
    public static Context getMyApplicationContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
