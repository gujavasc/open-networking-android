package org.gujavasc.opennetworking.android.application.base;

import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class BaseActivity extends ActionBarActivity {

	private String[] tabNames = new String[] { "Evento", "Palestras", "Fotos", "Twitter" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getSupportActionBar();
        
        if (bar != null) {
	        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	        for(String tabName : tabNames) {
	        	bar.addTab(bar.newTab().setText(tabName).setTabListener(new TabListener(getSupportFragmentManager())));
	        }
        	
	        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME);

	        bar.setDisplayShowTitleEnabled(true);

	        ArrayAdapter<String> navListAdapter = new ArrayAdapter<String>(this, R.layout.spinner_textview, tabNames);

	        bar.setListNavigationCallbacks(navListAdapter, 	new OnNavigationListener() {
	        	@Override
	        	public boolean onNavigationItemSelected(int position, long itemId) {
	            	Toast.makeText(getApplicationContext(), "onNavigationItemSelected: " + position, Toast.LENGTH_LONG).show();    	
	        		return true;
	        	}
        	});
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				Toast.makeText(this, "anroid.R.id.home pressed", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				return true;
	
			case R.id.share_action:
				Toast.makeText(this, "R.id.shareitem", Toast.LENGTH_LONG).show();
				return true;
			
			case R.id.menu_item_action_provider_new_event:
				return true;
			
			case R.id.menu_item_action_provider_my_events:
				return true;

			case R.id.menu_item_action_provider_logout:
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
}
