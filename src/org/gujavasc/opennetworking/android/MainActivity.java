package org.gujavasc.opennetworking.android;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;

import android.widget.EditText;
import org.gujavasc.opennetworking.android.fragment.DatePickerFragment;
import com.googlecode.androidannotations.annotations.ViewById;
import java.util.Calendar;

@EActivity(R.layout.activity_main)
public class MainActivity extends SherlockFragmentActivity {

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
