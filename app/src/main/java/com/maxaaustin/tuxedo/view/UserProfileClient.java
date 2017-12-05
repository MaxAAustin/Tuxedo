package com.maxaaustin.tuxedo.view;

import com.twitter.sdk.android.core.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maaus on 12/4/2017.
 */

public interface UserProfileClient {

    @GET("users/show.json")
    Call<User> getUserDetails(@Query("screen_name") String screenName);

}
