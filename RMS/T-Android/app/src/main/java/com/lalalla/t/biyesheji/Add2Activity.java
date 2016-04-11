package com.lalalla.t.biyesheji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Add2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
private RadioButton yibanxiangmu;
    private RadioGroup yibanxiangmuzu;
    private RadioButton yanxuzizhuxiangmu;
    private RadioButton dingxiangzizhuxiangmu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivityadd2);

        yibanxiangmu = (RadioButton) findViewById(R.id.yibanxiangmu);
        yibanxiangmuzu = (RadioGroup) findViewById(R.id.yibanxiangmuzu);
        yanxuzizhuxiangmu = (RadioButton) findViewById(R.id.yanxuzizhuxiangmu);
        dingxiangzizhuxiangmu = (RadioButton) findViewById(R.id.dingxiangzizhuxiangmu);
        yibanxiangmu.setOnCheckedChangeListener(this);
        yanxuzizhuxiangmu.setOnCheckedChangeListener(this);
        dingxiangzizhuxiangmu.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(yibanxiangmu.isChecked()){
    yibanxiangmuzu.setVisibility(yibanxiangmuzu.VISIBLE);
}
        else {
            yibanxiangmuzu.setVisibility(yibanxiangmuzu.GONE);
        }

    }
}
