package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class TurnMissileLauncherRightCommand extends Command{

	private GameWorld gw;
	public TurnMissileLauncherRightCommand(GameWorld gw) {
		super("Turn MS Right");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		gw.TurnMissleLauncherRight();
		
		
	}

}
