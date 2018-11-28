package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Random;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.mycompany.Interfaces.IGameWorld;
import com.mycompany.Interfaces.IIterator;
import com.mycompany.Interfaces.iMoveable;

public class GameWorld extends Observable implements IGameWorld {
	Random random = new Random();
	
	private static GameCollection gameCollection = new GameCollection();
	
	private IIterator iterator;

	
	
	
	private final static double width = 1024;
	private final static double height = 768; 
	
	

	private int timer = 0; 
	private int gameScore = 0;
	private int lives = 3; 
	private PlayerShip ship;
	private NonPlayerShip nps;
	public static boolean playStatus;
	private boolean soundOn;

	
	
	Sound missileSound = new Sound("missile.wav");
	Sound reload = new Sound("reload.wav");
	Sound gameOver = new Sound("gameover.mp3");
	Sound ams = new Sound("asteroid.wav");
	
	// commands
	private MissleLauncher ms;
	
	public void init() {
		ship = new PlayerShip();
		gameCollection.add(ship);
		//store.add(ship);
		ms = new PlayerMissleLauncher(ship.getX(), ship.getY(), ship.getSpeed());
		gameCollection.add(ms);
		
		setSound(true);
		setPlay(true);
	}
	
	public String onOff;
	
	public static int getRandInt(int min, int max) {
		Random r = new Random();
		int x = r.nextInt((max-min) + 1) + min;
		return x;
	}
	
	public void setOn(String x) {
		onOff = x;
	}
	public String getOn() {
		return onOff;
	}
	public void setSound(boolean x) {
		this.soundOn = x;
		proxy();
	}
	
	public boolean getSound() {
		return soundOn;
	}
	
	public void soundCommand() {
		boolean sound = getSound();
		if(sound == false) {
			setSound(true);
		}
		else {
			setSound(false);
		}
		proxy();
	}
	
	public void proxy() {
		this.setChanged();
		GameWorldProxy proxy = new GameWorldProxy(this);
		this.notifyObservers(proxy);
	}
	
	public boolean getPlay() {
		return playStatus;
	}
	public void setPlay(boolean play) {
		playStatus = play;
		proxy();
	}
	//change from pause to play
	public void resume() {
		if(getPlay() == false) {
			setPlay(true);
			Game.playButton.setText("Pause");
			setSound(true);
			
		}else {
			setPlay(false);
			Game.playButton.setText("Play");
			setSound(false);
		}
		proxy();
	}
	public void pause() {
		setPlay(false);
		proxy();
	}
	
	public int getLives() {
		return lives;
	}
	
	public IIterator getIterator() {
        return iterator;
    }
	
	public static GameCollection find() {
		return gameCollection;
	}

	
	public void addNewAsteroid( ) {
		//create an asteroid object
		Asteroid asteroid = new Asteroid();
		//add asteroid to storage vector
		//store.add(asteroid);
		gameCollection.add(asteroid);
		System.out.println("A new ASTEROID has been created.");
		proxy();
		
	}
	
	public void addNPS() { // adding a non player ship	
		NonPlayerShip nps = new NonPlayerShip();
		NPSMissleLauncher npsms = new NPSMissleLauncher(nps.getX()+10, nps.getY()-10, nps.getSpeed());
		npsms.setDirection(nps.getDirection());
		//store.add(nps);
		gameCollection.add(nps);
		//gameCollection.add(npsms);
		System.out.println("A new NON PLAYER SHIP has been created.");
		proxy();
	}
	
	public void addSpaceStation() { // adding a space station
		SpaceStation ss = new SpaceStation();
		//store.add(ss);
		System.out.println("Adding Space Station.");
		gameCollection.add(ss);
		proxy();
	}
	
	public void Accelerate() {
		
		if(PSExists()) {
			ship.accelerate();
			ms.setSpeed(ship.getSpeed());
		
		System.out.println("PlayerShip speed has been increased.");
		this.setChanged();
        this.notifyObservers(this);
	
		}
		else
			System.out.println("Error: No ship!");
	}
	public void Decelerate() {
		if(PSExists()) {
			if(ship.getSpeed() > 0) {
				ship.decelerate();
				ms.setSpeed(ship.getSpeed());
				System.out.println("PlayerShip speed has been decreased.");
				this.setChanged();
	            this.notifyObservers(this);
			} else { 
				System.out.println("The ship isnt moving!");
			}
		
		
	}
		else
			System.out.println("Error: No ship!");
	}
	
