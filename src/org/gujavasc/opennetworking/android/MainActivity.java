package org.gujavasc.opennetworking.android;

import android.widget.EditText;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.edit_text_search)
    EditText mSearch;

}
