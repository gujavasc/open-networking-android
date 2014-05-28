package org.gujavasc.opennetworking.android.application.widget;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

public class SearchActionWidget extends SearchView {

	public SearchActionWidget(Context context) {
		super(context);
	}

	@Override
	public void setOnSearchClickListener(OnClickListener listener) {
		super.setOnSearchClickListener(listener);
		Toast.makeText(getContext(), "teste", Toast.LENGTH_LONG).show();
	}
	
}
