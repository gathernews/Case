package com.itunes.hepsiburada.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WImageView extends ImageView {

    public static double IMAGE_RATIO = 0.5848;

    public WImageView(Context context) {
        super(context);
    }

    public WImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = getMeasuredWidth();
        int h = (int) Math.ceil(w * IMAGE_RATIO);
        setMeasuredDimension(w, h);
    }
}