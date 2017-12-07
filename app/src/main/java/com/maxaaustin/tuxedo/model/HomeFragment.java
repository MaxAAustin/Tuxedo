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
import com.twitter.sdk.android.core.Callback;
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
    private final String CONSUMER_KEY= "IMk3fgM2AXuMVNVQFWgVwAWJb";
    private final String CONSUMER_SECRET= "OfR0AcJdTOhPxzcR6Z8Zf66sOrrMFdKYtSr5vJVoIR1foR4aKk";

    private Button mFavorites;
    private OnFragmentInteractionListener mListener;


    private TwitterAuthConfig auth = new TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET);

    TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
    com.twitter.sdk.android.core.TwitterAuthToken authToken = session.getAuthToken();
    String token = authToken.token;
    String secret = authToken.secret;




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
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final ImageView img = (ImageView) root.findViewById(com.maxaaustin.tuxedo.R.id.home_profile_pic);
        TextView name = root.findViewById(com.maxaaustin.tuxedo.R.id.main_username);
        name.setText(session.getUserName());

        retrofit2.Call<com.twitter.sdk.android.core.models.User> call= TwitterCore.getInstance().getApiClient(session).getAccountService().verifyCredentials(true, false, false);

        call.enqueue(new Callback<com.twitter.sdk.android.core.models.User>(){

            /**
             * Called when call completes successfully.
             *
             * @param result the parsed result.
             */
            @Override
            public void success(com.twitter.sdk.android.core.Result<com.twitter.sdk.android.core.models.User> result) {
                android.util.Log.d("Profile Response",result.data.profileImageUrl);
                User user = result.data;
                Picasso.with(getContext()).load(user.profileImageUrl.replace("_normal","")).into(img);

            }

            /**
             * Unsuccessful call due to network failure, non-2XX status code, or unexpected
             * exception.
             *
             * @param exception
             */
            @Override
            public void failure(com.twitter.sdk.android.core.TwitterException exception) {

            }
        });

        // Inflate the layout for this fragment
        return root;
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



}
