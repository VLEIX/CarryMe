package com.belatrix.android.carryme.ui.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by ffranco on 22/09/16.
 */
public abstract class MVPFragment<P extends MVPPresenter> extends BaseFragment implements MVPView {

    private P presenter;
    private ProgressDialog activeProgressDialog;
    private boolean progressDialogHasTitle;

    private String presenterTag;

    private static final String PRESENTER_TAG_INSTANCE_STATE_KEY = "presenter.tag";
    @Override
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeProvidePresenter(savedInstanceState);
        presenter = provideViewPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        presenter.viewDidCreated(this);
    }

    public void onBeforeProvidePresenter(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            presenterTag = savedInstanceState.getString(PRESENTER_TAG_INSTANCE_STATE_KEY);
        }
        else {
            presenterTag = UUID.randomUUID().toString();
        }
    }

    public String getPresenterTag() {
        return presenterTag;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PRESENTER_TAG_INSTANCE_STATE_KEY, presenterTag);
    }

//    @Override
//    public void showProgressDialog(String message) {
//        if (isLeaked()) {
//            return;
//        }
//        if ((activeProgressDialog != null) && progressDialogHasTitle) {
//            activeProgressDialog.dismiss();
//            activeProgressDialog = null;
//        }
//
//        if (activeProgressDialog != null) {
//            activeProgressDialog.setMessage(message);
//        }
//        else {
////            activeProgressDialog = UIUtils.showProgressDialog(getContext(), message);
//        }
//
//        progressDialogHasTitle = false;
//    }

//    @Override
//    public void showProgressDialog(String title, String message) {
//        if (isLeaked()) {
//            return;
//        }
//        if (activeProgressDialog != null) {
//            activeProgressDialog.setTitle(title);
//            activeProgressDialog.setMessage(message);
//        } else {
////            activeProgressDialog = UIUtils.showProgressDialog(getContext(), title, message);
//        }
//
//        progressDialogHasTitle = true;
//    }
//
//    @Override
//    public void dismissProgressDialog() {
//        if (isLeaked()) {
//            return;
//        }
//        if (activeProgressDialog != null) {
//            activeProgressDialog.dismiss();
//            activeProgressDialog = null;
//        }
//    }
//
//    @Override
//    public void showAlertDialog(String title, String message) {
//        if (isLeaked()) {
//            return;
//        }
////        UIUtils.showAlertDialog(getContext(), title, message);
//    }
//
//    @Override
//    public void showSimpleAlertDialog(String title, String message, @Nullable IOnActionPressedListener onAcceptListener) {
//        if (isLeaked()) {
//            return;
//        }
////        UIUtils.showSimpleAlertDialog(getContext(), title, message, onAcceptListener);
//    }
//
//    @Override
//    public void showSimpleAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionPressedListener onAcceptListener) {
//        if (isLeaked()) {
//            return;
//        }
////        UIUtils.showSimpleAlertDialog(getContext(), title, message, positiveButtonText, onAcceptListener);
//    }
//
//
//    @Override
//    public void showTwoOptionsAlertDialog(String title, String message, @Nullable IOnActionPressedListener onAcceptListener, @Nullable IOnActionPressedListener onCancelListener) {
//        if (isLeaked()) {
//            return;
//        }
////        UIUtils.showTwoOptionsAlertDialog(getContext(), title, message, onAcceptListener, onCancelListener);
//    }
//
//    @Override
//    public void showTwoOptionsAlertDialog(String title, String message, String positiveButtonText, @Nullable IOnActionPressedListener onAcceptListener, String negativeButtonText, @Nullable IOnActionPressedListener onCancelListener) {
//        if (isLeaked()) {
//            return;
//        }
//
////        UIUtils.showTwoOptionsAlertDialog(getContext(), title, message, positiveButtonText, onAcceptListener, negativeButtonText, onCancelListener);
//    }

    @Override
    public void showToast(String message) {
        if (isLeaked()) {
            return;
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
//        dismissProgressDialog();
        getPresenter().viewDidDestroyed();
        super.onDestroy();
    }

    protected boolean isLeaked() {
        return getActivity() == null || getActivity().isFinishing();
    }

    protected abstract P provideViewPresenter();
}
