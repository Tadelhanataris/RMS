package com.lalalla.t.biyesheji;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by T on 2016/3/4.
 */
public class AddActivity extends Activity implements OnClickListener {
    private  Button btnCancel;
    private  Button m3BtnDate;
    private  Button btnEnter;
    private  EditText m3EdittextTittle;
    private  EditText m3EdittextContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityadd);
        btnCancel=(Button) findViewById(R.id.btnCancel);
        m3BtnDate = (Button) findViewById(R.id.m3BtnDate);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnCancel.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
        String date = getCurDate().toString();
        m3BtnDate.setText(date);
        m3BtnDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Date curDate = new Date(System.currentTimeMillis());
                new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String theDate = String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth);
                        System.out.println(theDate);
                        m3BtnDate.setText(theDate);
                    }
                },curDate.getYear()+1900,curDate.getMonth(),curDate.getDate()).show();
            }
        });


    }
    public void testSave(View v) throws Exception{
        m3EdittextTittle =(EditText)findViewById(R.id.m3EdittextTittle);
        m3EdittextContent =(EditText)findViewById(R.id.m3EdittextContent);
        m3BtnDate= (Button) findViewById(R.id.m3BtnDate);
        String Tittle=m3EdittextTittle.getText().toString();
        String Content=m3EdittextContent.getText().toString();
        String Date = m3BtnDate.getText().toString();
        if (Tittle==null||Content==null||Date==null){
            Toast.makeText(v.getContext(),"请输入正确信息",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {ProjectDB projectService=new ProjectDB(v.getContext());
        Project project=new Project(Date,Tittle,Content);
        projectService.save(project);
        Toast.makeText(v.getContext(), R.string.successful, Toast.LENGTH_SHORT).show();
    }}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCancel:
                Intent intent = new Intent();
                intent.setClass(AddActivity.this, Module3.class);
                startActivity(intent);
                break;
            case R.id.btnEnter:
                try {
                    testSave(v);
                    Intent intenten = new Intent();
                    intenten.setClass(AddActivity.this, Module3.class);
                    startActivity(intenten);

                } catch (Exception e) {
                    Log.e("database error",e.toString());
                    e.printStackTrace();
                }
                break;
        }
    }
    public static String getCurDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String curdate = simpleDateFormat.format(date);
        return curdate;
    }
}
