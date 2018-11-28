package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class AccelerateCommand extends Command{
	
private IGameWorld gw;
	
	public AccelerateCommand(IGameWorld gw) {
		super("Accelerate");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.Accelerate();
		
		
		
	}


}
