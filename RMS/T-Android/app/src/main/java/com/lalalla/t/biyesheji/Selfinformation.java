package com.lalalla.t.biyesheji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Selfinformation extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfinformation);
        listView = (ListView) findViewById(R.id.selfinformationlist);


    }

    private void dialog3(){
        final String items[]={"男","女"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        builder.setSingleChoiceItems(items,0,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(Selfinformation.this, items[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(Selfinformation.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
