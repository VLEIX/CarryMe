package com.belatrix.android.carryme.ui.common;

/**
 * Created by ffranco on 22/09/16.
 */

public interface MVPPresenter<V extends MVPView> {

    void setView(V view);

    V getView();

    void viewDidCreated(V view);

    void viewDidDestroyed();
}