package com.glassbyte.irishgrammar;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.glassbyte.irishgrammar.aboutus.AboutUs;
import com.glassbyte.irishgrammar.adjectives.AffAdj;
import com.glassbyte.irishgrammar.adjectives.AttAdj;
import com.glassbyte.irishgrammar.adjectives.CompAdj;
import com.glassbyte.irishgrammar.adjectives.EqAdj;
import com.glassbyte.irishgrammar.adjectives.PredAdj;
import com.glassbyte.irishgrammar.adjectives.ProAdj;
import com.glassbyte.irishgrammar.adjectives.SuperAdj;
import com.glassbyte.irishgrammar.adjectives.TypesOfAdjectives;
import com.glassbyte.irishgrammar.adjectives.VerbalAdj;
import com.glassbyte.irishgrammar.adjectives.WhatIsAnAdjective;
import com.glassbyte.irishgrammar.articles.DecliningArticles;
import com.glassbyte.irishgrammar.articles.DefArticle;
import com.glassbyte.irishgrammar.articles.IndefArt;
import com.glassbyte.irishgrammar.articles.PrepositionalArticles;
import com.glassbyte.irishgrammar.articles.Usage;
import com.glassbyte.irishgrammar.articles.WhatIsAnArticle;
import com.glassbyte.irishgrammar.cases.AccCase;
import com.glassbyte.irishgrammar.cases.DatCase;
import com.glassbyte.irishgrammar.cases.GenCase;
import com.glassbyte.irishgrammar.cases.NomCase;
import com.glassbyte.irishgrammar.cases.ParCase;
import com.glassbyte.irishgrammar.cases.VocCase;
import com.glassbyte.irishgrammar.cases.WhatIsACase;
import com.glassbyte.irishgrammar.clauses.CondClauses;
import com.glassbyte.irishgrammar.clauses.LinkClauses;
import com.glassbyte.irishgrammar.clauses.Miscellaneous;
import com.glassbyte.irishgrammar.clauses.RelClauses;
import com.glassbyte.irishgrammar.clauses.WhatIsAClause;
import com.glassbyte.irishgrammar.gender.Feminine;
import com.glassbyte.irishgrammar.gender.Masculine;
import com.glassbyte.irishgrammar.gender.Neuter;
import com.glassbyte.irishgrammar.gender.WhatIsAGender;
import com.glassbyte.irishgrammar.inflection.Depalatalisation;
import com.glassbyte.irishgrammar.inflection.Palatalisation;
import com.glassbyte.irishgrammar.inflection.Remembering;
import com.glassbyte.irishgrammar.inflection.Syncopation;
import com.glassbyte.irishgrammar.inflection.Voicing;
import com.glassbyte.irishgrammar.inflection.VowelHarmony;
import com.glassbyte.irishgrammar.inflection.WhatIsInf;
import com.glassbyte.irishgrammar.interrogatives.How;
import com.glassbyte.irishgrammar.interrogatives.HowMany;
import com.glassbyte.irishgrammar.interrogatives.What;
import com.glassbyte.irishgrammar.interrogatives.WhatIsAnInterrogative;
import com.glassbyte.irishgrammar.interrogatives.When;
import com.glassbyte.irishgrammar.interrogatives.Which;
import com.glassbyte.irishgrammar.interrogatives.Who;
import com.glassbyte.irishgrammar.interrogatives.Why;
import com.glassbyte.irishgrammar.introduction.LanguageTips;
import com.glassbyte.irishgrammar.introduction.WhatMakesThisDifferent;
import com.glassbyte.irishgrammar.introduction.WhyLearnIrish;
import com.glassbyte.irishgrammar.mutations.NewSounds;
import com.glassbyte.irishgrammar.mutations.WhatIsAMutation;
import com.glassbyte.irishgrammar.nouns.AbstractNouns;
import com.glassbyte.irishgrammar.nouns.Apposition;
import com.glassbyte.irishgrammar.nouns.FifthDec;
import com.glassbyte.irishgrammar.nouns.FirstDec;
import com.glassbyte.irishgrammar.nouns.FourthDec;
import com.glassbyte.irishgrammar.nouns.IrrDec;
import com.glassbyte.irishgrammar.nouns.SecDec;
import com.glassbyte.irishgrammar.nouns.ThirdDec;
import com.glassbyte.irishgrammar.nouns.TypesOfNouns;
import com.glassbyte.irishgrammar.nouns.VerbalNouns;
import com.glassbyte.irishgrammar.nouns.WhatIsANoun;
import com.glassbyte.irishgrammar.numbers.DecFrac;
import com.glassbyte.irishgrammar.numbers.Ordinal;
import com.glassbyte.irishgrammar.numbers.Personal;
import com.glassbyte.irishgrammar.numbers.Quan;
import com.glassbyte.irishgrammar.numbers.Time;
import com.glassbyte.irishgrammar.numbers.TypesOfNo;
import com.glassbyte.irishgrammar.numbers.Voc;
import com.glassbyte.irishgrammar.other.Acronyms;
import com.glassbyte.irishgrammar.other.Vocab;
import com.glassbyte.irishgrammar.phonetics.Consonants;
import com.glassbyte.irishgrammar.phonetics.Diphthongs;
import com.glassbyte.irishgrammar.phonetics.Eclipsis;
import com.glassbyte.irishgrammar.phonetics.Lenition;
import com.glassbyte.irishgrammar.phonetics.Prefixing;
import com.glassbyte.irishgrammar.phonetics.SoundsOfALanguage;
import com.glassbyte.irishgrammar.phonetics.Stress;
import com.glassbyte.irishgrammar.phonetics.Vowels;
import com.glassbyte.irishgrammar.prepositions.ConjPrep;
import com.glassbyte.irishgrammar.prepositions.For;
import com.glassbyte.irishgrammar.prepositions.GenPrep;
import com.glassbyte.irishgrammar.prepositions.UnconjPrep;
import com.glassbyte.irishgrammar.prepositions.WhatIsAPrep;
import com.glassbyte.irishgrammar.pronouns.Agreement;
import com.glassbyte.irishgrammar.pronouns.DefPro;
import com.glassbyte.irishgrammar.pronouns.EmphPro;
import com.glassbyte.irishgrammar.pronouns.PolPro;
import com.glassbyte.irishgrammar.pronouns.PossPro;
import com.glassbyte.irishgrammar.pronouns.PrepPro;
import com.glassbyte.irishgrammar.pronouns.SubPossPro;
import com.glassbyte.irishgrammar.pronouns.WhatIsAPronoun;
import com.glassbyte.irishgrammar.quantity.ExpQuantity;
import com.glassbyte.irishgrammar.quantity.IndetQuan;
import com.glassbyte.irishgrammar.quantity.PartQuan;
import com.glassbyte.irishgrammar.syntax.CopularSyn;
import com.glassbyte.irishgrammar.syntax.Deriv;
import com.glassbyte.irishgrammar.syntax.Questions;
import com.glassbyte.irishgrammar.syntax.SpecSyn;
import com.glassbyte.irishgrammar.syntax.WhatIsSyntax;
import com.glassbyte.irishgrammar.syntax.WordOrder;
import com.glassbyte.irishgrammar.verbs.ConditionalTense;
import com.glassbyte.irishgrammar.verbs.Conjugation;
import com.glassbyte.irishgrammar.verbs.DefVerbs;
import com.glassbyte.irishgrammar.verbs.FutureTense;
import com.glassbyte.irishgrammar.verbs.IrrVerbs;
import com.glassbyte.irishgrammar.verbs.Mood;
import com.glassbyte.irishgrammar.verbs.PastTense;
import com.glassbyte.irishgrammar.verbs.PluperfectTense;
import com.glassbyte.irishgrammar.verbs.PresentTense;
import com.glassbyte.irishgrammar.verbs.SubjTense;
import com.glassbyte.irishgrammar.verbs.Tense;
import com.glassbyte.irishgrammar.verbs.VerbalDerivatives;
import com.glassbyte.irishgrammar.verbs.WhatIsAVerb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigationActivity extends FragmentActivity {
    private DrawerLayout mDrawerLayout;

    Fragment fragment = null;
    ExpandableListView expListView;
    HashMap<String, List<String>> listDataChild;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

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
        fragment = new Home();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        mDrawerLayout.closeDrawer(expListView);

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    //home
                    case 0:
                        switch (childPosition) {
                            case 0:
                                fragment = new Home();
                            default:
                                break;
                        }
                        break;

                    //intro
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

                    //phonetics
                    case 2:
                        switch (childPosition) {
                            case 0:
                                fragment = new SoundsOfALanguage();
                                break;
                            case 1:
                                fragment = new Vowels();
                                break;
                            case 2:
                                fragment = new Consonants();
                                break;
                            case 3:
                                fragment = new Diphthongs();
                                break;
                            case 4:
                                fragment = new Stress();
                                break;
                            case 5:
                                fragment = new Lenition();
                                break;
                            case 6:
                                fragment = new Eclipsis();
                                break;
                            case 7:
                                fragment = new Prefixing();
                                break;
                            default:
                                break;
                        }
                        break;

                    //mutations
                    case 3:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAMutation();
                                break;
                            case 1:
                                fragment = new NewSounds();
                                break;
                            case 2:
                                fragment = new com.glassbyte.irishgrammar.mutations.Lenition();
                                break;
                            case 3:
                                fragment = new com.glassbyte.irishgrammar.mutations.Eclipsis();
                                break;
                            case 4:
                                fragment = new com.glassbyte.irishgrammar.mutations.Prefixing();
                            default:
                                break;
                        }
                        break;

                    //Interrogatives
                    case 4:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAnInterrogative();
                                break;
                            case 1:
                                fragment = new What();
                                break;
                            case 2:
                                fragment = new Which();
                                break;
                            case 3:
                                fragment = new Who();
                                break;
                            case 4:
                                fragment = new When();
                                break;
                            case 5:
                                fragment = new Why();
                                break;
                            case 6:
                                fragment = new How();
                                break;
                            case 7:
                                fragment = new HowMany();
                                break;
                            default:
                                break;
                        }
                        break;

                    //gender
                    case 5:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAGender();
                                break;
                            case 1:
                                fragment = new Masculine();
                                break;
                            case 2:
                                fragment = new Feminine();
                                break;
                            case 3:
                                fragment = new Neuter();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Articles
                    case 6:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAnArticle();
                                break;
                            case 1:
                                fragment = new Usage();
                                break;
                            case 2:
                                fragment = new DefArticle();
                                break;
                            case 3:
                                fragment = new IndefArt();
                                break;
                            case 4:
                                fragment = new DecliningArticles();
                                break;
                            case 5:
                                fragment = new PrepositionalArticles();
                                break;
                            default:
                                break;
                        }
                        break;

                    //cases
                    case 7:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsACase();
                                break;
                            case 1:
                                fragment = new NomCase();
                                break;
                            case 2:
                                fragment = new AccCase();
                                break;
                            case 3:
                                fragment = new DatCase();
                                break;
                            case 4:
                                fragment = new GenCase();
                                break;
                            case 5:
                                fragment = new ParCase();
                                break;
                            case 6:
                                fragment = new VocCase();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Nouns
                    case 8:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsANoun();
                                break;
                            case 1:
                                fragment = new TypesOfNouns();
                                break;
                            case 2:
                                fragment = new FirstDec();
                                break;
                            case 3:
                                fragment = new SecDec();
                                break;
                            case 4:
                                fragment = new ThirdDec();
                                break;
                            case 5:
                                fragment = new FourthDec();
                                break;
                            case 6:
                                fragment = new FifthDec();
                                break;
                            case 7:
                                fragment = new IrrDec();
                                break;
                            case 8:
                                fragment = new VerbalNouns();
                                break;
                            case 9:
                                fragment = new AbstractNouns();
                                break;
                            case 10:
                                fragment = new Apposition();
                                break;
                            default:
                                break;
                        }
                        break;

                    //adjectives
                    case 9:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAnAdjective();
                                break;
                            case 1:
                                fragment = new TypesOfAdjectives();
                                break;
                            case 2:
                                fragment = new PredAdj();
                                break;
                            case 3:
                                fragment = new AttAdj();
                                break;
                            case 4:
                                fragment = new ProAdj();
                                break;
                            case 5:
                                fragment = new DecliningArticles();
                                break;
                            case 6:
                                fragment = new CompAdj();
                                break;
                            case 7:
                                fragment = new SuperAdj();
                                break;
                            case 8:
                                fragment = new EqAdj();
                                break;
                            case 9:
                                fragment = new AffAdj();
                                break;
                            case 10:
                                fragment = new VerbalAdj();
                                break;
                            default:
                                break;
                        }
                        break;

                    //inflection
                    case 10:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsInf();
                                break;
                            case 1:
                                fragment = new VowelHarmony();
                                break;
                            case 2:
                                fragment = new Palatalisation();
                                break;
                            case 3:
                                fragment = new Depalatalisation();
                                break;
                            case 4:
                                fragment = new Syncopation();
                                break;
                            case 5:
                                fragment = new Voicing();
                                break;
                            case 6:
                                fragment = new Remembering();
                                break;
                            default:
                                break;
                        }
                        break;

                    //verbs
                    case 11:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAVerb();
                                break;
                            case 1:
                                fragment = new Tense();
                                break;
                            case 2:
                                fragment = new Mood();
                                break;
                            case 3:
                                fragment = new Conjugation();
                                break;
                            case 4:
                                fragment = new PastTense();
                                break;
                            case 5:
                                fragment = new PresentTense();
                                break;
                            case 6:
                                fragment = new FutureTense();
                                break;
                            case 7:
                                fragment = new PluperfectTense();
                                break;
                            case 8:
                                fragment = new ConditionalTense();
                                break;
                            case 9:
                                fragment = new SubjTense();
                                break;
                            case 10:
                                fragment = new IrrVerbs();
                                break;
                            case 11:
                                fragment = new DefVerbs();
                                break;
                            case 12:
                                fragment = new VerbalDerivatives();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Pronouns
                    case 12:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAPronoun();
                                break;
                            case 1:
                                fragment = new Personal();
                                break;
                            case 2:
                                fragment = new EmphPro();
                                break;
                            case 3:
                                fragment = new PolPro();
                                break;
                            case 4:
                                fragment = new DefPro();
                                break;
                            case 5:
                                fragment = new PossPro();
                                break;
                            case 6:
                                fragment = new SubPossPro();
                                break;
                            case 7:
                                fragment = new PrepPro();
                                break;
                            case 8:
                                fragment = new Agreement();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Syntax
                    case 13:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsSyntax();
                                break;
                            case 1:
                                fragment = new WordOrder();
                                break;
                            case 2:
                                fragment = new Questions();
                                break;
                            case 3:
                                fragment = new CopularSyn();
                                break;
                            case 4:
                                fragment = new SpecSyn();
                                break;
                            case 5:
                                fragment = new Deriv();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Clauses
                    case 14:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAClause();
                                break;
                            case 1:
                                fragment = new LinkClauses();
                                break;
                            case 2:
                                fragment = new CondClauses();
                                break;
                            case 3:
                                fragment = new RelClauses();
                                break;
                            case 4:
                                fragment = new Miscellaneous();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Prepositions
                    case 15:
                        switch (childPosition) {
                            case 0:
                                fragment = new WhatIsAPrep();
                                break;
                            case 1:
                                fragment = new ConjPrep();
                                break;
                            case 2:
                                fragment = new UnconjPrep();
                                break;
                            case 3:
                                fragment = new GenPrep();
                                break;
                            case 4:
                                fragment = new For();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Numbers
                    case 16:
                        switch (childPosition) {
                            case 0:
                                fragment = new TypesOfNo();
                                break;
                            case 1:
                                fragment = new Voc();
                                break;
                            case 2:
                                fragment = new Quan();
                                break;
                            case 3:
                                fragment = new Ordinal();
                                break;
                            case 4:
                                fragment = new Personal();
                                break;
                            case 5:
                                fragment = new Time();
                                break;
                            case 6:
                                fragment = new DecFrac();
                                break;
                            case 7:
                                fragment = new com.glassbyte.irishgrammar.numbers.Miscellaneous();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Quantity
                    case 17:
                        switch (childPosition) {
                            case 0:
                                fragment = new ExpQuantity();
                                break;
                            case 1:
                                fragment = new PartQuan();
                                break;
                            case 2:
                                fragment = new IndetQuan();
                                break;
                            default:
                                break;
                        }
                        break;

                    //Other
                    case 18:
                        switch (childPosition) {
                            case 0:
                                fragment = new Acronyms();
                                break;
                            case 1:
                                fragment = new Vocab();
                                break;
                            default:
                                break;
                        }
                        break;

                    //About
                    case 19:
                        switch (childPosition) {
                            case 0:
                                fragment = new AboutUs();
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
            if (mDrawerLayout.isDrawerOpen(expListView)) {
                mDrawerLayout.closeDrawer(expListView);
            } else {
                mDrawerLayout.openDrawer(expListView);
            }
        }
    };

    private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

            switch (position) {
                case 0:
                    fragment = new Home();
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
        verbs.add("Subjunctive mood");
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
        //other.add("Vocab lists");

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
