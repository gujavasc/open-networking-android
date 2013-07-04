package org.gujavasc.opennetworking.android;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

	private HelloAndroidActivity activity;

	@Before
	public void setUp() {
		activity = new HelloAndroidActivity();
		activity.onCreate(null);
	}

	@Test
	public void itProperlyGreetsYou() {
		assertThat(textOf(id.greet_them), equalTo("Hello android-travis-ci-example!"));
	}

	private String textOf(int id) {
		final TextView textView = (TextView) activity.findViewById(id);
		return textView.getText().toString();
	}
}
