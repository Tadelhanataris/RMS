package com.lalalla.t.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class notifications extends AppCompatActivity {
    ProjectDB db;
    private String  date;
    private String tittle;
    private String content;
    private Button notificationsbtnback;
    private Integer id;
    private TextView notificationsdate;
    private TextView notificationstittle;
    private TextView notificationscontent;
    Notification notifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        db = new ProjectDB(getApplicationContext());
        Intent i = getIntent();
        id = i.getIntExtra("id", 0);
        notifications = db.findnotification(id);
        date = notifications.getdate();
        tittle = notifications.getTittle();
        content = notifications.getContent();
        notificationsdate= (TextView) findViewById(R.id.noticicationsdate);
        notificationstittle= (TextView) findViewById(R.id.noticicationstittle);
        notificationscontent= (TextView) findViewById(R.id.noticicationscontent);
        notificationsdate.setText(date);
        notificationstittle.setText(tittle);
        notificationscontent.setText(content);
        notificationsbtnback= (Button) findViewById(R.id.noticicationsbtnback);
        notificationsbtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    }
