package com.belatrix.android.carryme.ui.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.belatrix.android.carryme.listener.IOnActionListener;

import com.belatrix.android.carryme.util.UIUtils;

public class BaseDialogManager {

    private ProgressDialog activeProgressDialog;
    private boolean progressDialogHasTitle;
    private Context context;
    private boolean isLeaked;

    public BaseDialogManager(Context context) {
        this.context = context;
    }

    public void setLeaked(boolean isLeaked) {
        this.isLeaked = isLeaked;
    }

    public boolean isLeaked() {
        return isLeaked;
    }

    public void showProgressDialog(String message) {
        if (isLeaked()) {
            return;
        }
        if ((activeProgressDialog != null) && progressDialogHasTitle) {
            activeProgressDialog.dismiss();
            activeProgressDialog = null;
        }

        if (activeProgressDialog != null) {
            activeProgressDialog.setMessage(message);
        } else {
            activeProgressDialog = UIUtils.showProgressDialog(context, message);
        }

        progressDialogHasTitle = false;
    }

    public void showProgressDialog(String title, String message) {
        if (isLeaked()) {
            return;
        }
        if (activeProgressDialog != null) {
            activeProgressDialog.setTitle(title);
            activeProgressDialog.setMessage(message);
        } else {
            activeProgressDialog = UIUtils.showProgressDialog(context, title, message);
        }

        progressDialogHasTitle = true;
    }

    public void dismissProgressDialog() {
        if (isLeaked()) {
            return;
        }
        if (activeProgressDialog != null) {
            activeProgressDialog.dismiss();
            activeProgressDialog = null;
        }
    }

    public void showAlertDialog(String title, String message) {
        if (isLeaked()) {
            return;
        }
        UIUtils.showAlertDialog(context, title, message);
    }

    public void showSimpleAlertDialog(String title, String message, @Nullable IOnActionListener onAcceptListener) {
        if (isLeaked()) {
            return;
        }
        UIUtils.showSimpleAlertDialog(context, title, message, onAcceptListener);
    }

    public void showSimpleAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionListener onAcceptListener) {
        if (isLeaked()) {
            return;
        }
        UIUtils.showSimpleAlertDialog(context, title, message, positiveButtonText, onAcceptListener);
    }

    public void showTwoOptionsAlertDialog(String title, String message, @Nullable IOnActionListener onAcceptListener, @Nullable IOnActionListener onCancelListener) {
        if (isLeaked()) {
            return;
        }
        UIUtils.showTwoOptionsAlertDialog(context, title, message, onAcceptListener, onCancelListener);
    }

    public void showTwoOptionsAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionListener onAcceptListener, String negativeButtonText, @Nullable IOnActionListener onCancelListener) {
        if (isLeaked()) {
            return;
        }

        UIUtils.showTwoOptionsAlertDialog(context, title, message, positiveButtonText, onAcceptListener, negativeButtonText, onCancelListener);
    }

    public void showToast(String message) {
        if (isLeaked()) {
            return;
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
