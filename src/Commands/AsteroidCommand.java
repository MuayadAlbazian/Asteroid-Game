package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class AsteroidCommand extends Command {
	private IGameWorld gw;
	
	
	public AsteroidCommand( IGameWorld gw ) {
		super("Add Asteroid");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNewAsteroid();
	}
}
