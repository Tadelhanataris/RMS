package com.lalalla.t.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class summaryedit extends AppCompatActivity {
    ProjectDB db;
    private EditText editprojectname;
    private EditText editprojecttype;
    private EditText editsubject;
    private EditText editstarttime;
    private EditText editstudentname;
    private EditText editstudentcollege;
    private EditText editstudentnumber;
    private EditText editstudentemail;
    private EditText editstudentphone;
    private EditText editteachername;
    private EditText editteachercollege;
    private EditText editteacheremail;
    private EditText editteacherphone;
    private Button summarybtnback;
    private Integer id;
    private String projectname;
    private String projecttype;
    private String subject;
    private String starttime;
    private String studentname;
    private String studentcollege;
    private String studentnumber;
    private String studentemail;
    private String studentphone;
    private String teachername;
    private String teachercollege;
    private String teacheremail;
    private String teacherphone;
    Summary summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summaryedititem);
        db = new ProjectDB(getApplicationContext());
        Intent i = getIntent();
        id = i.getIntExtra("id", 0);
        summary = db.findsummary(id);
        projectname = summary.getProjectname();
        projecttype = summary.getProjecttype();
        subject = summary.getSubject();
        starttime = summary.getStarttime();
        studentname = summary.getStudentname();
        studentcollege = summary.getSdudentcollege();
        studentnumber = summary.getStudentnumber();
        studentemail = summary.getSdudentemail();
        studentphone = summary.getStudentphone();
        teachername = summary.getTeachername();
        teachercollege = summary.getTeachercollege();
        teacheremail = summary.getTeacheremail();
        teacherphone = summary.getTeacherphone();
        editprojectname = (EditText) findViewById(R.id.summaryprojectname);
        editprojecttype = (EditText) findViewById(R.id.summaryprojecttype);
        editsubject = (EditText) findViewById(R.id.summarysubject);
        editstarttime = (EditText) findViewById(R.id.summarystarttime);
        editstudentname = (EditText) findViewById(R.id.summarystudentname);
        editstudentcollege = (EditText) findViewById(R.id.summarystudentcollege);
        editstudentnumber = (EditText) findViewById(R.id.summarystudentnumber);
        editstudentemail = (EditText) findViewById(R.id.summarystudentemail);
        editstudentphone = (EditText) findViewById(R.id.summarystudentphone);
        editteachername = (EditText) findViewById(R.id.summaryteachername);
        editteachercollege = (EditText) findViewById(R.id.summaryteachercollege);
        editteacheremail = (EditText) findViewById(R.id.summaryteacheremail);
        editteacherphone = (EditText) findViewById(R.id.summaryteacherphone);

        editprojectname.setText(projectname);
        editprojecttype.setText(projecttype);
        editsubject.setText(subject);
        editstarttime.setText(starttime);
        editstudentname.setText(studentname);
        editstudentcollege.setText(studentcollege);
        editstudentnumber.setText(studentnumber);
        editstudentemail.setText(studentemail);
        editstudentphone.setText(studentphone);
        editteachername.setText(teachername);
        editteachercollege.setText(teachercollege);
        editteacheremail.setText(teacheremail);
        editteacherphone.setText(teacherphone);



        summarybtnback= (Button) findViewById(R.id.summarybtnback);
        summarybtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    }

