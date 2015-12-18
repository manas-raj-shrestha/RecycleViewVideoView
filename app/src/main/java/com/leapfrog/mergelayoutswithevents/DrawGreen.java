package com.leapfrog.mergelayoutswithevents;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import org.lucasr.probe.Interceptor;

public class DrawGreen extends Interceptor {
    private final Paint mPaint;

    public DrawGreen() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(View view, Canvas canvas) {
        canvas.drawPaint(mPaint);
    }
}