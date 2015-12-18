package com.leapfrog.mergelayoutswithevents;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Manas on 12/17/2015.
 */
public class CustomParentLayout extends ViewGroup {

    int measureCount = 0;
    int layoutCount = 0;

    public CustomParentLayout(Context context) {
        super(context);
    }

    public CustomParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }

        measureCount++;
        Log.e(">><<", "onMeasure " + measureCount);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.layout(changed,l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(l,t,r,getChildAt(i).getMeasuredHeight());
        }

        layoutCount++;
        Log.e(">><<", "onLayout " + layoutCount);
    }


//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//        layoutCount++;
//        Log.e(">><<", "onLayout " + layoutCount);
//    }
}
