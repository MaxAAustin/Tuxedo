package com.maxaaustin.tuxedo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrientationFragment extends android.support.v7.app.AppCompatDialogFragment {


    public OrientationFragment() {
        // Required empty public constructor
    }


    private OnFragmentInteractionListener mListener;


    @Override
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(com.maxaaustin.tuxedo.R.layout.fragment_orientation,null,false);

        Spinner orientation = view.findViewById(com.maxaaustin.tuxedo.R.id.orientation_dialog_spinner);
        android.widget.ArrayAdapter<CharSequence> adapter = android.widget.ArrayAdapter.createFromResource(getContext(), com.maxaaustin.tuxedo.R.array.orientationArray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orientation.setAdapter(adapter);
        builder.setView(view).setNegativeButton(com.maxaaustin.tuxedo.R.string.cancel, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialog, int which) {
                dismiss();
            }
        }).setPositiveButton(com.maxaaustin.tuxedo.R.string.confirm, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialog, int which) {

            }
        });
        return builder.create();
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
