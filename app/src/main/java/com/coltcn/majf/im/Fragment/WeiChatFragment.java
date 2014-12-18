package com.coltcn.majf.im.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coltcn.majf.im.ChatActivity;
import com.coltcn.majf.im.HuiHua;
import com.coltcn.majf.im.HuihuaAdapter;
import com.coltcn.majf.im.R;

import java.util.ArrayList;

/**
 * Created by majf on 2014/12/17.
 */
public class WeiChatFragment extends Fragment {
    private ListView listview1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cust_main,container,false);
        listview1 = (ListView) view.findViewById(R.id.listView1);
        HuihuaAdapter ha = new HuihuaAdapter(getActivity(),getHuahui());
        listview1.setAdapter(ha);
        listview1.setCacheColorHint(0);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("click :"+position);
                Intent intent = new Intent(getActivity(),ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("huihua", (java.io.Serializable) parent.getAdapter().getItem(position));
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
        return view;
    }

    private ArrayList<HuiHua> getHuahui(){
        ArrayList<HuiHua> hhList = new ArrayList<HuiHua>();
        HuiHua h1 = new HuiHua();
        h1.setTxPath(R.drawable.icon+"");
        h1.setName1("肖秀");
        h1.setLastContent("这是唯一一个正常的朋友");
        h1.setLastTime("下午 18:00");

        HuiHua h2 = new HuiHua();
        h2.setTxPath(R.drawable.xiaohei+"");
        h2.setName1("小黑");
        h2.setLastContent("我存在永恒的黑暗中，我喜欢吞噬光明的灵魂");
        h2.setLastTime("下午 17:40");

        HuiHua h3 = new HuiHua();
        h3.setTxPath(R.drawable.searadd_icon+"");
        h3.setName1("傻逼不哭");
        h3.setLastContent("傻逼不哭，站起来勇敢地撸");
        h3.setLastTime("下午 17:00");

        HuiHua h4 = new HuiHua();
        h4.setTxPath(R.drawable.voip_camerachat+"");
        h4.setName1("不再当禽兽");
        h4.setLastContent("从此不再当禽兽，我要当兽王");
        h4.setLastTime("下午 16:22");

        HuiHua h5 = new HuiHua();
        h5.setTxPath(R.drawable.headshow2+"");
        h5.setName1("风清云南");
        h5.setLastContent("风吹得很清新，云飘荡在南边的天空");
        h5.setLastTime("下午 16:11");

        HuiHua h6 = new HuiHua();
        h6.setTxPath(R.drawable.headshow3+"");
        h6.setName1("EatEvery");
        h6.setLastContent("Don't look me, I will eat you, Are you know");
        h6.setLastTime("下午 15:08");

        HuiHua h7 = new HuiHua();
        h7.setTxPath(R.drawable.headshow4+"");
        h7.setName1("鄙人");
        h7.setLastContent("没有那么大的屌，就不要装B");
        h7.setLastTime("下午 15:01");

        HuiHua h8 = new HuiHua();
        h8.setTxPath(R.drawable.headshow5+"");
        h8.setName1("人人人");
        h8.setLastContent("我就是这么一个人，就是喜欢一个人，不管是不是一个人");
        h8.setLastTime("下午 14:50");

        HuiHua h9 = new HuiHua();
        h9.setTxPath(R.drawable.headshow6+"");
        h9.setName1("Diacker");
        h9.setLastContent("this is very good fill");
        h9.setLastTime("下午 14:00");

        HuiHua h0 = new HuiHua();
        h0.setTxPath(R.drawable.headshow1+"");
        h0.setName1("酒香告急");
        h0.setLastContent("我是个喜欢就得人，但是你们一定要理解清楚我的名字，再跟我说话");
        h0.setLastTime("中午 12:00");

        hhList.add(h1);
        hhList.add(h2);
        hhList.add(h3);
        hhList.add(h4);
        hhList.add(h5);
        hhList.add(h6);
        hhList.add(h7);
        hhList.add(h8);
        hhList.add(h9);
        hhList.add(h0);
        return hhList;
    }
}
