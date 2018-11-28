package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class GameClockCommand extends Command
{

private IGameWorld gw;
	
	public GameClockCommand(IGameWorld gw) {
		super("Game Clock Tick");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.clockTick();
	
		
		
	}
}
