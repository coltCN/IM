package com.coltcn.majf.im;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.coltcn.majf.im.adpater.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majf on 2014/12/17.
 */
public class CustMainActivity extends Activity{

    private List<View> viewList = new ArrayList<>();
    private ViewPageAdapter viewPageAdapter;
    private ViewPager viewPager;
    private int viewIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
//        viewList.add(getLayoutInflater().inflate(R.layout.activity_cust_main, null));
        viewList.add(getLayoutInflater().inflate(R.layout.activity_cust_main, null));
        viewList.add(getLayoutInflater().inflate(R.layout.tongxunlu,null));
        viewList.add(getLayoutInflater().inflate(R.layout.faxian,null));
        viewPageAdapter = new ViewPageAdapter(viewList);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPageAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                viewIndex=position;
                Toast.makeText(getApplicationContext(),"当前第"+viewIndex+"页",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
