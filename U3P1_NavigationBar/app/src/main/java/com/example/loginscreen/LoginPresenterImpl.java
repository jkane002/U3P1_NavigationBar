package com.example.loginscreen;

import android.text.TextUtils;

public class LoginPresenterImpl implements LoginPresenter
{
    private LoginView loginView;
    LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
    }
    @Override
    public void handleLogin(String username, String password)
    {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationErrorMsg();
        }
        else {
            if (username.equals("John Doe") && password.equals("password")) {
                loginView.loginSuccessFully();
            } else {
                loginView.loginFail();
            }
        }
    }
}
