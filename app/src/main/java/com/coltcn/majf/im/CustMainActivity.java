package com.coltcn.majf.im;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.coltcn.majf.im.Fragment.AddressBookFragment;
import com.coltcn.majf.im.Fragment.DiscoverFragment;
import com.coltcn.majf.im.Fragment.WeiChatFragment;
import com.coltcn.majf.im.adpater.CustPagerViewAdapter;
import com.coltcn.majf.im.adpater.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majf on 2014/12/17.
 */
public class CustMainActivity extends FragmentActivity{

    private List<View> viewList = new ArrayList<>();//ViewPager中显示的数据
    private List<Fragment> fragmentList = new ArrayList<>();//ViewPager中显示的数据
    private ArrayList<String> titleList = new ArrayList<String>();// 标题数据
    private ViewPager viewPager;
    private int viewIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewpager_main);

//        PagerTabStrip mPagerTabStrip=(PagerTabStrip) findViewById(R.id.pager_tabstrip);
//        //设置导航条的颜色
//        mPagerTabStrip.setTabIndicatorColorResource(android.R.color.holo_green_light);


//        viewList.add(getLayoutInflater().inflate(R.layout.activity_cust_main, null));
        viewList.add(getLayoutInflater().inflate(R.layout.activity_cust_main, null));
        viewList.add(getLayoutInflater().inflate(R.layout.tongxunlu,null));
        viewList.add(getLayoutInflater().inflate(R.layout.faxian,null));

        fragmentList.add(new WeiChatFragment());
        fragmentList.add(new AddressBookFragment());
        fragmentList.add(new DiscoverFragment());

        titleList.add("微信");
        titleList.add("通讯录");
        titleList.add("发现");
        titleList.add("我");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustPagerViewAdapter(getSupportFragmentManager(),fragmentList,titleList));
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                viewIndex=position;
                Toast.makeText(getApplicationContext(),"当前第"+viewIndex+"页",Toast.LENGTH_SHORT).show();
            }
        });
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setShouldExpand(true);
        tabs.setIndicatorColorResource(android.R.color.holo_green_light);
        tabs.setViewPager(viewPager);


    }
}
