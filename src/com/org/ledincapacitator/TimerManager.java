package com.org.ledincapacitator;

import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {

	private double frequencyMin;
	private double frequencyMax;
	
	private double duration;
	
	private FlashManager flash;
	
	private Timer timer;
	
	public TimerManager()
	{
		flash = new FlashManager();
		timer = new Timer();
	}
	
	public TimerManager(double frequency, double duration)
	{
		this();
		setFrequency(frequency);
		this.duration = duration;
	}
	

	public TimerManager(double frequencyMin , double frequencyMax , double duration)
	{
		this();
		this.frequencyMin = frequencyMin;
		this.frequencyMax = frequencyMax;
		
		this.duration = duration;
	}
	
	public void setFrequency(double frequency) {
		setFrequencyMin(frequency);
		setFrequencyMax(frequency);
	}
	
	public void setFrequencyMin(double frequency)
	{
		this.frequencyMin = frequency;
	}
	
	public void setFrequencyMax(double frequency)
	{
		this.frequencyMax = frequency;
	}
	
	public void startTimer()
	{
		
		TimerTask taskOn = new TimerTask()
		{
			public void run()
			{
				flash.setFlashOn();
			}
		};
		
		TimerTask taskOff = new TimerTask()
		{
			public void run()
			{
				flash.setFlashOff();
			}
		};
		
		long period = (long) ((1 / frequencyMin) * 1000);
		long offDelay = (long) (duration * period);
		
		
		timer.schedule(taskOn, 0, period);
		timer.schedule(taskOff, offDelay , period);
	}
	
	public void stopTimer()
	{
		timer.cancel();
	}
	
}
