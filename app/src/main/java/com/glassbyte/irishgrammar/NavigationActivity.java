package com.glassbyte.irishgrammar;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.glassbyte.irishgrammar.introduction.LanguageTips;
import com.glassbyte.irishgrammar.introduction.WhatMakesThisDifferent;
import com.glassbyte.irishgrammar.introduction.WhyLearnIrish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigationActivity extends FragmentActivity {
	private DrawerLayout mDrawerLayout;
	ImageView home;
	Fragment fragment = null;
	TextView appname;
	ExpandableListView expListView;
	HashMap<String, List<String>> listDataChild;
	ExpandableListAdapter listAdapter;
	List<String> listDataHeader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation);
		home = (ImageView)findViewById(R.id.home);
		home.setOnClickListener(homeOnclickListener);
		appname = (TextView)findViewById(R.id.appname);
		setUpDrawer();
	}

	private void setUpDrawer() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
		mDrawerLayout.setDrawerListener(mDrawerListener);
		expListView = (ExpandableListView) findViewById(R.id.lvExp);
		prepareListData();
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		// setting list adapter
		expListView.setAdapter(listAdapter);
		fragment = new MercuryFragment();
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		mDrawerLayout.closeDrawer(expListView);

		expListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				switch (groupPosition) {
				case 0:
					switch (childPosition) {
					case 0:
						fragment = new MercuryFragment();
						break;
					case 1:
						fragment = new VenusFragment();
						break;
					case 2:
						fragment = new EarthFragment();
						break;
					default:
						break;
					}
					break;

				case 1:
					switch (childPosition) {
					case 0:
						fragment = new WhyLearnIrish();
						break;
					case 1:
						fragment = new WhatMakesThisDifferent();
						break;
					case 2:
						fragment = new LanguageTips();
						break;
					default:
						break;
					}
					break;

				case 2:
					switch (childPosition) {
					case 0:
						fragment = new MercuryFragment();
						break;
					case 1:
						fragment = new VenusFragment();
						break;
					case 2:
						fragment = new EarthFragment();
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}
				getSupportFragmentManager()
						.beginTransaction()
						.setCustomAnimations(R.anim.abc_grow_fade_in_from_bottom,
								R.anim.abc_shrink_fade_out_from_bottom)
						.replace(R.id.content_frame, fragment)
						.commit();
				mDrawerLayout.closeDrawer(expListView);
				return false;
			}
		});
	}

	View.OnClickListener homeOnclickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(mDrawerLayout.isDrawerOpen(expListView)){
				mDrawerLayout.closeDrawer(expListView);
			}else{
				mDrawerLayout.openDrawer(expListView);
			}
		}
	};

	private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

			switch(position){
			case 0:
				fragment = new MercuryFragment();
				break;
			case 1:
				fragment = new VenusFragment();
				break;
			case 2:
				fragment = new EarthFragment();
				break;
			default:
				return;
			}

			getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

			mDrawerLayout.closeDrawer(expListView);
		}
	};

	// Catch the events related to the drawer to arrange views according to this
	// action if necessary...
	private DrawerListener mDrawerListener = new DrawerListener() {

		@Override
		public void onDrawerStateChanged(int status) {

		}

		@Override
		public void onDrawerSlide(View view, float slideArg) {

		}

		@Override
		public void onDrawerOpened(View view) {
		}

		@Override
		public void onDrawerClosed(View view) {
		}
	};

	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Home");
		listDataHeader.add("Introduction");
		listDataHeader.add("Phonetics");
		listDataHeader.add("Mutations");
		listDataHeader.add("Interrogatives");
		listDataHeader.add("Gender");
		listDataHeader.add("Articles");
		listDataHeader.add("Cases");
		listDataHeader.add("Nouns");
		listDataHeader.add("Adjectives");
		listDataHeader.add("Inflection");
		listDataHeader.add("Verbs");
		listDataHeader.add("Pronouns");
		listDataHeader.add("Syntax");
		listDataHeader.add("Clauses");
		listDataHeader.add("Prepositions");
		listDataHeader.add("Numbers");
		listDataHeader.add("Quantity");
		listDataHeader.add("Other");
		listDataHeader.add("About Us");

		// Adding child data
		List<String> home = new ArrayList<String>();
		home.add("Home");

		List<String> introduction = new ArrayList<String>();
		introduction.add("Why learn Irish?");
		introduction.add("What makes this different?");
		introduction.add("Language tips");

		List<String> phonetics = new ArrayList<String>();
		phonetics.add("Sounds of a Language");
		phonetics.add("Vowels");
		phonetics.add("Consonants");
		phonetics.add("Diphthongs");
		phonetics.add("Stress");
		phonetics.add("Lenition");
		phonetics.add("Eclipsis");
		phonetics.add("Prefixing");
		
		List<String> mutations = new ArrayList<String>();
		mutations.add("A.B. de Villiers");
		mutations.add("M.S. Dhoni");
		mutations.add("K.C. Sangakkara");

		List<String> interrogatives = new ArrayList<String>();
		interrogatives.add("1");
		interrogatives.add("2");
		interrogatives.add("3");

		List<String> gender = new ArrayList<String>();
		gender.add("1");
		gender.add("2");
		gender.add("3");

		List<String> articles = new ArrayList<String>();
		articles.add("1");
		articles.add("2");
		articles.add("3");

		List<String> cases = new ArrayList<String>();
		cases.add("1");
		cases.add("2");
		cases.add("3");

		List<String> nouns = new ArrayList<String>();
		nouns.add("1");
		nouns.add("2");
		nouns.add("3");

		List<String> adjectives = new ArrayList<String>();
		adjectives.add("1");
		adjectives.add("2");
		adjectives.add("3");

		List<String> inflection = new ArrayList<String>();
		inflection.add("1");
		inflection.add("2");
		inflection.add("3");

		List<String> verbs = new ArrayList<String>();
		verbs.add("1");
		verbs.add("2");
		verbs.add("3");

		List<String> pronouns = new ArrayList<String>();
		pronouns.add("1");
		pronouns.add("2");
		pronouns.add("3");

		List<String> syntax = new ArrayList<String>();
		syntax.add("1");
		syntax.add("2");
		syntax.add("3");

		List<String> clauses = new ArrayList<String>();
		clauses.add("1");
		clauses.add("2");
		clauses.add("3");

		List<String> prepositions = new ArrayList<String>();
		prepositions.add("1");
		prepositions.add("2");
		prepositions.add("3");

		List<String> numbers = new ArrayList<String>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");

		List<String> quantities = new ArrayList<String>();
		quantities.add("1");
		quantities.add("2");
		quantities.add("3");

		List<String> other = new ArrayList<String>();
		other.add("1");
		other.add("2");
		other.add("3");

		List<String> aboutus = new ArrayList<String>();
		aboutus.add("GlassByte");

		listDataChild.put(listDataHeader.get(0), home); // Header, Child data
		listDataChild.put(listDataHeader.get(1), introduction);
		listDataChild.put(listDataHeader.get(2), phonetics);
		listDataChild.put(listDataHeader.get(3), mutations);
		listDataChild.put(listDataHeader.get(4), interrogatives);
		listDataChild.put(listDataHeader.get(5), gender);
		listDataChild.put(listDataHeader.get(6), articles);
		listDataChild.put(listDataHeader.get(7), cases);
		listDataChild.put(listDataHeader.get(8), nouns);
		listDataChild.put(listDataHeader.get(9), adjectives);
		listDataChild.put(listDataHeader.get(10), inflection);
		listDataChild.put(listDataHeader.get(11), verbs);
		listDataChild.put(listDataHeader.get(12), pronouns);
		listDataChild.put(listDataHeader.get(13), syntax);
		listDataChild.put(listDataHeader.get(14), clauses);
		listDataChild.put(listDataHeader.get(15), prepositions);
		listDataChild.put(listDataHeader.get(16), numbers);
		listDataChild.put(listDataHeader.get(17), quantities);
		listDataChild.put(listDataHeader.get(18), other);
		listDataChild.put(listDataHeader.get(19), aboutus);
	}

	public class ExpandableListAdapter extends BaseExpandableListAdapter {

		private Context _context;
		private List<String> _listDataHeader; // header titles
		// child data in format of header title, child title
		private HashMap<String, List<String>> _listDataChild;

		public ExpandableListAdapter(Context context, List<String> listDataHeader,
				HashMap<String, List<String>> listChildData) {
			this._context = context;
			this._listDataHeader = listDataHeader;
			this._listDataChild = listChildData;
		}

		@Override
		public Object getChild(int groupPosition, int childPosititon) {
			return this._listDataChild.get(this._listDataHeader.get(groupPosition))
					.get(childPosititon);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {

			final String childText = (String) getChild(groupPosition, childPosition);

			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_item, null);
			}

			TextView txtListChild = (TextView) convertView
					.findViewById(R.id.lblListItem);

			txtListChild.setText(childText);
			return convertView;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return this._listDataChild.get(this._listDataHeader.get(groupPosition))
					.size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return this._listDataHeader.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return this._listDataHeader.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			String headerTitle = (String) getGroup(groupPosition);
			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_group, null);
			}

			TextView lblListHeader = (TextView) convertView
					.findViewById(R.id.lblListHeader);
			lblListHeader.setTypeface(null, Typeface.BOLD);
			lblListHeader.setText(headerTitle);

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}
}
