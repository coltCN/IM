package com.coltcn.majf.im;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
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
public class MainActivity6 extends FragmentActivity{
    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<>();
    private String[] mTitles = new String[]{"Fisrst","Second","Third","Fourth"};
    private FragmentPagerAdapter mAdapter;
    
    private List<ChangeColorIconWithText> mIndicator ;

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
    }

    private void iniView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

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
}
