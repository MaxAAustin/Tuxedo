package com.maxaaustin.tuxedo.presentation;

/**
 * Created by maaus on 11/28/2017.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
