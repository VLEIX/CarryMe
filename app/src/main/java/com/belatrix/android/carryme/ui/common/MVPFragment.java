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
        } else {
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


    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
        dismissProgressDialog();
        getPresenter().viewDidDestroyed();
        super.onDestroy();
    }

    private boolean isLeaked() {
        return getActivity() == null || getActivity().isFinishing();
    }

    protected abstract P provideViewPresenter();
}
