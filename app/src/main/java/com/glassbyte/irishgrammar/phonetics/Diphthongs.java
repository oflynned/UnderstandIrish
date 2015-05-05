package com.glassbyte.irishgrammar.phonetics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glassbyte.irishgrammar.R;


public class Diphthongs extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diphthongs, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Earth");
        return rootView;
    }

}
