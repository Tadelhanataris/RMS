package com.lalalla.t.biyesheji;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module1 extends Activity {
    public static SimpleCursorAdapter adapter1;
    public static SimpleCursorAdapter adapter2;
    private ListView lv1;
    private ListView lv2;
    ProjectDB news;
    ProjectDB notification;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
        news=new ProjectDB(getApplicationContext());
        notification=new ProjectDB(getApplicationContext());
        adapter1 = new SimpleCursorAdapter(this,
                R.layout.moudlelistview1,news.getNewsAllData(),
                new String[] { "_id","date","tittle" },
                new int[]{R.id.list1id,R.id.list1date,R.id.list1newstittle} );
        adapter2 = new SimpleCursorAdapter(this,
                R.layout.moudlelistview12, notification.getNotificationAllData(),
                new String[] { "_id","date","tittle" },
                new int[]{R.id.list12id,R.id.list12date,R.id.list12notificationtittle} );
        lv1 = (ListView)findViewById(R.id.Moudle1List1);
        lv2 = (ListView) findViewById(R.id.Moudle1List2);



        lv1.setAdapter(adapter1);
        lv2.setAdapter(adapter2);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(Module1.this, newss.class);
                int sid = ((Cursor) (adapter1.getItem(position))).getInt(((Cursor) (adapter1.getItem(position))).getColumnIndex("_id"));
                intent.putExtra("id", sid);
                Module1.this.startActivity(intent);
            }
        });



        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(Module1.this, notifications.class);
                int sid = ((Cursor) (adapter2.getItem(position))).getInt(((Cursor) (adapter2.getItem(position))).getColumnIndex("_id"));
                intent.putExtra("id", sid);
                Module1.this.startActivity(intent);
            }
        });


            }


//    public List<Map<String, Object>> getData() {
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("news", "徐航找了女朋友");
//        map.put("time", "2016年3月3日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航日了朋友");
//        map.put("time", "2016年3月4日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航杀了女朋友");
//        map.put("time", "2016年3月5日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航分尸女朋友");
//        map.put("time", "2016年3月6日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航埋了女朋友");
//        map.put("time", "2016年3月7日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("news", "徐航找了新女朋友");
//        map.put("time", "2016年3月8日");
//        list.add(map);
//
//        return list;
//    }


}








