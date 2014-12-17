package com.coltcn.majf.im.adpater;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by majf on 2014/12/17.
 */
public class ViewPageAdapter extends PagerAdapter {
    List<View> viewList;

    public ViewPageAdapter(List<View> lists){
        super();
        this.viewList = lists;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(viewList.get(position), 0);

        return viewList.get(position);
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return "第"+position+"页";
//    }
}
