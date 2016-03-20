package com.inteliment.pjwin.uitest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inteliment.pjwin.uitest.R;

import butterknife.ButterKnife;

/**
 * Created by hans on 18-Mar-16.
 */
public class FragmentFour extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public static FragmentFour newInstance() {
        return new FragmentFour();
    }

    public static FragmentFour newInstance(String title) {
        FragmentFour fragment = new FragmentFour();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_TXT, title);
        fragment.setArguments(bundle);

        return fragment;
    }
}
