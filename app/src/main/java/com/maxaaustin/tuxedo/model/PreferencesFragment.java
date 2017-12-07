package com.maxaaustin.tuxedo.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maxaaustin.tuxedo.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PreferencesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PreferencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreferencesFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename and change types of parameters




    private OnFragmentInteractionListener mListener;

    public PreferencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreferencesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreferencesFragment newInstance(String param1, String param2) {
        PreferencesFragment fragment = new PreferencesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preferences, container, false);

        Button age= view.findViewById(com.maxaaustin.tuxedo.R.id.age_button);
        Button gender= view.findViewById(com.maxaaustin.tuxedo.R.id.gender_button);
        Button orientation= view.findViewById(com.maxaaustin.tuxedo.R.id.orientation_button);
        Button religion= view.findViewById(com.maxaaustin.tuxedo.R.id.religion_button);
        Button politics= view.findViewById(com.maxaaustin.tuxedo.R.id.politics_button);

        age.setOnClickListener(this);
        gender.setOnClickListener(this);
        orientation.setOnClickListener(this);
        religion.setOnClickListener(this);
        politics.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(android.view.View v) {

        android.app.AlertDialog.Builder mBuilder = new android.app.AlertDialog.Builder(getContext());
        View mView;

        switch (v.getId()){
            case R.id.age_button:
                com.maxaaustin.tuxedo.AgeFragment af = new com.maxaaustin.tuxedo.AgeFragment();
                af.show(getFragmentManager(),"age dialog");
                break;
            case R.id.gender_button:
                com.maxaaustin.tuxedo.GenderFragment gf = new com.maxaaustin.tuxedo.GenderFragment();
                gf.show(getFragmentManager(), "gender dialog");
                break;
            case R.id.orientation_button:
                com.maxaaustin.tuxedo.OrientationFragment of = new com.maxaaustin.tuxedo.OrientationFragment();
                of.show(getFragmentManager(), "orientation dialog");
                break;
            case R.id.religion_button:
                getFragmentManager().beginTransaction().commit();
                break;
            case R.id.politics_button:
                getFragmentManager().beginTransaction().commit();
                break;
        }

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
