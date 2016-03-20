package com.inteliment.pjwin.uitest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by hans on 18-Mar-16.
 */
public abstract class BaseFragment extends Fragment {
    protected static final String TITLE_TXT = "title_txt";

    protected String mTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getString(TITLE_TXT);
        }
    }
}
