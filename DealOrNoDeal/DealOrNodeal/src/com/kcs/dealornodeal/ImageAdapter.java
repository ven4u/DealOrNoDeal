package com.kcs.dealornodeal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(90,90));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(3,3,3,3);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Initial image Array 
    public Integer[] mThumbIds = {
    		R.drawable.i1, R.drawable.i2,
            R.drawable.i3, R.drawable.i4,
            R.drawable.i5, R.drawable.i6,
            R.drawable.i7, R.drawable.i8,
            R.drawable.i9, R.drawable.i10,
            R.drawable.i11, R.drawable.i12,
            R.drawable.i13, R.drawable.i14,
            R.drawable.i15, R.drawable.i16,
            R.drawable.i17
    };
    // Dollor Images
    public Integer[] mDollerIds = {
    		R.drawable.d100d, R.drawable.d250d,
            R.drawable.d500d, R.drawable.d750d,
            R.drawable.d1000d, R.drawable.d2500d,
            R.drawable.d5000d, R.drawable.d7500d,
            R.drawable.d10000d, R.drawable.d25000d,
            R.drawable.d50000d, R.drawable.d75000d,
            R.drawable.d100000d, R.drawable.d250000d,
            R.drawable.d500000d, R.drawable.d750000d,
            R.drawable.d1000000d
    };	
    // cancelled Dollor Images
    public Integer[] mCanclledDollerIds = {
    		R.drawable.c100d, R.drawable.c250d,
            R.drawable.c500d, R.drawable.c750d,
            R.drawable.c1000d, R.drawable.c2500d,
            R.drawable.c5000d, R.drawable.c7500d,
            R.drawable.c10000d, R.drawable.c25000d,
            R.drawable.c50000d, R.drawable.c75000d,
            R.drawable.c100000d, R.drawable.c250000d,
            R.drawable.c500000d, R.drawable.c750000d,
            R.drawable.c1000000d
    };	
    public Integer empty = R.drawable.empty;
    public Integer start = R.drawable.finalstart;
    public Integer questionMarkBreifcase = R.drawable.yourbriefcase;
}