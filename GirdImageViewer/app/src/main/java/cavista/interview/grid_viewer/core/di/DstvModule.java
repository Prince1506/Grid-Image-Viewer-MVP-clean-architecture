package cavista.interview.grid_viewer.core.di;

import android.content.Context;


import cavista.interview.grid_viewer.core.MyApplication;
import cavista.interview.grid_viewer.core.network.NetworkHelper;
import cavista.interview.grid_viewer.core.usecase.AndroidUseCaseComposer;
import cavista.interview.grid_viewer.core.usecase.UseCaseComposer;
import dagger.Module;
import dagger.Provides;

@Module
public class DstvModule {

    @Provides
    public Context provideDStvApplicationContext() {
        return MyApplication.getMyApplicationContext();
    }

    @Provides
    public NetworkHelper provideDStvNetworkHelper() {
        return new NetworkHelper();
    }

    @Provides
    UseCaseComposer provideUseCaseComposer() {
        return new AndroidUseCaseComposer();
    }

}
