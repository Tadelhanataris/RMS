package com.lalalla.t.biyesheji;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module1 extends Activity {

    private ListView lv1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);


        lv1 = (ListView)findViewById(R.id.Moudle1List1);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.moudlelistview1, new String[] { "news", "time"},
                new int[] { R.id.news, R.id.time});
        //setListAdapter(adapter);
        lv1.setAdapter(adapter);

            }


    public List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("news", "徐航找了女朋友");
        map.put("time", "2016年3月3日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航日了朋友");
        map.put("time", "2016年3月4日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航杀了女朋友");
        map.put("time", "2016年3月5日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航分尸女朋友");
        map.put("time", "2016年3月6日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航埋了女朋友");
        map.put("time", "2016年3月7日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);



        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("news", "徐航找了新女朋友");
        map.put("time", "2016年3月8日");
        list.add(map);

        return list;
    }


}








