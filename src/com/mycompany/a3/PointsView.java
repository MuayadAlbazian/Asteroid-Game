package com.mycompany.a3;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Interfaces.IGameWorld;

public class PointsView extends Container implements Observer {
	
	private Label pointsTextLabel;
	private Label MisslesLabel;
	private Label LivesLabel;
	private Label SoundLabel;
	private Label TimeLabel;
	private Label onoff;
	
	GameWorld gw;

	
	
	
	public BGSound bg = new BGSound("bg.wav");
	
	public PointsView(GameWorld gw) {
		
		
		pointsTextLabel = new Label("Points: " + gw.getPlayerScore());
		LivesLabel = new Label("Lives: " + gw.getLives());
		MisslesLabel = new Label("Missiles: " + gw.getMissles());
		SoundLabel = new Label("Sound: ");
		TimeLabel = new Label("Time: ");
		
		
		
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		LivesLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		SoundLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		MisslesLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		TimeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		
		add(pointsTextLabel);
		add(LivesLabel);
		add(MisslesLabel);
		add(SoundLabel);
		add(TimeLabel);
		if(gw.getSound()) {
			bg.play();
			
		}
		
	}
	

	
	public void update(Observable o, Object arg) {
		IGameWorld gw = (IGameWorld)o;
		pointsTextLabel.setText("Score: " + gw.getPlayerScore());
		MisslesLabel.setText("Missiles: " + ((IGameWorld)o).getMissles());
		LivesLabel.setText("Lives: " + gw.getLives());
		SoundLabel.setText("Sound: " + (gw.getSound() ? "On" : "Off"));
		TimeLabel.setText("Time: " + gw.getTimer()/10);
		if(gw.getSound() && gw.getPlay()) {
			bg.play();
		}
		else {
			bg.pause();
		}
		this.repaint();
		// TODO Auto-generated method stub
		
	}

}
