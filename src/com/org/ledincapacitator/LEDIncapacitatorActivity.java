package com.org.ledincapacitator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

	

public class LEDIncapacitatorActivity extends Activity{
    
	TimerManager time;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SeekBar frequencySeekBar = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar dutyCycleSeekBar = (SeekBar)findViewById(R.id.seekBar2);
        
        time = new TimerManager(15 , .5);
        
        FrequencySlider f = new FrequencySlider(time);
        DutyCycleSlider d = new DutyCycleSlider(time);
        
        frequencySeekBar.setOnSeekBarChangeListener(f);
        dutyCycleSeekBar.setOnSeekBarChangeListener(d);  
        
        Button randomFrequencyButton = (Button)findViewById(R.id.button1);
        
        RandomFrequencyButton rF = new RandomFrequencyButton(time);
        
        randomFrequencyButton.setOnClickListener(rF);
        
        Button randomDutyCycleButton = (Button)findViewById(R.id.button2);
        
        RandomDutyCycleButton rDC = new RandomDutyCycleButton(time);
        
        randomDutyCycleButton.setOnClickListener(rDC);
        
        time.startTimer();
         
    }
    
    
    @Override
    public void onPause()
    {
    	time.stopTimer();
    }
    
    @Override
    public void onStop()
    {
    	time.stopTimer();
    }
}