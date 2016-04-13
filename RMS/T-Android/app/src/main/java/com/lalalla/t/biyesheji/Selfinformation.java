package com.lalalla.t.biyesheji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Selfinformation extends AppCompatActivity {
    private ListView listView;
    ProjectDB Selfinformations;
    public static SimpleCursorAdapter adapter;
    private Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfinformation);
        listView = (ListView) findViewById(R.id.selfinformationlist);
        btnback= (Button) findViewById(R.id.selfinformationbtnback);
        Selfinformations = new ProjectDB(getApplicationContext());
        adapter = new SimpleCursorAdapter(this,
                R.layout.selfinformationitem, Selfinformations.getselfinformaitonAllData(),
                new String[] { "_id",
                        "studentname",
                        "studentnumber",
                        "identifynumber" ,
                        "gender" ,
                        "grade" ,
                        "college" ,
                        "subject" ,
                        "email" ,
                        "phone" },
                new int[]{R.id.selfinformationlistid,
                        R.id.selfinformationstudentname,
                        R.id.selfinformationstudentnumber,
                        R.id.selfinformaitonidentifynumber,
                        R.id.selfinformationgender,
                        R.id.selfinformationgrade,
                        R.id.selfinformationcollege,
                        R.id.selfinformationsubject,
                        R.id.selfinformationemail,
                        R.id.selfinformationphone} );
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(Selfinformation.this, Selfinformationedit.class);
                int sid = ((Cursor) (adapter.getItem(position))).getInt(((Cursor) (adapter.getItem(position))).getColumnIndex("_id"));
                intent.putExtra("id", sid);
                Selfinformation.this.startActivity(intent);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
