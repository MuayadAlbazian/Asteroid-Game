package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class MissleKillsAsteroidCommand extends Command{
private IGameWorld gw;
	
	public MissleKillsAsteroidCommand(IGameWorld gw) {
		super("Missle Kills Asteroid");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.missleAsteroid();
		
		
	}

}