	public void addPlayerShip() {
		if(PSExists()) {
	
			System.out.println("Error.");
		}
		else {
			ship = new PlayerShip();
			gameCollection.add(ship);
			ms = new PlayerMissleLauncher(ship.getX(), ship.getY(), ship.getSpeed());
			gameCollection.add(ms);
			System.out.println("PlayerShip Added.");
			proxy();
		}
	}
	
	public void turnLeft() {
		if(PSExists()){
			ship.turnLeft();
			ms.setDirection(ship.getDirection());
			System.out.println("PlayerShip turned left");
			this.setChanged();
            this.notifyObservers(this);
		}
		else
			System.out.println("Error: No ship!");
	}
	
	public void turnRight() {
		
		if(PSExists()) {
			ship.turnRight();
			ms.setDirection(ship.getDirection());
			System.out.println("PlayerShip turned Right");
			this.setChanged();
            this.notifyObservers(this);
	}
		else
			System.out.println("Error: No ship!");
	}
	public void TurnMissleLauncherLeft() {
		if(ms instanceof MissleLauncher) {
			ms.turnLeft();
			System.out.println("Turning the Missle Launcher");
		}
		else {
			System.out.println("No Missle Launcher!");
		}

	}


	public void fireMissle() {
		
	
		if(PSExists()) {
			int missles = ship.getMissleCount();
			if(missles > 0) {
				
				//store.add(new Missile(ship.getDirection(), ship.getX(), ship.getY()));
				gameCollection.add(new Missile(ms.getDirection(), ms.getX(), ms.getY()));
				System.out.println("Firing a missle!");
				if(getSound()) {
					missileSound.play(); }
				ship.setMissleCount(ship.getMissleCount() - 1);
				proxy();
			}
			else
				System.out.println("Error:No Missles!");
		}
		else
			System.out.println("Error: No ship!");
	}
	
	public void fireNPSMissle() {
		if(NPSExists()) {
		if(nps.getMissile() > 0) {
			//store.add(new Missile(nps.getDirection(), nps.getX(), nps.getY()));
			gameCollection.add(new NPSMissle(nps.getDirection(), nps.getX(), nps.getY()));
			nps.setMissile(nps.getMissile() - 1);
			missileSound.play();
			System.out.println("Firing NPS missle!");
	}
		}
		proxy();
	}
	public void jumpHyperspace() { //jumping through hyperspace
		if(PSExists()) {
			ship.setX(512);
			ship.setY(384);
			System.out.println("Jumping through HyperSpace");
	}
		else
			System.out.println("Error: No ship!");
	}
	public void loadMissles() {
		
		if(PSExists()) {
			ship.setMissleCount(10);
	
			if(getSound()) {
				reload.play(); }
			System.out.println("Loading missles into playership." + ship.getMissleCount());

	}
	}
	public int getMissles() {
		return ship.getMissleCount();
	}
	
