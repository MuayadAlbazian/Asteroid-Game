package com.mycompany.a3;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

public class BGSoundForm extends Form implements ActionListener{
	private BGSound bgSound;
	private boolean bPause = false;
	
	public BGSoundForm() {
		Button bButton = new Button("Pause/Play");
		Container bContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		bContainer.add(bButton);
		bButton.addActionListener(this);
		bgSound = new BGSound("bg.wav");
		bgSound.play();
		show();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		bPause = !bPause;
		if(bPause) {
			bgSound.pause();// TODO Auto-generated method stub
		}
		else {
			bgSound.play();
		}
		
	}

}
