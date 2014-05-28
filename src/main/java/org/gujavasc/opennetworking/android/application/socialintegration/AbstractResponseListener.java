package org.gujavasc.opennetworking.android.application.socialintegration;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthError;

import android.os.Bundle;
import android.util.Log;

public abstract class AbstractResponseListener implements DialogListener {

    @Override
    public void onComplete(Bundle values) {
        Log.d("SocialAuthResponseListener", "Authentication successful.");
    }

    @Override
    public void onError(SocialAuthError error) {
        Log.d("SocialAuthResponseListener", error.getMessage());
    }

    @Override
    public void onCancel() {
        Log.d("SocialAuthResponseListener", "Authentication cancelled.");
    }

    @Override
    public void onBack() {
        Log.d("SocialAuthResponseListener", "Dialog closed by pressing Back Key.");
    }

}
