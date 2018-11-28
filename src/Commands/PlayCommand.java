package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PlayCommand extends Command{
private GameWorld gw;
	public PlayCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent E) {
		gw.resume();
	}
	
	

}
