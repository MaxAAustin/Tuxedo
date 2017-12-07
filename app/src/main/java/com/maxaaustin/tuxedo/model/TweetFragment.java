package com.maxaaustin.tuxedo.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxaaustin.tuxedo.R;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TweetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TweetFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private OnFragmentInteractionListener mListener;

    TwitterApiClient mTwitterApiClient = com.twitter.sdk.android.core.TwitterCore.getInstance().getApiClient();
    StatusesService statusesService = mTwitterApiClient.getStatusesService();
    retrofit2.Call<com.twitter.sdk.android.core.models.Tweet> call = statusesService.show(524971209851543553L, null, null, null);

    public TweetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tweet, container, false);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(com.maxaaustin.tuxedo.R.id.rv_tweet_timeline);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SearchTimeline searchTimeline = new SearchTimeline.Builder().query("#MeToo").maxItemsPerRequest(50).build();

        final TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(getContext()).setTimeline(searchTimeline).setViewStyle(com.maxaaustin.tuxedo.R.style.tw__TweetDarkStyle).build();
        recyclerView.setAdapter(adapter);

        return recyclerView;
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
