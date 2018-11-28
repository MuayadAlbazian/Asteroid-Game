package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class SpaceStationCommand extends Command{
	private GameWorld gw;
	
	public SpaceStationCommand(GameWorld gw) {
		super("Add SpaceStation");
		this.gw = gw;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.addSpaceStation();
	}
}
