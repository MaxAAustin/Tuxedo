package com.maxaaustin.tuxedo.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxaaustin.tuxedo.R;
import com.maxaaustin.tuxedo.view.UserProfileClient;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private Button mFavorites;
    private ImageView mProfilePicture;
    private TextView mUsername;
    private OnFragmentInteractionListener mListener;
    final TwitterSession sess = TwitterCore.getInstance().getSessionManager().getActiveSession();
    final TwitterAuthConfig profAuth = TwitterCore.getInstance().getAuthConfig();


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String username, int resID) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Retrofit retro = twitterUserRetrofit(sess, profAuth);
//        UserProfileClient userProfileClient = retro.create(UserProfileClient.class);
//        Call<User> call = userProfileClient.getUserDetails(sess.getUserName());
//        call.enqueue(new com.twitter.sdk.android.core.Callback<com.twitter.sdk.android.core.models.User>() {
//
//            /**
//             * Called when call completes successfully.
//             *
//             * @param result the parsed result.
//             */
//            @Override
//            public void success(com.twitter.sdk.android.core.Result<com.twitter.sdk.android.core.models.User> result) {
//                User user = result.data;
//                mUsername = new android.widget.TextView(getContext()).findViewById(com.maxaaustin.tuxedo.R.id.main_username);
//                mProfilePicture = new ImageView(getContext()).findViewById(com.maxaaustin.tuxedo.R.id.home_profile_pic);
//                mUsername.setText(user.name);
//                Picasso.with(getContext()).load(user.profileImageUrl).into(mProfilePicture);
//            }
//
//            /**
//             * Unsuccessful call due to network failure, non-2XX status code, or unexpected
//             * exception.
//             *
//             * @param exception
//             */
//            @Override
//            public void failure(com.twitter.sdk.android.core.TwitterException exception) {
//                android.widget.Toast.makeText(HomeFragment.this, "Failed to retrieve user details.", android.widget.Toast.LENGTH_LONG).show();
//            }
//        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * Makes a REST API call to the Twitter REST API, passing in the current TwitterSession and OAuth configuration using the Retrofit and OkHttpClient libraries included with the Twitter Kit Android SDK.
     * @param sess
     * @param authConfig
     * @return
     */
    public Retrofit twitterUserRetrofit(TwitterSession sess, TwitterAuthConfig authConfig){
        return new Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/").addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create()).client(new okhttp3.OkHttpClient.Builder().addInterceptor(new com.twitter.sdk.android.core.internal.network.OAuth1aInterceptor(sess, authConfig)).build()).build();
    }

}
