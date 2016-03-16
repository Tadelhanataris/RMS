package com.lalalla.t.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class newss extends AppCompatActivity {
    ProjectDB db;
    private String  date;
    private String tittle;
    private String content;
    private Button newssbtnback;
    private Integer id;
    private TextView newssdate;
    private TextView newsstittle;
    private TextView newsscontent;
    News newss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newss);
        db = new ProjectDB(getApplicationContext());
        Intent i = getIntent();
        id = i.getIntExtra("id", 0);
        newss = db.findnews(id);
        date = newss.getdate();
        tittle = newss.getTittle();
        content = newss.getContent();
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
