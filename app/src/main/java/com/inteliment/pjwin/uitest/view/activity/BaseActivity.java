package com.inteliment.pjwin.uitest.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hans on 18-Mar-16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);//remove default background to reduce overdraw
        setContentView();
        initVariables();
    }

    protected abstract void setContentView();

    protected abstract void initVariables();

    protected void addFragment(int containerViewId, Fragment fragment) {
        getFragmentManager().beginTransaction().add(containerViewId, fragment).commit();
    }

    protected void updateBackgroundColor(int color) {
        getWindow().setBackgroundDrawableResource(color);
    }
}
