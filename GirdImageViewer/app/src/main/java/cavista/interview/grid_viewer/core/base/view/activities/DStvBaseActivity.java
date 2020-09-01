package cavista.interview.grid_viewer.core.base.view.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.example.galleryactivity.R;
import com.kaopiz.kprogresshud.KProgressHUD;

import cavista.interview.grid_viewer.core.SharedPreferencesWrapper;
import cavista.interview.grid_viewer.core.base.view.IBaseView;
import cavista.interview.grid_viewer.core.constants.KeyConstants;

public class DStvBaseActivity extends AppCompatActivity implements IBaseView {
    private KProgressHUD progressDialog;

    public void startServerApiErrorScreen(String error) {
        showDialog(error);
    }

    public void showProgress() {
        try {
            progressDialog = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("   " + getString(R.string.loading) + "   ")
                    .setCancellable(false)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }


    public boolean isNetworkAvailable(final Context context) {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
        return false;
    }

    public void showDialog(String error) {
        try {
            Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.layout_server_error);
            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            LinearLayout llServerParent = dialog.findViewById(R.id.ll_server_error_parent);
            TextView tvServerErrorMsg = dialog.findViewById(R.id.tv_server_error_msg);
            ImageView ivScreenIcon = dialog.findViewById(R.id.iv_server_error_logo);
            TextView tvServerErrorTitle = dialog.findViewById(R.id.tv_server_error_title);
            RelativeLayout btServerErrorOk = dialog.findViewById(R.id.bt_server_error_ok);
            TextView loginText = dialog.findViewById(R.id.login_text);
            TextView loginText2 = dialog.findViewById(R.id.login_text2);
            RelativeLayout btnRetry = dialog.findViewById(R.id.bt_ret);
            TextView subMsg = dialog.findViewById(R.id.lbl_sub_msg);
            RelativeLayout layout_grad = dialog.findViewById(R.id.layout_grad);

            subMsg.setVisibility(View.VISIBLE);
            tvServerErrorMsg.setVisibility(View.VISIBLE);

            if (error != null && error.equalsIgnoreCase(KeyConstants.SERVER_ERROR)) {
                tvServerErrorMsg.setText(getString(R.string.server_error_new_msg));
                tvServerErrorTitle.setText(getString(R.string.server_error_new_title));
                ivScreenIcon.setBackgroundResource(R.drawable.icon_warning_triangle);
                loginText.setText(R.string.OK);
                btnRetry.setVisibility(View.GONE);

            } else if (error != null && error.equalsIgnoreCase(KeyConstants.NO_INTERNET)) {
                tvServerErrorMsg.setText(getString(R.string.internet_error_msg));
                tvServerErrorTitle.setText(getString(R.string.internet_error_title));
                ivScreenIcon.setBackgroundResource(R.drawable.no_internet);
                loginText.setText(R.string.GOTIT);
                loginText2.setText(R.string.CHECK_SETTINGS);
                btnRetry.setVisibility(View.VISIBLE);
                subMsg.setText(R.string.SUB_INET);
            }

            btServerErrorOk.setOnClickListener(v -> {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            });

            btnRetry.setOnClickListener(v -> {
                try {
                    if (loginText2.getText().toString().equals("SETTINGS")) {
                        Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        this.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Crashlytics.logException(e);
                }
            });
            if (!this.isDestroyed() && !this.isFinishing() && !dialog.isShowing()) {
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

    public void hideProgress() {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

}
