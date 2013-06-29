package com.dkcy.wuxing;

import java.util.Calendar;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

// Constructor for new public class/object DatePickerFragment, of class DialogFragment. implements interface.
public class DatePickerFragment extends DialogFragment
implements DatePickerDialog.OnDateSetListener {

	// Declare Calendar set to current date
	public Calendar date = Calendar.getInstance();
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		// DatePicker (Context, OnDateSetListener callback how parent is notified that date is set], year, month, day).
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
		
		// Set Calendar object using selected values		
		this.date.set(selectedYear, selectedMonth, selectedDay);
		
		// Get View object
		EditText dobtext = (EditText) getActivity().findViewById(R.id.dob_input);

		// Update View object with selected date
		dobtext.setText(date.get(Calendar.DATE) + "/" + (date.get(Calendar.MONTH)+1) + "/"+ date.get(Calendar.YEAR));
	}
	

}
