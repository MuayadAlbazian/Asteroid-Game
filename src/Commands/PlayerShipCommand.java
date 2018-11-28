package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class PlayerShipCommand extends Command{
	private IGameWorld gw;
	
	public PlayerShipCommand(IGameWorld gw) {
			super("Add PlayerShip");
			this.gw = gw;
			
		}
		public void actionPerformed(ActionEvent e) {
			gw.addPlayerShip();
		}
		
	}
	


