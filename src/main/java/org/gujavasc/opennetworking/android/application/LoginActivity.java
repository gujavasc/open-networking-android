package org.gujavasc.opennetworking.android.application;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.gujavasc.opennetworking.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {
	
    // SocialAuth Component
    SocialAuthAdapter adapter;
    boolean status;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        adapter = new SocialAuthAdapter(new ResponseListener());

        try {
            adapter.addConfig(Provider.LINKEDIN, "bnv8x51yjbdo", "y0nvGzOYjw1KyKdV", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button botao = (Button) findViewById(R.id.login_by_linkedin);  
        
        botao.setOnClickListener(new OnClickListener() {
            @Override  
            public void onClick(View v) {
                adapter.authorize(LoginActivity.this, Provider.LINKEDIN);
            }  
        });
	}

    private final class ResponseListener implements DialogListener {
        @Override
        public void onComplete(Bundle values) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

        @Override
        public void onError(SocialAuthError error) {
            Log.d("Share-Bar", error.getMessage());
        }

        @Override
        public void onCancel() {
            Log.d("Share-Bar", "Authentication Cancelled");
        }

        @Override
        public void onBack() {
            Log.d("Share-Bar", "Dialog Closed by pressing Back Key");
        }
    }
}
