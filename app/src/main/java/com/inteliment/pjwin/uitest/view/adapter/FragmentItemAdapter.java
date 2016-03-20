package com.inteliment.pjwin.uitest.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * FragmentStatePagerAdapter uses less memory than FragmentPagerAdapter, more suitable for a complex screen
 *
 * Created by hans on 18-Mar-16.
 */
public class FragmentItemAdapter extends FragmentStatePagerAdapter {
    private static final int TAB_COUNT = 4;
    private List<Fragment> fragmentList;

    public FragmentItemAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>(TAB_COUNT);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }
}
