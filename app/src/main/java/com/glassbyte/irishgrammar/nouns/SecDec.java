package com.glassbyte.irishgrammar.nouns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glassbyte.irishgrammar.R;


public class SecDec extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.secdec, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Earth");
        return rootView;
    }

}
