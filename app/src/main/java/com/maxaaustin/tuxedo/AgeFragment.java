package com.maxaaustin.tuxedo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgeFragment extends android.support.v7.app.AppCompatDialogFragment {

    private com.maxaaustin.tuxedo.AgeFragment.AgeDialogListener listener;

    public AgeFragment() {
        // Required empty public constructor
    }

    @Override
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(com.maxaaustin.tuxedo.R.layout.fragment_age_dialog,null,false);
        android.widget.EditText age=view.findViewById(com.maxaaustin.tuxedo.R.id.age_et);
        String years = age.getText().toString();
        age.setHint(years);
        builder.setView(view).setTitle(R.string.age).setNegativeButton(com.maxaaustin.tuxedo.R.string.cancel, new android.content.DialogInterface.OnClickListener() {
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

    @Override
    public void onAttach(android.content.Context context) {
        super.onAttach(context);

        try {
            listener = (com.maxaaustin.tuxedo.AgeFragment.AgeDialogListener)context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface AgeDialogListener{
        void applyAge(String num);
    }

}
