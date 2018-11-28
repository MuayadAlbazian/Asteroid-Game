package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class ShipNPSCollision extends Command{
private IGameWorld gw;
	
	public ShipNPSCollision(IGameWorld gw) {
		super("Ship Collides With NPS");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.npsPlayership();
		
		
	}

}
