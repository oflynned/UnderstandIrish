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
		mDrawerLayout.setScrimColor(getResources().getColor(R.color.fade_drawer));
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
		phonetics.add("Sounds of a language");
		phonetics.add("Vowels");
		phonetics.add("Consonants");
		phonetics.add("Diphthongs");
		phonetics.add("Stress");
		phonetics.add("Lenition");
		phonetics.add("Eclipsis");
		phonetics.add("Prefixing");
		
		List<String> mutations = new ArrayList<String>();
		mutations.add("What is a mutation?");
		mutations.add("New sounds");
		mutations.add("Lenition");
		mutations.add("Eclipsis");
		mutations.add("Prefixing");

		List<String> interrogatives = new ArrayList<String>();
		interrogatives.add("What is an interrogative?");
		interrogatives.add("What?");
		interrogatives.add("Which?");
		interrogatives.add("Who?");
		interrogatives.add("When?");
		interrogatives.add("Why?");
		interrogatives.add("How?");
		interrogatives.add("How much/many?");

		List<String> gender = new ArrayList<String>();
		gender.add("What is a gender?");
		gender.add("Masculine");
		gender.add("Feminine");
		gender.add("Neuter");

		List<String> articles = new ArrayList<String>();
		articles.add("What is an article?");
		articles.add("Usage");
		articles.add("The definite article");
		articles.add("The indefinite article");
		articles.add("Declining articles");
		articles.add("Prepositional articles");
		articles.add("Abstract articles");

		List<String> cases = new ArrayList<String>();
		cases.add("What is a case?");
		cases.add("Nominative case");
		cases.add("Accusative case");
		cases.add("Dative case");
		cases.add("Genitive case");
		cases.add("Partitive case");
		cases.add("Vocative case");

		List<String> nouns = new ArrayList<String>();
		nouns.add("What is a noun?");
		nouns.add("Types of nouns");
		nouns.add("1st declension");
		nouns.add("2nd declension");
		nouns.add("3rd declension");
		nouns.add("4th declension");
		nouns.add("5th declension");
		nouns.add("Irregular declensions");
		nouns.add("Verbal nouns");
		nouns.add("Abstract nouns");
		nouns.add("Apposition & proper nouns");

		List<String> adjectives = new ArrayList<String>();
		adjectives.add("What is an adjective?");
		adjectives.add("Types of adjectives");
		adjectives.add("Predicative adjectives");
		adjectives.add("Attributive adjectives");
		adjectives.add("Pronominal adjectives");
		adjectives.add("Declination of adjectives");
		adjectives.add("Comparative form");
		adjectives.add("Superlative form");
		adjectives.add("Equative form");
		adjectives.add("Affical adjectives");
		adjectives.add("Verbal adjectives");

		List<String> inflection = new ArrayList<String>();
		inflection.add("What is inflection?");
		inflection.add("Vowel harmony");
		inflection.add("Palatalisation");
		inflection.add("Depalatalisation");
		inflection.add("Syncopation");
		inflection.add("Voicing");
		inflection.add("Remembering this stuff");

		List<String> verbs = new ArrayList<String>();
		verbs.add("What are verbs?");
		verbs.add("Tense");
		verbs.add("Mood");
		verbs.add("Conjugation");
		verbs.add("Past tense");
		verbs.add("Present tense");
		verbs.add("Future tense");
		verbs.add("Pluperfect tense");
		verbs.add("Conditional tense");
		verbs.add("Subjunctive tense");
		verbs.add("Irregular verbs");
		verbs.add("Defective verbs");
		verbs.add("Verbal derivatives");

		List<String> pronouns = new ArrayList<String>();
		pronouns.add("What are pronouns?");
		pronouns.add("Personal pronouns");
		pronouns.add("Emphatic pronouns");
		pronouns.add("Polite pronouns");
		pronouns.add("Defective pronouns");
		pronouns.add("Possessive pronouns");
		pronouns.add("Substantive possessive pronouns");
		pronouns.add("Prepositional pronouns");
		pronouns.add("Agreement");

		List<String> syntax = new ArrayList<String>();
		syntax.add("What is syntax?");
		syntax.add("Word order");
		syntax.add("Questions");
		syntax.add("Copular syntax");
		syntax.add("Special syntax");
		syntax.add("Derivations");

		List<String> clauses = new ArrayList<String>();
		clauses.add("What is a clause?");
		clauses.add("Linking clauses");
		clauses.add("Conditional clauses");
		clauses.add("Relative clauses");
		clauses.add("Miscellaneous");

		List<String> prepositions = new ArrayList<String>();
		prepositions.add("What is a preposition?");
		prepositions.add("Conjugating prepositions");
		prepositions.add("Unconjugated prepositions");
		prepositions.add("Genitive prepositions");
		prepositions.add("Saying 'For'");

		List<String> numbers = new ArrayList<String>();
		numbers.add("Types of numbers");
		numbers.add("Vocative");
		numbers.add("Quantitative");
		numbers.add("Ordinal");
		numbers.add("Personal");
		numbers.add("Time");
		numbers.add("Decimals & fractions");
		numbers.add("Miscellaneous");

		List<String> quantities = new ArrayList<String>();
		quantities.add("Expressing amounts");
		quantities.add("Partitive quantities");
		quantities.add("Indeterminative quantities");

		List<String> other = new ArrayList<String>();
		other.add("Internet acronyms");
		other.add("Vocab lists");

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
