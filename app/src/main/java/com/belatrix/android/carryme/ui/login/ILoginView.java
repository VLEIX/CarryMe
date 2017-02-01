package com.belatrix.android.carryme.ui.login;

import com.belatrix.android.carryme.model.User;
import com.belatrix.android.carryme.ui.common.MVPView;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 1/27/17.
 */
public interface ILoginView extends MVPView {
    void navigateToSignUp(User user);
    void navigateToBabyInformation();

    boolean isValidForm();
    String getEmail();
    String getPassword();
}
