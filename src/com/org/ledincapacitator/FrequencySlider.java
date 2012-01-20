package com.org.ledincapacitator;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class FrequencySlider implements OnSeekBarChangeListener {

	TimerManager time;
	
	public FrequencySlider(TimerManager t)
	{
		this.time = t;
	}
	
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		double frequency = progress + 5;
		
		time.setFrequency(frequency);

	}

	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

}
