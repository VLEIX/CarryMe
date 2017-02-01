package com.belatrix.android.carryme.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.belatrix.android.carryme.R;
import com.belatrix.android.carryme.model.User;
import com.belatrix.android.carryme.ui.common.MVPFragment;
import com.belatrix.android.carryme.util.Util;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 1/27/17.
 */
public class LoginFragment extends MVPFragment<ILoginPresenter> implements ILoginView {

    public static final String TAG_USER = "USER";

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnLoginFacebook;
    private Button btnSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Bundle args = getArguments();
//        if (args != null) {
//            user = (User) args.getSerializable(TAG_USER);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews(view);
        setInitValues();
    }

    @Override
    protected ILoginPresenter provideViewPresenter() {
        return new LoginPresenter(this);
    }

    private void setViews(View view) {
        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnLoginFacebook = (Button) view.findViewById(R.id.btnLoginFacebook);
        btnSignUp = (Button) view.findViewById(R.id.btnSignUp);

        listeners();
    }

    private void listeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().userDidClickLogin();
            }
        });

        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().userDidClickLoginWithFacebook();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().userDidClickSignUp();
            }
        });
    }

    private void setInitValues() {
    }

    @Override
    public void navigateToSignUp(User user) {
//        Intent intent = new Intent(getContext(), SignUpActivity.class);
//        intent.putExtra(TAG_USER, user);
//        startActivity(intent);
    }

    @Override
    public void navigateToBabyInformation() {

    }

    @Override
    public boolean isValidForm() {
        if (edtEmail.getText().toString().trim().length() > 0) {
            if (Util.isValidEmail(edtEmail.getText().toString().trim())) {
                if (edtPassword.getText().toString().trim().length() > 0) {
                    return true;
                } else {
                    edtPassword.setError(getResources().getString(R.string.lang_login_message_passwordEmpty));
                }
            } else {
                edtEmail.setError(getResources().getString(R.string.lang_login_message_emailInvalid));
            }
        } else {
            edtEmail.setError(getResources().getString(R.string.lang_login_message_emailEmpty));
        }

        return false;
    }

    @Override
    public String getEmail() {
        return edtEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }
}
