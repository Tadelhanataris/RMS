package com.lalalla.t.biyesheji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module3 extends Activity  {
    private ListView listView;
    private Button btnadd;
    private static final int REFRESH_LISTVIEW = 817;
    ProjectDB project;
    List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
    public static SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);
        listView = (ListView) this.findViewById(R.id.Moudle3list);
        project=new ProjectDB(getApplicationContext());
        adapter = new SimpleCursorAdapter(this,
                R.layout.moudlelistview3, project.getAllData(),
                new String[] { "_id","date","tittle" },
                new int[]{R.id.list3id,R.id.list3date,R.id.list3tittle} );


        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object a  = adapter.getItem(position);
//                Toast.makeText(parent.getContext(), String.valueOf(id), Toast.LENGTH_LONG).show();
//            }
//        });
//        show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(Module3.this, EditActivity.class);
                int sid = ((Cursor) (adapter.getItem(position))).getInt(((Cursor) (adapter.getItem(position))).getColumnIndex("_id"));
                intent.putExtra("id", sid);
                Module3.this.startActivity(intent);
            }
        });

        btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Module3.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onResume()
    {
        super.onResume();
        adapter.changeCursor(project.getAllData());
    }

//    private void show()
//    {
//        ProjectDB project=new ProjectDB(getApplicationContext());
//        projects = project.getScrollData(0, Integer.MAX_VALUE);
//
//        for(Project p : projects){
//            HashMap<String, Object> hm = new HashMap<String, Object>();
//            hm.put("date", p.getdate());
//            hm.put("tittle", p.getTittle());
//            data.add(hm);
//        }
//
//        adapter = new ListAdapter(this,data,R.layout.moudlelistview3,
//                new String[]{"date","tittle"},
//                new int[]{R.id.list3date,R.id.list3tittle});
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(adapter);
//    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }




}