package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Interfaces.IGameWorld;

public class NonPlayerShipButton extends Command{
	private IGameWorld gw;
	
	public NonPlayerShipButton(IGameWorld gw) {
		super("Add NPS");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		gw.addNPS();
		
		
	}

}
