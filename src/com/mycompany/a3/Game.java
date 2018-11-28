package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.Interfaces.iMoveable;

import Commands.AboutCommand;
import Commands.AccelerateCommand;
import Commands.AsteroidCollisionCommand;
import Commands.AsteroidCommand;
import Commands.DecelerateCommand;
import Commands.FireMissleCommand;
import Commands.GameClockCommand;
import Commands.HyperSpaceCommand;
import Commands.MissilePSCommand;
import Commands.MissleKillsAsteroidCommand;
import Commands.MissleStrikesNPSCommand;
import Commands.NonPlayerShipButton;
import Commands.PlayCommand;
import Commands.PlayerShipCommand;
import Commands.QuitCommand;
import Commands.RefuelCommand;
import Commands.ReloadMissleCommand;
import Commands.ShipHitsAsteroidCommand;
import Commands.ShipNPSCollision;
import Commands.SoundCommand;
import Commands.SpaceStationCommand;
import Commands.TurnMissileLauncherRightCommand;
import Commands.TurnMissleLauncherLeftCommand;
import Commands.turnLeftCommand;
import Commands.turnRightCommand;

import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; import java.lang.String;
import java.util.Iterator;



public class Game extends Form implements Runnable{
	
	private GameWorld gw;
	private GameWorldProxy gwProxy;
	private PointsView pv;
	private MapView mv;
	
	
	
	//CREATING VARIABLES FOR COMMANDS
	private AsteroidCommand addAsteroid;
	private PlayerShipCommand addPS;
	private NonPlayerShipButton addNPS;
	private AccelerateCommand accelerate;
	private DecelerateCommand decelerate;
	private turnLeftCommand leftTurn;
	private turnRightCommand rightTurn;
	private FireMissleCommand fireMissle;
	private HyperSpaceCommand jump;
	private ReloadMissleCommand reload;
	private MissleKillsAsteroidCommand mka;
	private MissleStrikesNPSCommand nps;
	private MissilePSCommand npsm;
	private ShipHitsAsteroidCommand ShipAsteroid;
	private ShipNPSCollision ShipNPS;
	private AsteroidCollisionCommand AsteroidCollision;
	private GameClockCommand gameClock;
	private SpaceStationCommand addSS;
	private QuitCommand quitCommand;
	private TurnMissleLauncherLeftCommand msLeft;
	private PlayCommand play;
	private RefuelCommand refuel;
	private TurnMissileLauncherRightCommand msRight;

	
	
