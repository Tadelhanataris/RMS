package com.lalalla.t.biyesheji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Module3 extends Activity  {
    private List<Project> projects = new ArrayList<Project>();
    private ListView listView;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);
        listView = (ListView) this.findViewById(R.id.Moudle3list);
        show();
        btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent();
                intent.setClass(Module3.this,AddActivity.class);
                startActivity(intent);

            }
        });

    }
    private void show()
    {
        ProjectDB project=new ProjectDB(getApplicationContext());
        projects = project.getScrollData(0, 5);
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();

        for(Project p : projects){
            HashMap<String, Object> hm = new HashMap<String, Object>();
            hm.put("date", p.getdate());
            hm.put("tittle", p.getTittle());
            data.add(hm);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.moudlelistview3,
                new String[]{"date","tittle"},
                new int[]{R.id.list3date,R.id.list3tittle});
        listView.setAdapter(adapter);
    }
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