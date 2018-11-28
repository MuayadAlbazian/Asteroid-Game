package com.mycompany.a3;

import java.util.Observable;

import com.mycompany.Interfaces.IGameWorld;
import com.mycompany.Interfaces.IIterator;

public class GameWorldProxy extends Observable implements IGameWorld{
	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw){
		this.gw = gw;
		
	}
	public int getLives() {
		return gw.getLives();
	}
	public int getTimer() {
		return getTimer();
	}
	public void addSpaceStation() {
		
	}
	public int getMissles() {
		return gw.getMissles();
	}
	public void asteroidPlayership() {
		
	}
	public void npsPlayership() {
		
	}
	public void asteroidCollision() {
		
	}
	public void clockTick() {
		
	}
	public void jumpHyperspace() {
	}
	public void loadMissles() {
		
	}
	public void missleNPS() {
		
	}
	
	public void missleAsteroid() {
		
	}
	
	public void addNPS() {
	}
	
	public void Accelerate() {	
	}
	
	public void Decelerate() {
	}
	public void turnLeft() {	
	}
	
	public void turnRight() {
	}
	
	public void addNewAsteroid() {	
	}
	
	public void addPlayerShip() {	
	}
	public void fireMissle() { 
	}

	public void map() {
		
	}

	@Override
	public int getPlayerScore() {
		return gw.getPlayerScore();
	}
	public IIterator getIterator() {
		return gw.getIterator();
	}
	@Override
	public void TurnMissleLauncherLeft() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void misslePlayership() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSound(boolean x) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void soundCommand() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getOn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean getPlay() {
		// TODO Auto-generated method stub
		return false;
	}

}