	//CREATING VARIABLES FOR BUTTIONS
	private ButtonLayout asteroidButton;
	private ButtonLayout psButton;
	private ButtonLayout npsButton;
	private ButtonLayout accelerateButton;
	private ButtonLayout decelerateButton;
	private ButtonLayout turnLeftButton;
	private ButtonLayout turnRightButton;
	private ButtonLayout fireMissleButton;
	private ButtonLayout jumpButton;
	private ButtonLayout ReloadMissleButton;
	private ButtonLayout MissleAsteroidButton;
	private ButtonLayout MissleNPSButton;
	private ButtonLayout MissilePSButton;
	private ButtonLayout ShipAsteroidButton;
	private ButtonLayout ShipNPSButton;
	private ButtonLayout AsteroidCollisionButton;
	private ButtonLayout GameClockButton;
	private ButtonLayout ssButton;
	private ButtonLayout QuitButton;
	private ButtonLayout msButtonL;
	public static ButtonLayout playButton;
	public static ButtonLayout RefuelButton;
	public ButtonLayout msright;

	
	public Game() {
		gw = new GameWorld();
		gw.init();
		this.pv = new PointsView(gw);
		this.mv = new MapView();
		this.gwProxy = new GameWorldProxy(this.gw);
		
		
		
		//IMPLEMENTING THE MENU BARS
		
		Toolbar toolbar1 = new Toolbar();
		//Toolbar toolbar2 = new Toolbar();
		setToolbar(toolbar1);
		//setToolbar(toolbar2);
		TextField commandsTF = new TextField();
		//TextField fileTF = new TextField();
		toolbar1.setTitleComponent(commandsTF);
		//toolbar2.setTitleComponent(fileTF);
		Command fileItem = new Command("File");
		Command newItem = new Command("New");
		Command saveItem = new Command("Save");
		Command undoItem = new Command("Undo");
		Command soundItem = new Command("Sound");
		SoundCommand soundCommand = new SoundCommand(gw);
		
		
		CheckBox soundItemBox = new CheckBox("Sound");
		soundItemBox.getAllStyles().setBgTransparency(255);
		soundItemBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundItem.putClientProperty("SideComponent", soundItemBox);
		AboutCommand aboutCommand = new AboutCommand(gw);
		
		toolbar1.addCommandToOverflowMenu(fileItem);
		toolbar1.addCommandToOverflowMenu(newItem);
		toolbar1.addCommandToOverflowMenu(saveItem);
		toolbar1.addCommandToOverflowMenu(undoItem);
		toolbar1.addCommandToOverflowMenu(soundCommand);
		toolbar1.addCommandToOverflowMenu(aboutCommand);
		toolbar1.addComponentToSideMenu(soundItemBox);
		
		
		Container bContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		this.setTitle("Asteroid Game");
		setLayout(new BorderLayout());
		
		
		//GAME INFORMATION
	
		
		add(BorderLayout.NORTH, pv);
		this.gw.addObserver(pv);
		
		add(BorderLayout.CENTER, mv);
		this.gw.addObserver(mv);
		

		//PLAYBUTTON
		
		playButton = new ButtonLayout("PAUSE");
		play = new PlayCommand(gw);
		playButton.setCommand(play);
		bContainer.add(playButton);
		
		// ASTEROID BUTTON
		asteroidButton = new ButtonLayout("Add Asteroid");
		addAsteroid = new AsteroidCommand(gw);
		asteroidButton.setCommand(addAsteroid);
		bContainer.add(asteroidButton);
		toolbar1.addCommandToSideMenu(addAsteroid);
		
		
		//adding NPS Button
		
		npsButton = new ButtonLayout("Add Enemy Ship");
		addNPS = new NonPlayerShipButton(gw);
		npsButton.setCommand(addNPS);
		bContainer.add(npsButton);
		toolbar1.addCommandToSideMenu(addNPS);

		
		//Adding playship button
		psButton = new ButtonLayout("Add PlayerShip");
		addPS = new PlayerShipCommand(gw);
		psButton.setCommand(addPS);
		bContainer.add(psButton);
		toolbar1.addCommandToSideMenu(addPS);
		
		//Add SpaceStation
		ssButton = new ButtonLayout("Add SpaceStation");
		addSS = new SpaceStationCommand(gw);
		ssButton.setCommand(addSS);
		bContainer.add(ssButton);
		toolbar1.addCommandToSideMenu(addSS);
		
		//ACCELERATE COMMAND
		accelerateButton = new ButtonLayout("Accelerate");
		accelerate = new AccelerateCommand(gw);
		accelerateButton.setCommand(accelerate);
		bContainer.add(accelerateButton);
		addKeyListener(-91, accelerate);
		
		//DECELERATE COMMAND
		decelerateButton = new ButtonLayout("Decelerate");
		decelerate = new DecelerateCommand(gw);
		decelerateButton.setCommand(decelerate);
		bContainer.add(decelerateButton);
		addKeyListener(-92, decelerate);
		
		//TURNING left
		turnLeftButton = new ButtonLayout("Turn Left");
		leftTurn = new turnLeftCommand(gw);
		turnLeftButton.setCommand(leftTurn);
		bContainer.add(turnLeftButton);
		addKeyListener(-93, leftTurn);
		
		//TURNING right
		turnRightButton = new ButtonLayout("Turn Right");
		rightTurn = new turnRightCommand(gw);
		turnRightButton.setCommand(rightTurn);
		bContainer.add(turnRightButton);
		addKeyListener(-94, rightTurn);
		
		//TURN Missle Launcher Left
				msButtonL = new ButtonLayout("Turn MS Left");
				msLeft = new TurnMissleLauncherLeftCommand(gw);
				msButtonL.setCommand(msLeft);
				bContainer.add(msButtonL);
				//TURN Missle Launcher Right
				msright = new ButtonLayout("Turn MS Right");
				msRight = new TurnMissileLauncherRightCommand(gw);
				msright.setCommand(msRight);
				bContainer.add(msright);

		
		//FIRING A MISSLE
		fireMissleButton = new ButtonLayout("Fire Missle");
		fireMissle = new FireMissleCommand(gw);
		fireMissleButton.setCommand(fireMissle);
		bContainer.add(fireMissleButton);
		addKeyListener('f', fireMissle);
		
		// JUMPING THROUGHT HYPERSPACE
		jumpButton = new ButtonLayout("Jump HyperSpace");
		jump = new HyperSpaceCommand(gw);
		jumpButton.setCommand(jump);
		bContainer.add(jumpButton);
		addKeyListener('j', jump);
		
		//reloading missle
		ReloadMissleButton = new ButtonLayout("Load Missiles");
		reload = new ReloadMissleCommand(gw);
		ReloadMissleButton.setCommand(reload);
		bContainer.add(ReloadMissleButton);
		toolbar1.addCommandToSideMenu(reload);
		
		RefuelButton = new ButtonLayout("Refuel");
		refuel = new RefuelCommand(gw);
		RefuelButton.setCommand(refuel);
		bContainer.add(RefuelButton);
		
		/*
		//Missle Kills Asteroid
		MissleAsteroidButton = new ButtonLayout("Missile Hits Asteroid");
		mka = new MissleKillsAsteroidCommand(gw);
		MissleAsteroidButton.setCommand(mka);
		bContainer.add(MissleAsteroidButton);
		toolbar1.addCommandToSideMenu(mka);
		
		//Missle Strikes NPS
		MissleNPSButton = new ButtonLayout("Missile Strikes NPS");
		nps = new MissleStrikesNPSCommand(gw);
		MissleNPSButton.setCommand(nps);
		bContainer.add(MissleNPSButton);
		toolbar1.addCommandToSideMenu(nps);
		
		//missile crashes into asteroid
		MissilePSButton = new ButtonLayout("Missile Strikes PS");
		npsm = new MissilePSCommand(gw);
		MissilePSButton.setCommand(npsm);
		bContainer.add(MissilePSButton);
		toolbar1.addCommandToSideMenu(npsm);
		
		//Ship crashes into asteroid
		ShipAsteroidButton = new ButtonLayout("Ship Crashes into Asteroid");
		ShipAsteroid = new ShipHitsAsteroidCommand(gw);
		ShipAsteroidButton.setCommand(ShipAsteroid);
		bContainer.add(ShipAsteroidButton);
		toolbar1.addCommandToSideMenu(ShipAsteroid);
		
		//ship collides with nps
		ShipNPSButton = new ButtonLayout("Ship Collides With NPS");
		ShipNPS = new ShipNPSCollision(gw);
		ShipNPSButton.setCommand(ShipNPS);
		bContainer.add(ShipNPSButton);
		toolbar1.addCommandToSideMenu(ShipNPS);
		
		//ASTEROID COLLISION
		AsteroidCollisionButton = new ButtonLayout("Asteroid Collision");
		AsteroidCollision = new AsteroidCollisionCommand(gw);
		AsteroidCollisionButton.setCommand(AsteroidCollision);
		bContainer.add(AsteroidCollisionButton);
		toolbar1.addCommandToSideMenu(AsteroidCollision);
		
		//GameCLock
		GameClockButton = new ButtonLayout("Game Clock");
		gameClock = new GameClockCommand(gw);
		GameClockButton.setCommand(gameClock);
		bContainer.add(GameClockButton);
		toolbar1.addCommandToSideMenu(gameClock);
		*/
		//Quit
		QuitButton = new ButtonLayout("Quit");
		quitCommand = new QuitCommand(gw);
		QuitButton.setCommand(quitCommand);
		bContainer.add(QuitButton);
		toolbar1.addCommandToSideMenu(quitCommand);
		
		
		


		//adding components
		

		add(BorderLayout.WEST, bContainer);
		
		
		UITimer timer = new UITimer(this);
		timer.schedule(100, true, this);
		
		show();


		
	}

	public void run() {
		 if(gw.getPlay()) {
			gw.clockTick();
			mv.repaint();
			int roll = GameWorld.getRandInt(0, 1000);
			if(roll >= 0 && roll <= 40) {
				gw.addNPS();
			}
			if(gw.getLives() == 0) {
				gw.pause();
				gw.gameOver.play();
				if (Dialog.show("GAME OVER","" + gw.getPlayerScore(), "Quit", "")) {
					Display.getInstance().exitApplication();
				}
			}

	}
}
		
	

}
