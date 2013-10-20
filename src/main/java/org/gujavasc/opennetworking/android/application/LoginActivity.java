package org.gujavasc.opennetworking.android.application;

import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.main.MainActivity_;

import android.content.Intent;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;

@EActivity(R.layout.login)
public class LoginActivity extends BaseActivity {

    @Click
    public void loginByLinkedin() {
        startActivity(new Intent(this, MainActivity_.class));
    }

}
