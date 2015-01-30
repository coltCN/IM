package com.coltcn.majf.im.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.coltcn.majf.im.ContactAdapter;
import com.coltcn.majf.im.ContactP;
import com.coltcn.majf.im.R;

import java.util.ArrayList;

/**
 * Created by majf on 2014/12/18.
 */
public class AddressBookFragment extends Fragment {
    private ListView listview;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cust_main,container,false);
        listview = (ListView)view.findViewById(R.id.listView1);
        ContactAdapter hc = new ContactAdapter(getActivity(),getContact());
        listview.setAdapter(hc);
        listview.setCacheColorHint(0);
        return view;
    }

    private ArrayList<ContactP> getContact(){
        ArrayList<ContactP> hcList = new ArrayList<ContactP>();
        ContactP c0 = new ContactP();
        c0.setTxPath(R.drawable.bind_mcontact_reco_friends+"");
        c0.setName("服务号");

        ContactP c1 = new ContactP();
        c1.setTxPath(R.drawable.brand_default_head+"");
        c1.setName("微信测试账号");

        ContactP c2 = new ContactP();
        c2.setTxPath(R.drawable.bind_qq_icon+"");
        c2.setName("QQ团队");

        ContactP c3 = new ContactP();
        c3.setTxPath(R.drawable.icon_app+"");
        c3.setName("微信团队");

        ContactP c4 = new ContactP();
        c4.setTxPath(R.drawable.xiaohei+"");
        c4.setName("小黑");

        ContactP c5 = new ContactP();
        c5.setTxPath(R.drawable.voip_camerachat+"");
        c5.setName("不再禽兽");

        ContactP c6 = new ContactP();
        c6.setTxPath(R.drawable.searadd_icon+"");
        c6.setName("傻逼不哭");

        ContactP c7 = new ContactP();
        c7.setTxPath(R.drawable.personactivity_cover_heart+"");
        c7.setName("肖秀");

        ContactP c8 = new ContactP();
        c8.setTxPath(R.drawable.headshow2+"");
        c8.setName("风清云南");

        ContactP c9 = new ContactP();
        c9.setTxPath(R.drawable.headshow3+"");
        c9.setName("EatEvery");

        ContactP c10 = new ContactP();
        c10.setTxPath(R.drawable.headshow4+"");
        c10.setName("鄙人");

        ContactP c11 = new ContactP();
        c11.setTxPath(R.drawable.headshow5+"");
        c11.setName("人人人");

        ContactP c12 = new ContactP();
        c12.setTxPath(R.drawable.headshow6+"");
        c12.setName("Diacker");

        ContactP c13 = new ContactP();
        c13.setTxPath(R.drawable.headshow1+"");
        c13.setName("王霸");

        hcList.add(c0);
        hcList.add(c1);
        hcList.add(c2);
        hcList.add(c3);
        hcList.add(c4);
        hcList.add(c5);
        hcList.add(c6);
        hcList.add(c7);
        hcList.add(c8);
        hcList.add(c9);
        hcList.add(c10);
        hcList.add(c11);
        hcList.add(c12);
        hcList.add(c13);

        return hcList;
    }
}
