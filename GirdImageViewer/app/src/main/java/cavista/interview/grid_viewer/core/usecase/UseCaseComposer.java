
package cavista.interview.grid_viewer.core.usecase;


import io.reactivex.ObservableTransformer;

public  interface UseCaseComposer {

    <T> ObservableTransformer<T, T> apply();

}
