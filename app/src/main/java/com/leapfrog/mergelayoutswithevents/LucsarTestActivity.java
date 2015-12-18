package com.leapfrog.mergelayoutswithevents;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.lucasr.probe.Probe;
import org.lucasr.probe.interceptors.OvermeasureInterceptor;

/**
 * Created by Manas on 12/16/2015.
 */
public class LucsarTestActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        Probe.deploy(this, new OvermeasureInterceptor(R.id.root));

        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.lucsar_test);
    }
}
