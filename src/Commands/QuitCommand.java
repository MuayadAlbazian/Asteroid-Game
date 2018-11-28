package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class QuitCommand extends Command { 
	private GameWorld gw;
	
	public QuitCommand(GameWorld gw) {
		super("Quit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent E) {
		if (Dialog.show("Quit Menu", "Exit Game?", "Yes", "No")) {
			Display.getInstance().exitApplication();
		}
	}

}
