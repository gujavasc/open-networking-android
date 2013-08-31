package org.gujavasc.opennetworking.android.application;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.main.MainActivity_;
import org.gujavasc.opennetworking.android.fragment.DatePickerFragment;

import java.util.Calendar;

@EActivity(R.layout.login)
public class LoginActivity extends BaseActivity {

    @Click
    public void loginByLinkedin() {
        startActivity(new Intent(this, MainActivity_.class));
    }

}
