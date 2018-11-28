package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class MissleStrikesNPSCommand extends Command{
private IGameWorld gw;
	
	public MissleStrikesNPSCommand(IGameWorld gw) {
		super("Missle Strikes NPS");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.missleNPS();
		
		
	}

}
