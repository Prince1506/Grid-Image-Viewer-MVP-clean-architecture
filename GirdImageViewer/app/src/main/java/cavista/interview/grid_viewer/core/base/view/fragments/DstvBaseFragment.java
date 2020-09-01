package cavista.interview.grid_viewer.core.base.view.fragments;


import android.content.Context;

import androidx.fragment.app.Fragment;

import cavista.interview.grid_viewer.core.base.view.IBaseFragmentView;
import cavista.interview.grid_viewer.core.base.view.IRetryCallBack;
import cavista.interview.grid_viewer.core.base.view.activities.DStvBaseActivity;

public class DstvBaseFragment extends Fragment implements IBaseFragmentView {

    @Override
    public void startServerApiErrorScreen(String msg) {
        if (getActivity() instanceof DStvBaseActivity){
            ((DStvBaseActivity)getActivity()).startServerApiErrorScreen(msg);
        }
    }


    @Override
    public boolean isNetworkAvailable(Context context) {
        if (getActivity() instanceof DStvBaseActivity){
           return  ((DStvBaseActivity)getActivity()).isNetworkAvailable(context);
        }else return false;
    }

    @Override
    public void showProgress() {
        if (getActivity() instanceof DStvBaseActivity) {
           ((DStvBaseActivity) getActivity()).showProgress();
        }
    }

    @Override
    public void hideProgress() {
        if (getActivity() instanceof DStvBaseActivity) {
            ((DStvBaseActivity) getActivity()).hideProgress();
        }
    }
}