	public void misslePlayership() { 
		if(PSExists()) {
			if(MissileExists()) {
				if(lives > 0) {
				removePS();
				removeMissle();
				System.out.println("NPS Missle has hit PlayerShip!");
				lives--;
				checkLives();
			} else {
				System.out.println("error");
			}
			}
		}
	}
	public void asteroidPlayership() {
		if(getAsteroidCount() > 0) {
			if(PSExists()) {
				if(lives> 0) {
			removePS();
			removeAsteroid();
			ams.play();
			System.out.println("Playership has crashed into an Asteroid!");
			lives--;
			checkLives();
			}
			else {
				System.out.println("Error: Unable to use 'Crash'");
			}	
			}
		}
		if(lives == 0) {
			System.out.println("Game Over!");
			//quit();
		}
	}
			
	
	public void missleNPS() {
		
			if(NPSExists() && MissileExists()) {
				removeMissle();
				removeNPS();
				gameScore++;
				System.out.println("Missle has struck an NPS!");
				System.out.println("Score= " + gameScore);
				ams.play();
			} else {
				System.out.println("Error!");
			}
			
		}
	
	
	public void npsPlayership() {
		
		if(PSExists()) {
			if(NPSExists()) {
				removePS();
				removeNPS();
				System.out.println("NPS and Player ship have collided!");
		
				if(lives > 0) 
					lives--;
				else //Game over, lives=0
					System.out.println("Game is Over!");
					//quit();
			
				setChanged();
				notifyObservers();
			}
		}
	}
	
	
	
	
	public int getAsteroidCount() {
		int count = 0;
		iterator = gameCollection.getIterator();
		while(iterator.hasNext()) {
			if(iterator.getNext() instanceof Asteroid) {
			count++;
		}
		
	}
		return count;	
	}
	public void asteroidCollision() {
		if(getAsteroidCount() >= 2) {
			removeAsteroid();
			removeAsteroid();
			System.out.println("Asteroids have collided!");
		}
		else {
			System.out.println("Not Enough Asteroids");
		}		
	}
	
	
	public void npsAsteroid() {
		if(NPSExists() && getAsteroidCount() > 0) {
			removeNPS();
			removeAsteroid();
			System.out.println("Asteroid has collided with an NPS.");
	}
		else {
			System.out.println("Error");
		}
	}
	
	public void missleAsteroid() {
		if(PSExists()) {
			if(MissileExists() && getAsteroidCount() > 0) {
				removeAsteroid();
				removeMissle();
				System.out.println("Player missle has struck an asteroid.");
				ams.play();
				gameScore++;
				proxy();
	}
			else {
				System.out.println("Error.");
			}
	}
	}	
	
	public void UpdateFuel() {
		boolean exists = false;

        iterator = gameCollection.getIterator();

        while (iterator.hasNext()){
            GameObject object = (GameObject) iterator.getNext();

            if(object instanceof Missile){
                exists = true;
                Missile psMissile = (Missile) object;
                int level = psMissile.getFuel();

                if(level >= 1) {
                    psMissile.setFuel(level - 1);  //decrease PSMissile count by 1
                } else {
                    //gameCollection.remove(object);    //remove the PSMissile

                System.out.println("Player Ship Missile removed.");
                iterator.remove();
                }
            }
        }
		
        if(exists) {
            this.setChanged();
            this.notifyObservers(this);
            System.out.println("Missile fuel levels updated");
        }
    }
	private void MoveObjects(){
        boolean exists = false;
        iterator = gameCollection.getIterator();

        while (iterator.hasNext()){
            GameObject object = (GameObject) iterator.getNext();

            if (object instanceof iMoveable) {
                ((iMoveable) object).moving();
                exists = true;
                this.setChanged();
                this.notifyObservers(this);
            }
        }
    }
	
	public int getTimer() {
		return timer;
	}
	public void clockTick() { //ticker
		timer++;
		UpdateFuel();
		MoveObjects();
		collisionDetection();
		//System.out.println("GameClock Ticked.");
		this.setChanged();
        this.notifyObservers(this);
		
		
	}
	
	public void collisionDetection() {
		
		IIterator iter = gameCollection.getIterator();
		
		
		while(iter.hasNext() ) {
			ICollider curObj = (ICollider)iter.getNext();
			IIterator iter2 = gameCollection.getIterator();
			
			while(iter2.hasNext()) {
				ICollider otherObj = (ICollider) iter2.getNext();
				if(otherObj != curObj) {
					if(curObj.collidesWith(otherObj)) {
						otherObj.handleCollision(curObj);
						curObj.handleCollision(otherObj);
					}
							
				}
					
			}
		}
		removeCollisions();
		proxy();


	}

	public void removeCollisions() {
		GameCollection removals = new GameCollection();
		GameCollection points = new GameCollection();
		IIterator objects = gameCollection.getIterator();
		GameObject curObj;
		
		while(objects.hasNext()) {
			curObj = (GameObject) objects.getNext();
			if(((GameObject)curObj).getFlag()){
				removals.add(curObj);
			}
			if(((GameObject)curObj).getPointFlag()){
				points.add(curObj);

			}
			
		}
		removeAll(removals);
		checkPoints(points);
	}
	
