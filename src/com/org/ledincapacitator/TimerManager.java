package com.org.ledincapacitator;

import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {

	private double minFrequency;
	private double maxFrequency;
	
	private double minDuration;
	private double maxDuration;
	
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
		setDuration(duration);
	}
	
	
	public void setFrequency(double frequency) {
		setMinFrequency(frequency);
		setMaxFrequency(frequency);
	}
	
	public void setDuration(double duration)
	{
		setMinDuration(duration);
		setMaxDuration(duration);
	}
	
	public void setMinFrequency(double frequency)
	{
		this.minFrequency = frequency;
	}
	
	public void setMaxFrequency(double frequency)
	{
		this.maxFrequency = frequency;
	}
	
	public void setMinDuration(double duration)
	{
		this.minDuration = duration;
	}
	
	public void setMaxDuration(double duration)
	{
		this.maxDuration = duration;
	}
	
	public void startTimer()
	{
		
		double currFrequency = minFrequency + (Math.random() * (maxFrequency - minFrequency));
		double currDuration = minDuration + (Math.random() * (maxDuration - minDuration));
		
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
		
		long period = (long) ((1 / currFrequency) * 1000);
		long offDelay = (long) (currDuration * period);
		
		
		//timer.schedule(taskOn, 0);
		
		flash.setFlashOn();
		
		timer.schedule(taskOff, offDelay);
		timer.schedule(taskRestart, period);
	}
	
	public void stopTimer()
	{
		System.out.println("Stopping timer");
		timer.cancel();
	}
	
}
