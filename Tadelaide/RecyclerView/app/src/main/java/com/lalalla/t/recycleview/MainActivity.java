package com.lalalla.t.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                                                            //附上介绍blog：http://blog.csdn.net/lmj623565791/article/details/45059587
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);  //建立一个新的recyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));      //为recycleView简历一个layoutmanager 一般时线性布局
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());             //为recycleView建立一个实用 的adapter 这里举例仅仅是文字
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this      //这个是完成分割线的函数，具体作用写在DIviderItemDecoration类里面了
                ,DividerItemDecoration.VERTICAL_LIST));                     //总共实现了两种 一个是对于vertical 和horizon的


    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for(int i ='A';i<'z';i++){
            mDatas.add(""+(char)i);
        }
    }




    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item, parent,
                    false));
            return holder;
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));

        }
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

       class MyViewHolder extends ViewHolder{
           TextView tv;
           public MyViewHolder(View view)
           {
               super(view);
               tv = (TextView)view.findViewById(R.id.tv);
           }
                                                }
    }

}
