package com.belatrix.android.carryme.ui.client;

import com.belatrix.android.carryme.ui.common.BasePresenter;
import com.belatrix.android.carryme.ui.login.LoginPresenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 2/3/17.
 * GOOODK
 */
public class ClientHomePresenter extends BasePresenter<IClientHomeView> implements IClientHomePresenter {

    private static Logger LOG = LoggerFactory.getLogger(LoginPresenter.class);

    public ClientHomePresenter(IClientHomeView view) {
        super(view);
    }

    @Override
    public void viewDidCreated(IClientHomeView view) {
    }

    @Override
    public void userDidClickOpenMap() {

    }
}
