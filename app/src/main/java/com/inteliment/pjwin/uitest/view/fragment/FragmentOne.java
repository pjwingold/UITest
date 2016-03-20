package com.inteliment.pjwin.uitest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inteliment.pjwin.uitest.R;
import com.inteliment.pjwin.uitest.utils.L;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hans on 18-Mar-16.
 */
public class FragmentOne extends BaseFragment {
    @Bind(R.id.title_tv) TextView mTitleTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ButterKnife.bind(this, view);
        mTitleTV.setText(mTitle);

        return view;
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    public static FragmentOne newInstance(String title) {
        FragmentOne fragment = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_TXT, title);
        fragment.setArguments(bundle);

        return fragment;
    }

    @OnClick(R.id.title_tv)
    void titleOnClick(TextView tv) {
        L.toastShort(getActivity(), mTitle);
    }
}
