package com.dkcy.wuxing;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
// import android.widget.EditText;


public class MainActivity extends Activity {
		
	public final static String EXTRA_MESSAGE = "com.dkcy.wuxing.MESSAGE";
	public final static String EXTRA_YEAR = "com.dkcy.wuxing.DOB_YEAR";
	public final static String EXTRA_MONTH = "com.dkcy.wuxing.DOB_MONTH";
	public final static String EXTRA_DAY = "com.dkcy.wuxing.DOB_DAY";

		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void showDatePickerDialog(View view) {
    	DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker"); // Shows and adds the datePicker fragment to the fragment manager
    }
    
    /** Called when the user selects the Send button */
    public void sendDOB(View view) {
    	// Creates intent to call DisplayZodiacActivity
        Intent intent = new Intent(this, DisplayZodiacActivity.class);
        
        // Get the DatePicker fragment
        DatePickerFragment dpFrag = (DatePickerFragment) getFragmentManager().findFragmentByTag("datePicker");
        // This is the borked line! Trying to get the date Calendar from the fragment.
        // Calendar dobSelected = dpFrag.date;
        
        // This line works for debugging purposes
        Calendar dobSelected = Calendar.getInstance();
        
        int year = dobSelected.get(Calendar.YEAR);
        int month = dobSelected.get(Calendar.MONTH);
        int day = dobSelected.get(Calendar.DATE);

        intent.putExtra(EXTRA_YEAR,year).putExtra(EXTRA_MONTH,month).putExtra(EXTRA_DAY,day);
        startActivity(intent);
    }
}