	public void checkPoints(GameCollection points) {
		IIterator iter = points.getIterator();
		while(iter.hasNext()) {
			GameObject curObj = iter.getNext();
			gameScore++;
			points.remove(curObj);
		}
	}
	public void removeAll(GameCollection removals) {
		IIterator iter = removals.getIterator();
		
		while(iter.hasNext()) {
			GameObject curObj = iter.getNext();
			if(curObj instanceof Asteroid) {
				gameCollection.remove(curObj);
				if(getSound()) {
					ams.play(); }
				}
			if(curObj instanceof PlayerShip) {
				gameCollection.remove(curObj);
				gameCollection.remove(ms);
				lives--;
				if(getSound()) {
					ams.play(); }
				}
			if(curObj instanceof Missile) {
				gameCollection.remove(curObj);
				if(getSound()) {
					ams.play(); }

				}
			if(curObj instanceof NonPlayerShip) {
				gameCollection.remove(curObj);
				if(getSound()) {
					ams.play(); }
				}
			if(curObj instanceof SpaceStation) {
				gameCollection.remove(curObj);
				if(getSound()) {
					ams.play(); }
				}
			
		}
		proxy();
		
	}

	public void gameStats() { // current game statistics
		System.out.println("Stats = " + gameScore + " Missles = " + ship.getMissleCount() + " Time: " + timer);
		
	}
	
	public void map() { //prints game map
		System.out.print("\n\n");
		IIterator it = this.gameCollection.getIterator();
		while(it.hasNext()) {
			GameObject o = it.getNext();
			//System.out.println(o.toString());
		}
		
		
	}
	
	public void quit() {
		Display.getInstance().exitApplication();
	}

	@Override
	public int getPlayerScore() {
		return gameScore;
	}
	
	
	
	public void removeAsteroid() {
		IIterator it = this.gameCollection.getIterator();
		while(it.hasNext()) {
			GameObject o = it.getNext();
			if(o instanceof Asteroid) {
				it.remove();
				break;
			}
		
	}
		proxy();
	}
	
	public void removeNPS() {
		IIterator it = this.gameCollection.getIterator();
		while(it.hasNext()) {
			GameObject o = it.getNext();
			if(o instanceof NonPlayerShip) {
				it.remove();
				break;
			}
		
	}
		proxy();
	}
	public void removePS() {
		IIterator it = this.gameCollection.getIterator();
		while(it.hasNext()) {
			GameObject o = it.getNext();
			if(o instanceof PlayerShip) {
				it.remove();
				break;
			}
		
	}
		proxy();
	}
	public void removeMissle() {
		IIterator it = this.gameCollection.getIterator();
		while(it.hasNext()) {
			GameObject o = it.getNext();
			if(o instanceof Missile) {
				it.remove();
				break;
			}
		
	}
		proxy();
	}
	public void refuel() {
		IIterator iter = this.gameCollection.getIterator();
		while(iter.hasNext()) {
			GameObject o = iter.getNext();
			if(o instanceof Missile) {
				((Missile) o).setFuel(10);
				System.out.println("Fuel Levels Maxed out.");
			}
		}
		proxy();
	}
	private boolean NPSExists(){
        boolean exists = false;
        iterator = gameCollection.getIterator();
        while (iterator.hasNext()){
            if(iterator.getNext() instanceof NonPlayerShip){
                exists = true;
            }
        }
    
        return  exists;
        
    }

    private boolean PSExists(){
        boolean exists = false;
        iterator = gameCollection.getIterator();
        while (iterator.hasNext()){
            if(iterator.getNext() instanceof PlayerShip){
                exists = true;
            }
        }

        return exists;
    }
    
    private boolean MissileExists(){
        boolean exists = false;
        iterator = gameCollection.getIterator();
        while (iterator.hasNext()){
            if(iterator.getNext() instanceof Missile){
                exists = true;
            }
        }

        return exists;
    }
    
    public void checkLives() {
    	if(lives == 0) {
    		gameOver.play();
    		//quit();
    		
    }
	

}

	public void TurnMissleLauncherRight() {
		ms.turnRight();
		
	}

}