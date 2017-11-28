package com.maxaaustin.tuxedo.view;

/**
 * Created by maaus on 11/28/2017.
 */

public interface LoginView {

    void showProgress();

    void  hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
