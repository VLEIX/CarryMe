package com.belatrix.android.carryme.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.android.carryme.listener.IOnActionListener;

/**
 * Created by ffranco on 23/08/16.
 */
public class BaseActivity extends AppCompatActivity implements BaseView, DialogDisplayer {
    private BaseDialogManager dialogManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogManager = new BaseDialogManager(this);
    }

    @Override
    public void showProgressDialog(String message) {
        dialogManager.showProgressDialog(message);
    }

    @Override
    public void showProgressDialog(String title, String message) {
        dialogManager.showProgressDialog(title, message);
    }

    @Override
    public void dismissProgressDialog() {
        dialogManager.dismissProgressDialog();
    }

    @Override
    public void showAlertDialog(String title, String message) {
        dialogManager.showAlertDialog(title, message);
    }

    @Override
    public void showTwoOptionsAlertDialog(String title, String message,
                                          @Nullable IOnActionListener onAcceptListener,
                                          @Nullable IOnActionListener onCancelListener) {
        dialogManager.showTwoOptionsAlertDialog(title, message, onAcceptListener, onCancelListener);
    }

    @Override
    public void showTwoOptionsAlertDialog(String title, String message,
                                          String positiveButtonText,
                                          @Nullable IOnActionListener onAcceptListener,
                                          String negativeButtonText,
                                          @Nullable IOnActionListener onCancelListener) {
        dialogManager.showTwoOptionsAlertDialog(title, message, positiveButtonText,
                onAcceptListener, negativeButtonText, onCancelListener);
    }

    @Override
    public void showSimpleAlertDialog(String title, String message,
                                      @Nullable IOnActionListener onAcceptListener) {
        dialogManager.showSimpleAlertDialog(title, message, onAcceptListener);
    }

    @Override
    public void showSimpleAlertDialog(String title, String message,
                                      String positiveButtonText,
                                      @Nullable IOnActionListener onAcceptListener) {
        dialogManager.showSimpleAlertDialog(title, message,
                positiveButtonText, onAcceptListener);
    }

    @Override
    public void showToast(String message) {
        dialogManager.showToast(message);
    }

    @Override
    public String getResourceString(int stringId) {
        return getResources().getString(stringId);
    }
}
