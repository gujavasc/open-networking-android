package org.gujavasc.opennetworking.android.application.base;

import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.LoginActivity;
import org.gujavasc.opennetworking.android.application.MainActivity;
import org.gujavasc.opennetworking.android.application.event.EventListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.analytics.tracking.android.Log;

public class BaseActivity extends ActionBarActivity implements TabListener {

    private final String[] tabNames = new String[] { "Evento", "Palestras", "Fotos", "Twitter" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configActionBar();
    }

    private void configActionBar() {
        ActionBar bar = getSupportActionBar();

        if (bar == null) {
            return;
        }

        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (String tabName : tabNames) {
            bar.addTab(bar.newTab().setText(tabName).setTabListener(this));
        }

        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME);

        bar.setDisplayShowTitleEnabled(true);

        ArrayAdapter<String> navListAdapter = new ArrayAdapter<String>(this, R.layout.spinner_textview, tabNames);

        bar.setListNavigationCallbacks(navListAdapter, new OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int position, long itemId) {
                Toast.makeText(getApplicationContext(), "onNavigationItemSelected: " + position, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Ações dos menus (COMPARTILHAR, PESQUISAR, NOVO EVENTO, MEUS EVENTOS E SAIR).
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.v("android.R.id.home pressed.");

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                return true;

            case R.id.menu_item_share_action:
                Log.v("R.id.menu_item_share_action pressed.");

                return true;

            case R.id.menu_item_new_event:
                Log.v("R.id.menu_item_new_event pressed.");

                return true;

            case R.id.menu_item_my_events:
                Log.v("R.id.menu_item_my_events pressed.");

                Intent intent2 = new Intent(this, EventListActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);

                return true;

            case R.id.menu_item_logout:
                Log.v("R.id.menu_item_logout pressed.");

                // ((GlobalVars) getApplication()).getAdapter().signOut(this, "Open");
                LoginActivity.getS().signOut(this, "");

                Intent intent3 = new Intent(BaseActivity.this, LoginActivity.class);
                startActivity(intent3);

                return true;

            default:
                Log.v("Ação não implementado para o id " + item.getItemId() + " no método onOptionsItemSelected (BaseActivity).");

                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

}
