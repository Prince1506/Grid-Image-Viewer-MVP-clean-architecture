package cavista.interview.grid_viewer.core.di;

import javax.inject.Singleton;

import cavista.interview.grid_viewer.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = DstvModule.class)
public interface DstvComponent {
    void inject(MainActivity mainActivity);
}
