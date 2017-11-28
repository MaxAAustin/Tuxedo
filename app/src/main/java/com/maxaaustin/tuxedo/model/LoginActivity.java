package com.maxaaustin.tuxedo.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {

    com.twitter.sdk.android.core.identity.TwitterLoginButton mTwitterLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.maxaaustin.tuxedo.R.layout.activity_login);
        com.twitter.sdk.android.core.Twitter.initialize(this);
        mTwitterLoginButton = (TwitterLoginButton) findViewById(com.maxaaustin.tuxedo.R.id.twitter_login_button);
        mTwitterLoginButton.setCallback(new com.twitter.sdk.android.core.Callback<com.twitter.sdk.android.core.TwitterSession>() {
            @Override
            public void success(com.twitter.sdk.android.core.Result<com.twitter.sdk.android.core.TwitterSession> result) {
                //TODO: what to do if successful callback
            }

            @Override
            public void failure(com.twitter.sdk.android.core.TwitterException exception) {
                //TODO: what to do if unsuccessful callback
            }
        });
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mTwitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }
}
