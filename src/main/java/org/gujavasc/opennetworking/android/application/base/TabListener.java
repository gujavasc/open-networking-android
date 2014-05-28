package org.gujavasc.opennetworking.android.application.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.Tab;

public class TabListener implements android.support.v7.app.ActionBar.TabListener {

	private FragmentManager supportFragmentManager;
	
	public TabListener(FragmentManager supportFragmentManager) {
		this.supportFragmentManager = supportFragmentManager;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}

}
