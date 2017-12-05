package com.maxaaustin.tuxedo.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements LoginInteractor{

    TwitterLoginButton mTwitterLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.twitter.sdk.android.core.Twitter.initialize(this);
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
            public void failure(com.twitter.sdk.android.core.TwitterException exception) {
                Toast.makeText(LoginActivity.this, "Please try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
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
