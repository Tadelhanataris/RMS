package com.lalalla.t.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class summaryedit extends AppCompatActivity {
    ProjectDB db;
    private String editprojectname;
    private String editprojecttype;
    private String editsubject;
    private String editstarttime;
    private String editstudentname;
    private String editsdudentcollege;
    private String editstudentnumber;
    private String editsdudentemail;
    private String editstudentphone;
    private String editteachername;
    private String editteachercollege;
    private String editteacheremail;
    private String editteacherphone;
    private Button summarybtnback;
    private Integer id;
    private String projectname;
    private String projecttype;
    private String subject;
    private String starttime;
    private String studentname;
    private String sdudentcollege;
    private EditText studentnumber;
    private EditText sdudentemail;
    private EditText studentphone;
    private EditText teachername;
    private EditText teachercollege;
    private EditText teacheremail;
    private EditText teacherphone;
    Summary summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summaryedit);
        db = new ProjectDB(getApplicationContext());
        Intent i = getIntent();
        id = i.getIntExtra("id", 0);
        summary = db.findsummary(id);
        projectname = summary.getProjectname();
        projecttype = summary.getProjecttype();
        subject = summary.getSubject();
        starttime = summary.getStarttime();
        studentname = summary.getStudentname();
        sdudentcollege = summary.getSdudentcollege();
        date = newss.getdate();
        tittle = newss.getTittle();
        content = newss.getContent();
        date = newss.getdate();
        tittle = newss.getTittle();
        content = newss.getContent();
        date = newss.getdate();
        newssdate= (TextView) findViewById(R.id.newssdate);
        newsstittle= (TextView) findViewById(R.id.newsstittle);
        newsscontent= (TextView) findViewById(R.id.newsscontent);
        newssdate.setText(date);
        newsstittle.setText(tittle);
        newsscontent.setText(content);
        newssbtnback= (Button) findViewById(R.id.newssbtnback);
        newssbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    }

