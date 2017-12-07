package com.maxaaustin.tuxedo;

import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by maaus on 12/7/2017.
 */

public class PoliticsFragment extends android.support.v7.app.AppCompatDialogFragment{
    public PoliticsFragment() {
        super();
    }

    @Override
    public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());

        android.view.LayoutInflater inflater = getActivity().getLayoutInflater();
        android.view.View view = inflater.inflate(com.maxaaustin.tuxedo.R.layout.fragment_political,null,false);

        android.widget.SeekBar seekBar = view.findViewById(com.maxaaustin.tuxedo.R.id.politics_sb);
        seekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            int current = 0;
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                current = progress;
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                current = seekBar.getProgress();
                if(current<40){
                    android.widget.Toast.makeText(getContext(),"You're a Progressive", android.widget.Toast.LENGTH_SHORT).show();

                }else if(current>= 40 && current<61){
                    android.widget.Toast.makeText(getContext(),"You're Independent", android.widget.Toast.LENGTH_SHORT).show();

                }else{
                    android.widget.Toast.makeText(getContext(), "You're Conservative", android.widget.Toast.LENGTH_SHORT).show();

                }

            }
        });

        builder.setView(view).setTitle(com.maxaaustin.tuxedo.R.string.political_views).setNegativeButton(com.maxaaustin.tuxedo.R.string.cancel, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(android.content.DialogInterface dialog, int which) {

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

    }
}
