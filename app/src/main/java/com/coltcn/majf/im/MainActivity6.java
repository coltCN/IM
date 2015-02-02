package com.coltcn.majf.im;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;

import com.coltcn.majf.im.Fragment.TabFragment;
import com.coltcn.majf.im.view.ChangeColorIconWithText;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by colt on 15/1/26.
 */
public class MainActivity6 extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<>();
    private String[] mTitles = new String[]{"Fisrst","Second","Third","Fourth"};
    private FragmentPagerAdapter mAdapter;
    
    private List<ChangeColorIconWithText> mTabIndicator = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity6","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main_6_0);
        setOverflowButtonAlways();
        getActionBar().setDisplayShowHomeEnabled(false);
        iniView();
        initDatas();
        mViewPager.setAdapter(mAdapter);
        initEvent();
    }

    private void initEvent() {

        mViewPager.setOnPageChangeListener(this);
    }

    private void iniView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        ChangeColorIconWithText one = (ChangeColorIconWithText) findViewById(R.id.id_indicator_one);
        mTabIndicator.add(one);
        ChangeColorIconWithText two = (ChangeColorIconWithText) findViewById(R.id.id_indicator_two);
        mTabIndicator.add(two);
        ChangeColorIconWithText three = (ChangeColorIconWithText) findViewById(R.id.id_indicator_three);
        mTabIndicator.add(three);
        ChangeColorIconWithText four = (ChangeColorIconWithText) findViewById(R.id.id_indicator_four);
        mTabIndicator.add(four);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        one.setIconAlpha(1.0f);

    }

    private void initDatas() {
        for (String title:mTitles){
            TabFragment tabFragment = new TabFragment();
            Bundle b = new Bundle();
            b.putString(TabFragment.TITLE,title);
            tabFragment.setArguments(b);
            mTabs.add(tabFragment);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
    }

    private void setOverflowButtonAlways(){
        ViewConfiguration config = ViewConfiguration.get(this);
        try {
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(config,true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null){
            if(menu.getClass().getSimpleName().equals("MenuBuilder")){
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu,true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Log.i("MainActivity6","onClick");
        resetOtherTabs();

        switch (view.getId()){
            case R.id.id_indicator_one:
                mTabIndicator.get(0).setIconAlpha(1);
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.id_indicator_two:
                mTabIndicator.get(1).setIconAlpha(1);
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.id_indicator_three:
                mTabIndicator.get(2).setIconAlpha(1);
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.id_indicator_four:
                mTabIndicator.get(3).setIconAlpha(1);
                mViewPager.setCurrentItem(3,false);
                break;
        }
    }

    /**
     *重置其它的TabIndicator的颜色
     */
    private void resetOtherTabs() {
        for (int i = 0; i<mTabIndicator.size();i++){
            mTabIndicator.get(i).setIconAlpha(0);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Log.i("pageScrolled","position = "+ position +",positionOffset = "+positionOffset);

        if (positionOffset>0){
            ChangeColorIconWithText left = mTabIndicator.get(position);
            ChangeColorIconWithText right = mTabIndicator.get(position+1);

            left.setIconAlpha(1-positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
