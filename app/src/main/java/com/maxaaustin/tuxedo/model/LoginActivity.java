package com.maxaaustin.tuxedo.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.maxaaustin.tuxedo.MainActivity;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity implements LoginInteractor{

    TwitterLoginButton mTwitterLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.twitter.sdk.android.core.Twitter.initialize(this);
        setContentView(com.maxaaustin.tuxedo.R.layout.activity_login);
        mTwitterLoginButton = (TwitterLoginButton) findViewById(com.maxaaustin.tuxedo.R.id.twitter_login_button);
        mTwitterLoginButton.setCallback(new com.twitter.sdk.android.core.Callback<TwitterSession>() {
            @Override
            public void success(com.twitter.sdk.android.core.Result<TwitterSession> result) {
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;

                login(session);
            }

            @Override
            public void failure(com.twitter.sdk.android.core.TwitterException exception) {
                Toast.makeText(getApplicationContext(), "Please try again!",Toast.LENGTH_LONG).show();
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

    @Override
    public void login(String username, String password, onLoginFinishedListener onLoginFinishedListener) {
        //TODO: Create SQLite DB, queries, and table for email and passwords.

    }

    @Override
    public void login(TwitterSession session) {
        String username = session.getUserName();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
