package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;
import com.mycompany.a3.GameWorld;

public class SoundCommand extends Command{
	private IGameWorld gw;
	
	
	public SoundCommand(IGameWorld gw) {
		super("Sound");
		this.gw = gw;
	}
	public void soundCommand() {
		boolean sound = gw.getSound();
		if(sound == false) {
			gw.setSound(true);
		}
		else {
			gw.setSound(false);
		}
	}
	public void actionPerformed(ActionEvent E) {
			gw.soundCommand();
		
	}

}
