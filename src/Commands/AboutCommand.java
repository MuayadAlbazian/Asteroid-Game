package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AboutCommand extends Command{
private GameWorld gw;
	
	public AboutCommand(GameWorld gw) {
		super("About");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent E) {
		if (Dialog.show("Muayad Albazian", "CSC- 133", "", "Close")) {
		}
	}

}
