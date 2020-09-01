package cavista.interview.grid_viewer.core.base.view;


import android.content.Context;


public interface IBaseView {
    void startServerApiErrorScreen(final String error);
    boolean isNetworkAvailable(Context context);
    void showProgress();
    void hideProgress();
}
