package com.org.ledincapacitator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

	

public class LEDIncapacitatorActivity extends Activity{
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SeekBar frequencySeekBar = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar dutyCycleSeekBar = (SeekBar)findViewById(R.id.seekBar2);
        
        TimerManager t = new TimerManager(15 , .5);
        
        FrequencySlider f = new FrequencySlider(t);
        DutyCycleSlider d = new DutyCycleSlider(t);
        
        frequencySeekBar.setOnSeekBarChangeListener(f);
        dutyCycleSeekBar.setOnSeekBarChangeListener(d);  
        
        t.startTimer();
         
    }
}