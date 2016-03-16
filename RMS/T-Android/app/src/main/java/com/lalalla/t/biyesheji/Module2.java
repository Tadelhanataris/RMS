package com.lalalla.t.biyesheji;

import android.app.Activity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Module2 extends Activity {
    private ListView listView;
    ProjectDB summary;
    public static SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        listView= (ListView) findViewById(R.id.Moudle2List1);
        summary = new ProjectDB(getApplicationContext());
        adapter = new SimpleCursorAdapter(this,
                R.layout.moudlelistview2, summary.getsummaryAllData(),
                new String[] { "_id","projectname","projecttype","subject" ,"starttime" ,"studentname" ,"studentcollege" ,"studentnumber" ,"studentemail" ,"studentphone" ,"teachername" ,"teachercollege" ,"teacheremail" ,"teacherphone" },
                new int[]{R.id.list2id,R.id.projectname,R.id.projecttype,R.id.subject,R.id.starttime,R.id.studentname,R.id.studentcollege,R.id.studentnumber,R.id.studentemail,R.id.studentphone,R.id.teachername,R.id.teachercollege,R.id.teacheremail,R.id.teacherphone} );
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.changeCursor(summary.getsummaryAllData());
    }
}
