package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class TurnMissleLauncherLeftCommand extends Command{
private IGameWorld gw;
	
	public TurnMissleLauncherLeftCommand(IGameWorld gw) {
		super("Turn MS Left");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.TurnMissleLauncherLeft();
		
		
	}

}
