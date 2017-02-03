package com.belatrix.android.carryme.ui.common;

/**
 * Created by ffranco on 19/09/16.
 */

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter<V> {
    private V view;

    public BasePresenter(V view) {
        setView(view);
    }

    @Override
    public void setView(V view) {
        this.view = view;
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public abstract void viewDidCreated(V view);

    @Override
    public void viewDidDestroyed() {
        view = null;
    }
}
