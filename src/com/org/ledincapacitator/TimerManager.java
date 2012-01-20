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
	
	public void setDuration(double duration)
	{
		this.duration = duration;
	}
	
	public void startTimer()
	{
		
		/*TimerTask taskOn = new TimerTask()
		{
			public void run()
			{
				System.out.println("Turning flash on");
				flash.setFlashOn();
				
			}
		};*/
		
		TimerTask taskOff = new TimerTask()
		{
			public void run()
			{
				System.out.println("Turning flash off");
				flash.setFlashOff();
			}
		};
		
		TimerTask taskRestart = new TimerTask()
		{
			public void run()
			{
				System.out.println("Resetting Timer");
				startTimer();
			}
		};
		
		long period = (long) ((1 / frequencyMin) * 1000);
		long offDelay = (long) (duration * period);
		
		
		//timer.schedule(taskOn, 0);
		
		flash.setFlashOn();
		
		timer.schedule(taskOff, offDelay);
		timer.schedule(taskRestart, period);
	}
	
	public void stopTimer()
	{
		timer.cancel();
	}
	
	
	
	
}
