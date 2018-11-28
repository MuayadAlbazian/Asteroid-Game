package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class AsteroidCollisionCommand extends Command{
private IGameWorld gw;
	
	public AsteroidCollisionCommand(IGameWorld gw) {
		super("Asteroid Collision");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.asteroidCollision();
		
		
	}

}
