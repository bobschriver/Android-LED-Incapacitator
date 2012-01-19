package com.org.ledincapacitator;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;

public class FlashManager {
	
	private Camera camera;
	
	public FlashManager()
	{
		camera = Camera.open();
	}
	
	public void setFlashOn()
	{
		setFlashState(Parameters.FLASH_MODE_TORCH);
		
		//setFlashState(Parameters.FLASH_MODE_AUTO);

		//setFlashState(Parameters.FLASH_MODE_RED_EYE);

		//setFlashState(Parameters.FLASH_MODE_ON);
	}
	
	public void setFlashOff()
	{
		//setFlashState(Parameters.FLASH_MODE_ON);
		setFlashState(Parameters.FLASH_MODE_OFF);
	}

	private void setFlashState(String flashState)
	{
		Parameters currentParameters = camera.getParameters();
		
		
		System.out.println("In set flash, current flash state " + currentParameters.getFlashMode() + "\n");
		currentParameters.setFlashMode(flashState);
		//currentParameters.set("flash-mode", "torch");
		//currentParameters.setFocusMode(Parameters.FOCUS_MODE_INFINITY);
		camera.setParameters(currentParameters);
		camera.startPreview();
		
		
		
		Parameters newParam = camera.getParameters();
		System.out.println("In set flash, current flash state " + newParam.getFlashMode() + "\n");
	}
}
