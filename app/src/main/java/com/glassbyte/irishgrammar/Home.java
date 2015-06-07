package com.glassbyte.irishgrammar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Home extends Fragment{

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ScrollView mLayout = (ScrollView) inflater.inflate(R.layout.fragment_home, container, false);

		Button mDonate = (Button) mLayout.findViewById(R.id.donate);
		mDonate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("market://search?q=pub:<GlassByte>"));
				startActivity(intent);
			}
		});

		View addButton = mLayout.findViewById(R.id.add_button);
		addButton.setOutlineProvider(new ViewOutlineProvider() {
			@Override
			public void getOutline(View view, Outline outline) {
				int diameter = getResources().getDimensionPixelSize(R.dimen.diameter);
				outline.setOval(0, 0, diameter, diameter);
			}
		});
		addButton.setClipToOutline(true);

		return mLayout;
	}
}
