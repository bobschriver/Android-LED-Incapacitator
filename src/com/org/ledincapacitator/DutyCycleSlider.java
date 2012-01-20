package com.org.ledincapacitator;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DutyCycleSlider implements OnSeekBarChangeListener {

	TimerManager time;
	
	public DutyCycleSlider(TimerManager t)
	{
		super();
		this.time = t;
	}
	
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		int duration_int = progress + 1;
		
		double duration = (float)(duration_int) / 10;
		
		time.setDuration(duration);
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
