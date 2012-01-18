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
	}
	
	public void setFlashOff()
	{
		setFlashState(Parameters.FLASH_MODE_OFF);
	}

	private void setFlashState(String flashState)
	{
		Parameters currentParameters = camera.getParameters();
		currentParameters.setFlashMode(flashState);
		camera.setParameters(currentParameters);
	}
}
