package com.belatrix.android.carryme.ui.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ffranco on 24/09/16.
 */

public abstract class MVPActivity<P extends MVPPresenter> extends BaseActivity implements MVPView {

    private P presenter;
    private ProgressDialog activeProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = provideViewPresenter();
    }

    @Override
    protected void onDestroy() {
        presenter.viewDidDestroyed();
        super.onDestroy();
    }

//    @Override
//    public void showProgressDialog(String title, String message) {
//        if (activeProgressDialog != null) {
//            activeProgressDialog.setTitle(title);
//            activeProgressDialog.setMessage(message);
//        }
//        else {
//            activeProgressDialog = ProgressDialog.show(this, title, message, true, false);
//        }
//    }
//
//    @Override
//    public void dismissProgressDialog() {
//        if (activeProgressDialog != null) {
//            activeProgressDialog.dismiss();
//            activeProgressDialog = null;
//        }
//    }
//
//    @Override
//    public void showAlertDialog(String title, String message) {
////        UIUtils.showAlertDialog(this, title, message);
//    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected abstract P provideViewPresenter();
}
