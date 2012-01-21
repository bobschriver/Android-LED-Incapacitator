package com.org.ledincapacitator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class RandomFrequencyButton implements OnClickListener{
	
	TimerManager time;
	
	public RandomFrequencyButton(TimerManager t)
	{
		this.time = t;
	}

	public void onClick(View v) {
		EditText minTextBox = (EditText) ((View)v.getParent()).findViewById(R.id.editText1);
		EditText maxTextBox = (EditText) ((View)v.getParent()).findViewById(R.id.editText2);
		
		String minValueString = minTextBox.getText().toString();
		String maxValueString = maxTextBox.getText().toString();
		
		int minValue = Integer.parseInt(minValueString);
		int maxValue = Integer.parseInt(maxValueString);
		
		if(minValue <= maxValue)
		{
			time.setMinFrequency(minValue);
			time.setMaxFrequency(maxValue);
		}
		
		
		
		
	}

}
