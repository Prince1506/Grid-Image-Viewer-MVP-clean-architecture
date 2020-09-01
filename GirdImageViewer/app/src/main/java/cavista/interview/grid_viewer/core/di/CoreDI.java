package cavista.interview.grid_viewer.core.di;

public class CoreDI {
    private static DstvComponent dStvComponent;

    public static DstvComponent getDStvComponent() {
        if (dStvComponent == null) {
            dStvComponent = DaggerDstvComponent.builder().build();
        }
        return dStvComponent;
    }
}
