package org.gujavasc.opennetworking.android.application.main;

import java.util.Calendar;

import org.gujavasc.opennetworking.android.R;
import org.gujavasc.opennetworking.android.application.BaseActivity;
import org.gujavasc.opennetworking.android.fragment.DatePickerFragment;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.edit_text_search)
    EditText mSearch;

    @Click
    public void buttonSearch() {
        DatePickerFragment date = new DatePickerFragment();

        Calendar calender = Calendar.getInstance();

        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));

        date.setArguments(args);
        date.setCallBack(dateCallback);
        date.show(getSupportFragmentManager(), "Date Picker");
    }

    OnDateSetListener dateCallback = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Toast.makeText(MainActivity.this, String.valueOf(year) + "-" + String.valueOf(monthOfYear) + "-" + String.valueOf(dayOfMonth), Toast.LENGTH_LONG).show();
        }

    };

}
