package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class RefuelCommand extends Command{
	
	private GameWorld gw;

	public RefuelCommand(GameWorld gw) {
		super("Refuel");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent E) {
		if(gw.getPlay() == false) {
			gw.refuel();
		}
		else {
			System.out.println("You have to pause the game to refuel.");
		}
		
	}
}
