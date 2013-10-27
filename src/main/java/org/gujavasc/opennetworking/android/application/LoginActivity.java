package org.gujavasc.opennetworking.android.application;

import org.gujavasc.opennetworking.android.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        Button botao = (Button) findViewById(R.id.login_by_linkedin);  
        botao.setOnClickListener(new OnClickListener() {
            @Override  
            public void onClick(View v) {  
            	test();
            }  
        });  
	}
	
	private void test() {
		startActivity(new Intent(LoginActivity.this, MainActivity.class));
	}
	
}
