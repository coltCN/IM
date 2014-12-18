package com.coltcn.majf.im.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coltcn.majf.im.R;

/**
 * Created by majf on 2014/12/18.
 */
public class DiscoverFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxian,container,false);
        view.setBackgroundColor(getResources().getColor(android.R.color.white));
        return view;
    }
}
