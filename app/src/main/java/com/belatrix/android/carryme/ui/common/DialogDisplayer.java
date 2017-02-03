package com.belatrix.android.carryme.ui.common;

import android.support.annotation.Nullable;

import com.belatrix.android.carryme.listener.IOnActionListener;

public interface DialogDisplayer {
    void showProgressDialog(String message);

    void showProgressDialog(String title, String message);

    void dismissProgressDialog();

    void showAlertDialog(String title, String message);

    void showTwoOptionsAlertDialog(String title, String message, @Nullable IOnActionListener onAcceptListener, @Nullable IOnActionListener onCancelListener);

    void showTwoOptionsAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionListener onAcceptListener,
                                   String negativeButtonText, @Nullable IOnActionListener onCancelListener);

    void showSimpleAlertDialog(String title, String message, @Nullable IOnActionListener onAcceptListener);

    void showSimpleAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionListener onAcceptListener);

    void showToast(String message);
}
