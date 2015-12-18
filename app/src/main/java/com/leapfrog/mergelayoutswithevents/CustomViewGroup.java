package com.leapfrog.mergelayoutswithevents;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 12/16/2015.
 */
public class CustomViewGroup extends LinearLayout {

    @Bind(R.id.tv_username)
    TextView tvUserName;

    @Bind(R.id.iv_test)
    ImageView ivTest;

    @Bind(R.id.video_view)
    VideoView videoView;

    Bus bus;
    int height;

    public CustomViewGroup(Context context) {
        super(context, null, 0);

        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(linearLayoutParams);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_card_layout, this, true);
        ButterKnife.bind(this, view);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        height = display.getHeight();

        bus = MergeLayoutApplication.getEventBus();

        Uri video = Uri.parse("android.resource://com.leapfrog.mergelayoutswithevents/raw/videoplayback");
        videoView.setVideoURI(video);
        videoView.requestFocus();

    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bus.register(this);

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        videoView.stopPlayback();

        bus.unregister(this);
    }

    @Subscribe
    public void handleScroll(String scroll) {
        if ((height - getY()) > 1000) {
            videoView.start();
//            scalableVideoView.start();
            //Logic to play video :)
//            Log.e("****", tvUserName.getText().toString() +" " +( height-getY()));
        }
    }

}
