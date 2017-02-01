package com.belatrix.android.carryme.ui.login;

import com.belatrix.android.carryme.ui.common.MVPPresenter;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 1/27/17.
 */
public interface ILoginPresenter extends MVPPresenter<ILoginView> {
    void userDidClickLogin();
    void userDidClickLoginWithFacebook();
    void userDidClickSignUp();
}
