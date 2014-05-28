package org.gujavasc.opennetworking.android.application;

import org.brickred.socialauth.android.SocialAuthAdapter;

import android.app.Application;

public class GlobalVars extends Application {

    private SocialAuthAdapter adapter;

    public GlobalVars() {}

    public void setAdapter(SocialAuthAdapter adapter) {
        this.adapter = adapter;
    }

    public SocialAuthAdapter getAdapter() {
        return adapter;
    }

}
