package com.lalalla.t.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class summaryedit extends AppCompatActivity implements View.OnClickListener {
    ProjectDB db;
    private ListView listview;
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
    private Button summarybtnsave;
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

    private Summary summary;
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
        summarybtnsave= (Button) findViewById(R.id.summarybtnsave);
        summarybtnback.setOnClickListener(this);
        summarybtnsave.setOnClickListener(this);




    }

    public void testSave(View v) throws Exception{
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
        String neweditprojectname=editprojectname.getText().toString();
        String neweditprojecttype=editprojecttype.getText().toString();
        String neweditsubject = editsubject.getText().toString();
        String neweditstarttime=editstarttime.getText().toString();
        String neweditstudentname=editstudentname.getText().toString();
        String neweditstudentcollege = editstudentcollege.getText().toString();
        String neweditstudentnumber=editstudentnumber.getText().toString();
        String neweditstudentemail=editstudentemail.getText().toString();
        String neweditstudentphone = editstudentphone.getText().toString();
        String neweditteachername=editteachername.getText().toString();
        String neweditteachercollege=editteachercollege.getText().toString();
        String neweditteacheremail = editteacheremail.getText().toString();
        String neweditteacherphone=editteacherphone.getText().toString();

        if (neweditprojectname==null||neweditprojecttype==null||neweditsubject==null||neweditstarttime==null
                ||neweditstudentname==null||neweditstudentcollege==null||neweditstudentnumber==null||neweditstudentemail==null
                ||neweditstudentphone==null||neweditteachername==null||neweditteachercollege==null||neweditteacheremail==null
                ||neweditteacherphone==null){
            Toast.makeText(v.getContext(), "请输入正确信息,有信息为空", Toast.LENGTH_SHORT).show();
            return;
        }
        else

        {ProjectDB projectService=new ProjectDB(v.getContext());
            Integer newid = summary.get_id();
            summary.setProjectname(neweditprojectname);
            summary.setProjecttype(neweditprojecttype);
            summary.setSubject(neweditsubject);
            summary.setStarttime(neweditstarttime);
            summary.setStudentname(neweditstudentname);
            summary.setSdudentcollege(neweditstudentcollege);
            summary.setStudentnumber(neweditstudentnumber);
            summary.setSdudentemail(neweditstudentemail);
            summary.setStudentphone(neweditstudentphone);
            summary.setTeachername(neweditteachername);
            summary.setTeachercollege(neweditteachercollege);
            summary.setTeacheremail(neweditteacheremail);
            summary.setTeacherphone(neweditteacherphone);


            Summary newsummary= new Summary(newid,neweditprojectname,neweditprojecttype,neweditsubject,neweditstarttime,
                    neweditstudentname,neweditstudentcollege,neweditstudentnumber,neweditstudentemail,
                    neweditstudentphone,neweditteachername,neweditteachercollege,neweditteacheremail,
                    neweditteacherphone);
//            projectService.save(newproject);
//            projectService.delete(project.getId());
            projectService.summaryupdate(newsummary);
            Toast.makeText(v.getContext(), R.string.successful, Toast.LENGTH_SHORT).show();
        }}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.summarybtnback:
                finish();
                break;
            case R.id.summarybtnsave:
               try {
                testSave(v);
            } catch (Exception e) {
                e.printStackTrace();
            }
                finish();
                break;
        }
    }
}

