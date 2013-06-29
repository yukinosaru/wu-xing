package com.dkcy.wuxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayZodiacActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
        // Get the date from the intent
        Intent intent = getIntent();
		int day = intent.getIntExtra(MainActivity.EXTRA_DAY,0);
		int month = intent.getIntExtra(MainActivity.EXTRA_MONTH,0);
		int year = intent.getIntExtra(MainActivity.EXTRA_YEAR,0);
		
        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        
        // Create a nice string with the date
        String dob = "Day: " + day + " Month: " + (month+1) + " Year: " + year;
        textView.setText(dob);
        
        setContentView(textView);
        
        // Create two fragments - one for animal, one for element.
	}

}
