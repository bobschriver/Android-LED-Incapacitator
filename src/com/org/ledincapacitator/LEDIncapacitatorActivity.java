package com.org.ledincapacitator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

	

public class LEDIncapacitatorActivity extends Activity implements OnSeekBarChangeListener{
    
	 private TimerManager t;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar1);
        
        seekBar.setOnSeekBarChangeListener(this);
        
        t = new TimerManager(15 , .5);
        
        t.startTimer();
        
        
    }
;
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		// TODO Auto-generated method stub
		System.out.println("Current progress " + progress + "\n");
		t.changeFrequency(progress, .5);
	}

	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
}