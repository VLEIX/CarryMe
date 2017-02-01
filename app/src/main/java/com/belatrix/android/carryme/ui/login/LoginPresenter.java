package com.belatrix.android.carryme.ui.login;

import com.belatrix.android.carryme.model.User;
import com.belatrix.android.carryme.ui.common.BasePresenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 1/27/17.
 * GOOODK
 */
public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private static Logger LOG = LoggerFactory.getLogger(LoginPresenter.class);

    public LoginPresenter(ILoginView view) {
        super(view);
    }

    @Override
    public void viewDidCreated(ILoginView view) {
    }

    @Override
    public void userDidClickLogin() {
        if (getView().isValidForm()) {
            String email = getView().getEmail();
            String password = getView().getPassword();

            LOG.info("email: " + email);
            LOG.info("password: " + password);
        }
    }

    @Override
    public void userDidClickLoginWithFacebook() {
        // TEMP
        User user = new User("Flavio", "Franco", "flavio.franco.t@gmail.com", "");
        //

        getView().navigateToSignUp(user);
    }

    @Override
    public void userDidClickSignUp() {
        getView().navigateToSignUp(new User());
    }
}
