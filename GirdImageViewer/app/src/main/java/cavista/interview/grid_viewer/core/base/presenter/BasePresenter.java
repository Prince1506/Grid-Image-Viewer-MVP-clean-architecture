package cavista.interview.grid_viewer.core.base.presenter;


import cavista.interview.grid_viewer.core.base.view.IBaseView;

public class BasePresenter<V extends IBaseView> {
    public V view;

    public final void bind(V viewToBind) {
        view = viewToBind;
    }

    public final void unbind() {
        view = null;
    }
}

