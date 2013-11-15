package org.gujavasc.opennetworking.android.application;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;
import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.socialintegration.AbstractResponseListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener {

    private static SocialAuthAdapter adapter;

    private Button loginLinkedinButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        adapter = new SocialAuthAdapter(new AbstractResponseListener() {
            @Override
            public void onComplete(Bundle values) {
                super.onComplete(values);
                adapter.getUserProfileAsync(new ProfileDataListener());
            }
        });

        try {
            adapter.addConfig(Provider.LINKEDIN, "bnv8x51yjbdo", "y0nvGzOYjw1KyKdV", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ((GlobalVars) getApplication()).setAdapter(adapter);

        loginLinkedinButton = (Button) findViewById(R.id.login_by_linkedin);
        loginLinkedinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(loginLinkedinButton)) {
            adapter.authorize(LoginActivity.this, Provider.LINKEDIN);
        }
    }

    public static SocialAuthAdapter getS() {
        return adapter;
    }

    class ProfileDataListener implements SocialAuthListener<Profile> {
        public ProfileDataListener() {}

        @Override
        public void onExecute(String provider, Profile t) {
            Profile profileMap = t;
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("profile", profileMap);
            startActivity(intent);
        }

        @Override
        public void onError(SocialAuthError e) {}
    }
}
