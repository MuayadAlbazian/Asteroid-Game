package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class FireMissleCommand extends Command{
private IGameWorld gw;
	
	public FireMissleCommand(IGameWorld gw) {
		super("Fire Missle");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.fireMissle();
		
		
	}


}
