package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;

public interface IBaseFragmentView {
    void startServerApiErrorScreen(final String msg);
    boolean isNetworkAvailable(Context context);
    void showProgress();
    void hideProgress();
}
