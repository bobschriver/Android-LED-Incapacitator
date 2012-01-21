package com.org.ledincapacitator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class RandomDutyCycleButton implements OnClickListener{

	TimerManager time;
	
	public RandomDutyCycleButton(TimerManager t)
	{
		this.time = t;
	}
	
	public void onClick(View v) {
		EditText minDutyCycleTextBox = (EditText)((View)v.getParent()).findViewById(R.id.editText3);
		EditText maxDutyCycleTextBox = (EditText)((View)v.getParent()).findViewById(R.id.editText4);
		
		String minDutyCycleString = minDutyCycleTextBox.getText().toString();
		String maxDutyCycleString = maxDutyCycleTextBox.getText().toString();
		
		double minValue = Double.parseDouble(minDutyCycleString);
		double maxValue = Double.parseDouble(maxDutyCycleString);
		
		if(minValue <= maxValue)
		{
			time.setMinDuration(minValue);
			time.setMaxDuration(maxValue);
		}
		
	}

}
