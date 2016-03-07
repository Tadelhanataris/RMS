package com.lalalla.t.biyesheji;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    ProjectDB db;
    private String  date;
    private String tittle;
    private String content;
    private Button editbtnsave;
    private Button editbtndelete;
    private Button editbtndate;
    private long id;
    private EditText editEdittittle;
    private  EditText editEdittextContent;
    private Project project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        db = new ProjectDB(getApplicationContext());
        Intent i = getIntent();
        id = i.getLongExtra("id",0);
        project = db.find((int) id);
        date = project.getdate();
        tittle = project.getTittle();
        content = project.getContent();
        editEdittittle.findViewById(R.id.editEdittextTittle);
        editEdittittle.setText(tittle);
        editEdittextContent.findViewById(R.id.editEdittextContent);
        editEdittextContent.setText(content);
        editbtndate = (Button) findViewById(R.id.editbtndate);
        editbtndelete = (Button) findViewById(R.id.editbtndelete);
        editbtndate.setText(date);
        editbtndelete.setOnClickListener(this);
        editbtndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date curDate = new Date(System.currentTimeMillis());
                new DatePickerDialog(EditActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String theDate = String.format("%04d-%02d-%02d", year, monthOfYear + 1, dayOfMonth);
                        System.out.println(theDate);
                        editbtndate.setText(theDate);
                    }
                }, curDate.getYear() + 1900, curDate.getMonth(), curDate.getDate()).show();
            }
        });
    }
    public void testSave(View v) throws Exception{
        editEdittittle =(EditText)findViewById(R.id.editEdittextTittle);
        editEdittextContent =(EditText)findViewById(R.id.editEdittextContent);
        editbtndate= (Button) findViewById(R.id.editbtndate);
        String Tittle=editEdittittle.getText().toString();
        String Content=editEdittextContent.getText().toString();
        String Date = editbtndate.getText().toString();
        if (Tittle==null||Content==null||Date==null){
            Toast.makeText(v.getContext(), "请输入正确信息", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {ProjectDB projectService=new ProjectDB(v.getContext());
            Project project=new Project(Date,Tittle,Content);
            projectService.save(project);
            Toast.makeText(v.getContext(), R.string.successful, Toast.LENGTH_SHORT).show();
        }}


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editbtndelete:
                db.delete(project.getId());
                finish();
                break;
            case  R.id.editbtnsave:
                try {
                    testSave(v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(EditActivity.this, Module3.class);
                startActivity(intent);
                break;
        }
    }
}

