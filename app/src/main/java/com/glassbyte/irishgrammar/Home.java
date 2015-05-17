package com.glassbyte.irishgrammar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Home extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ScrollView mLayout = (ScrollView) inflater.inflate(R.layout.fragment_home,container,false);
		Button mDonate = (Button) mLayout.findViewById(R.id.donate);

		mDonate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"Giz ur change luv",Toast.LENGTH_SHORT).show();
			}
		});

		return mLayout;
	}
}
