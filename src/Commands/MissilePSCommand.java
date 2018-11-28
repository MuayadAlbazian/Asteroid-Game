package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class MissilePSCommand extends Command{
private IGameWorld gw;
	
	public MissilePSCommand(IGameWorld gw) {
		super("NPS Missle Strikes PS");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.misslePlayership();
		
		
	}

}
