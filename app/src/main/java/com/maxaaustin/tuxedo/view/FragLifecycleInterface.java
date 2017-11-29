package com.maxaaustin.tuxedo.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by michael on 11/29/2017.
 */

public interface FragLifecycleInterface {

    void onCreateView(LayoutInflater inflater, ViewGroup container,
                 Bundle savedInstanceState);

    void onAttach(Context context);

    void onDetach();
}
