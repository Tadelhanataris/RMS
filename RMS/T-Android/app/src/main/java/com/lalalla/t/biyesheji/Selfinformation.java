package com.lalalla.t.biyesheji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Selfinformation extends AppCompatActivity {
    private ListView listView;
    ProjectDB Selfinformations;
    public static SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfinformation);
        listView = (ListView) findViewById(R.id.selfinformationlist);
        Selfinformations = new ProjectDB(getApplicationContext());
        adapter = new SimpleCursorAdapter(this,
                R.layout.activity_selfinformation, Selfinformations.getselfinformaitonAllData(),
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

    }


}
