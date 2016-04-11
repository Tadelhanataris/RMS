package com.lalalla.t.biyesheji;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gallery extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gallery);



        initDatas();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);//得到控件
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);//布置布局管理器
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

       // mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new GalleryAdapter(this, mDatas);//设置适配器
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

    }

    private void initDatas()
    {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.a,
                R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.l));
    }


    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int spanCount = -1;
            LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager)
            {spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            } else if (layoutManager instanceof StaggeredGridLayoutManager)
            {spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            }
            if(parent.getChildAdapterPosition(view) % spanCount != 0)
                outRect.left=space;
            outRect.bottom=space;
        }
    }
}


