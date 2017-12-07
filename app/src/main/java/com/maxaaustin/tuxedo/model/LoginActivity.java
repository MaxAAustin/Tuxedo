package com.maxaaustin.tuxedo.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity  {
    private final String CONSUMER_KEY= "IMk3fgM2AXuMVNVQFWgVwAWJb";
    private final String CONSUMER_SECRET= "OfR0AcJdTOhPxzcR6Z8Zf66sOrrMFdKYtSr5vJVoIR1foR4aKk";

    TwitterLoginButton mTwitterLoginButton;

    private static final String TAG = "User Login Activity";

    private TwitterAuthConfig auth = new TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET);
    private String picUrl = "";
    private String userName= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterConfig config = new TwitterConfig.Builder(this).logger(new DefaultLogger(android.util.Log.DEBUG)).twitterAuthConfig(auth).debug(true).build();
        Twitter.initialize(config);
        setContentView(com.maxaaustin.tuxedo.R.layout.activity_login);



        mTwitterLoginButton = (TwitterLoginButton) findViewById(com.maxaaustin.tuxedo.R.id.twitter_login_button);
        mTwitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                TwitterAuthConfig twitterAuthConfig = TwitterCore.getInstance().getAuthConfig();
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;

                login(session);
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(LoginActivity.this, "Please try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void login(TwitterSession session) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mTwitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }

}
