package org.gujavasc.opennetworking.android.application;

import org.brickred.socialauth.Profile;
import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.base.BaseActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	    
    Profile profileMap;
    TextView name;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        profileMap = (Profile) getIntent().getSerializableExtra("profile");
        
        name = (TextView) findViewById(R.id.nome_usuario);
        name.setText("Bem vindo " + profileMap.getFirstName() + " " + profileMap.getLastName() + "!");
    }
    
}
