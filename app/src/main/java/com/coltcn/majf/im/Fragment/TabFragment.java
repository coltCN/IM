package com.coltcn.majf.im.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by majf on 2015/1/26.
 */
public class TabFragment extends Fragment {
    private String mTitle = "Default";
    public static final String TITLE = "title";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        if(getArguments()!=null){
            mTitle = getArguments().getString(TITLE);
        }
        TextView  tv = new TextView(getActivity());
        tv.setTextSize(30);
        tv.setBackgroundColor(Color.WHITE);
        tv.setText(mTitle);
        return tv;
    }
}
