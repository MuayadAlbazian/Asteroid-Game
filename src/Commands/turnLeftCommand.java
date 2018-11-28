package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class turnLeftCommand extends Command {
	private IGameWorld gw;
	
	public turnLeftCommand(IGameWorld gw) {
		super("Turn Left");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.turnLeft();
		
		
	}

	

}
