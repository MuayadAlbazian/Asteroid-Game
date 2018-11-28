package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class ReloadMissleCommand extends Command{
private IGameWorld gw;
	
	public ReloadMissleCommand(IGameWorld gw) {
		super("Reload Missles");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.loadMissles();
		
		
	}


}
