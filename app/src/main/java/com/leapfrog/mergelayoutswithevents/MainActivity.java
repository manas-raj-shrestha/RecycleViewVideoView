package com.leapfrog.mergelayoutswithevents;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import com.squareup.otto.Bus;

import org.lucasr.probe.Probe;
import org.lucasr.probe.interceptors.OvermeasureInterceptor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    @Bind(R.id.rc_video_test)
    RecyclerView recyclerView;

//    @Bind(R.id.video_view)
//    VideoView videoView;

    View.OnTouchListener gestureListener;
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Probe.deploy(this, new OvermeasureInterceptor(R.id.rl_parent));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(this));

        bus = MergeLayoutApplication.getEventBus();
        bus.register(this);

        final GestureDetector gestureDetector = new GestureDetector(this);
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        recyclerView.setOnTouchListener(gestureListener);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                bus.post("object");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                bus.post("object");
            }
        });

//        Uri video = Uri.parse("android.resource://com.leapfrog.mergelayoutswithevents/raw/videoplayback");
//        videoView.setVideoURI(video);
//        videoView.requestFocus();
//        videoView.start();


    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.e("**", "down");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.e("**", "fling");
        return false;
    }

//    @OnClick({R.id.btn_start_video})
//    public void startVideo() {
//        Log.e("==", "video should start");
//    }
}
