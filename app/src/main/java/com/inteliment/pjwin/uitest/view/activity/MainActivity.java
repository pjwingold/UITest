package com.inteliment.pjwin.uitest.view.activity;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.inteliment.pjwin.uitest.R;
import com.inteliment.pjwin.uitest.view.adapter.FragmentItemAdapter;
import com.inteliment.pjwin.uitest.view.fragment.PagerContentFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private static final int HEADER_ITEM_COUNT = 5;
    private static final int HEADER_ITEM_MAX_VISIBLE = 3;

    @Bind(R.id.viewpager) ViewPager mViewPager;
    @Bind(R.id.pager_indicator) RadioGroup mPagerIndicator;
    @Bind(R.id.tv_item_result) TextView mTVItemResult;
    @Bind(R.id.wrapper_layout) LinearLayout wrapperLL;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initVariables() {
        ButterKnife.bind(this);
        initViewPager();
        initHeaderRow();
    }

    private void initViewPager() {
        FragmentItemAdapter adapter = new FragmentItemAdapter(getSupportFragmentManager());
        //since we are using the same UI to show different content text, so I just reuse the same fragment, like a gallery
        adapter.addFragment(PagerContentFragment.newInstance(getString(R.string.view_fragment_1)));
        adapter.addFragment(PagerContentFragment.newInstance(getString(R.string.view_fragment_2)));
        adapter.addFragment(PagerContentFragment.newInstance(getString(R.string.view_fragment_3)));
        adapter.addFragment(PagerContentFragment.newInstance(getString(R.string.view_fragment_4)));

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                updatePagerIndicator(position);
            }
        });
    }

    /**
     * To make it display three items at most
     */
    private void initHeaderRow() {
        wrapperLL.post(new Runnable() {
            @Override
            public void run() {
                HorizontalScrollView hsv = (HorizontalScrollView) wrapperLL.getParent();

                int targetWidth = (hsv.getWidth() / HEADER_ITEM_MAX_VISIBLE) * HEADER_ITEM_COUNT;
                int childCount = wrapperLL.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View view = wrapperLL.getChildAt(i);
                    LinearLayout.LayoutParams lpc = (LinearLayout.LayoutParams) view.getLayoutParams();
                    lpc.width = targetWidth / HEADER_ITEM_MAX_VISIBLE;
                    ((TextView) view).setGravity(Gravity.CENTER);
                }
            }
        });
    }

    @OnClick(R.id.btn_red)
    public void btnRedOnClick(Button btn) {
        //L.toastShort(this, btn.getText());
        updateBackgroundColor(R.color.colorBackgroundRed);
    }

    @OnClick(R.id.btn_blue)
    public void btnBlueOnClick(Button btn) {
        //L.toastShort(this, btn.getText());
        updateBackgroundColor(R.color.colorBackgroundBlue);
    }

    @OnClick(R.id.btn_green)
    public void btnGreenOnClick(Button btn) {
        //L.toastShort(this, btn.getText());
        updateBackgroundColor(R.color.colorBackgroundGreen);
    }

    @OnClick(R.id.tv_header_1)
    public void btnHeaderOneOnClick(TextView tv) {
        updateItem(tv.getText());
    }

    @OnClick(R.id.tv_header_2)
    public void btnHeaderTwoOnClick(TextView tv) {
        updateItem(tv.getText());
    }

    @OnClick(R.id.tv_header_3)
    public void btnHeaderThreeOnClick(TextView tv) {
        updateItem(tv.getText());
    }

    @OnClick(R.id.tv_header_4)
    public void btnHeaderFourOnClick(TextView tv) {
        updateItem(tv.getText());
    }

    @OnClick(R.id.tv_header_5)
    public void btnHeaderFiveOnClick(TextView tv) {
        updateItem(tv.getText());
    }

    private void updatePagerIndicator(int position) {
        switch (position) {
            case 0:
                mPagerIndicator.check(R.id.rBtn_1);
                break;
            case 1:
                mPagerIndicator.check(R.id.rBtn_2);
                break;
            case 2:
                mPagerIndicator.check(R.id.rBtn_3);
                break;
            case 3:
                mPagerIndicator.check(R.id.rBtn_4);
                break;
            default:
                break;
        }
    }

    private void updateItem(CharSequence text) {
        mTVItemResult.setText(text);
    }
}
