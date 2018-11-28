package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class ShipHitsAsteroidCommand extends Command{
private IGameWorld gw;
	
	public ShipHitsAsteroidCommand(IGameWorld gw) {
		super("Ship Hits Asteroid");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.asteroidPlayership();
		
		
	}

}
