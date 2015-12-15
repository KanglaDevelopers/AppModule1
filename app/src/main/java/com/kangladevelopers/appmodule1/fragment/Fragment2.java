package com.kangladevelopers.appmodule1.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kangladevelopers.appmodule1.R;
import com.kangladevelopers.appmodule1.adapter.ViewPagerAdapter;


public class Fragment2 extends Fragment {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private AppCompatActivity compatActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        compatActivity = (AppCompatActivity) getActivity();
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        compatActivity.setSupportActionBar(toolbar);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appBarLayout);
        tabLayout.setupWithViewPager(viewPager);



        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(compatActivity.getSupportFragmentManager());
        adapter.addFragment(new DummyFragment("#342456"), "TAB1");
        adapter.addFragment(new DummyFragment("#666666"), "TAB2");
        adapter.addFragment(new DummyFragment("#787654"), "TAB3");
        viewPager.setAdapter(adapter);
    }


}
