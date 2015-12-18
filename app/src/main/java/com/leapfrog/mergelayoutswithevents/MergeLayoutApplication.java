package com.leapfrog.mergelayoutswithevents;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by Manas on 12/16/2015.
 */
public class MergeLayoutApplication extends Application {

    private static Bus eventBus;

    public static Bus getEventBus() {
        return eventBus;
    }

    public static void setEventBus(Bus eventBus) {
        MergeLayoutApplication.eventBus = eventBus;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        eventBus = new Bus();
    }

}
