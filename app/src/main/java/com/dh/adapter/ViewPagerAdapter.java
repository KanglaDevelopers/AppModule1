package com.dh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by HUIDROM on 11/12/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ArrayList<String> fragmentTitleList = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void addFragment(Fragment fragment,String fragmentTitle){
        fragmentList.add(fragment);
        fragmentTitleList.add(fragmentTitle);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

}
