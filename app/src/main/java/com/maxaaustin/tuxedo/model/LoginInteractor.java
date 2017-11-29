package com.maxaaustin.tuxedo.model;

import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by maaus on 11/28/2017.
 */

public interface LoginInteractor {

    interface onLoginFinishedListener{
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, com.maxaaustin.tuxedo.model.LoginInteractor.onLoginFinishedListener onLoginFinishedListener);

    void login(TwitterSession session);
}
