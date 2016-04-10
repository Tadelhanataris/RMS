package com.lalalla.t.biyesheji;

/**
 * Created by wlt on 16/4/4.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;


public class GalleryAdapter extends
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>
{

    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    private List<Integer> mHeights;

    public GalleryAdapter(Context context, List<Integer> datats)
    {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++)
        {
            mHeights.add( (int) (100 + Math.random() * 300));
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.gallery_items,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.id_gallery_item_image);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.mImg.setImageResource(mDatas.get(i));
        LayoutParams lp = viewHolder.mImg.getLayoutParams();
        int h = viewHolder.mImg.getHeight();
        int w = viewHolder.mImg.getWidth();

        lp.height = lp.width / w * h;
        viewHolder.mImg.setLayoutParams(lp);
//        viewHolder.mImg.setText(mDatas.get(i));
    }

}
