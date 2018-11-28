package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class HyperSpaceCommand extends Command{
private IGameWorld gw;
	
	public HyperSpaceCommand(IGameWorld gw) {
		super("HyperSpace Jump");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.jumpHyperspace();
		
		
	}


}
