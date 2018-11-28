package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class turnRightCommand extends Command{
private IGameWorld gw;
	
	public turnRightCommand(IGameWorld gw) {
		super("Turn Right");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.turnRight();
		
		
	}


}
