package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable{
	private Media m;
	
	public BGSound(String filename) {
		try {
    		InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+filename);
    		
    		m = MediaManager.createMedia(is, "audio/wav);");
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
	public void pause() { m.pause(); }
	public void play() { m.play(); }
	
	
	@Override
	public void run() {
		m.setTime(0);
		m.play();
		// TODO Auto-generated method stub
		
	}

}
