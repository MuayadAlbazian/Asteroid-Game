package com.mycompany.Interfaces;

public interface IGameWorld {

		int getPlayerScore();
		int getTimer();
		void TurnMissleLauncherLeft();
		void addNewAsteroid();
		void addPlayerShip();
		void addNPS();
		void Accelerate();
		void Decelerate();
		void turnLeft();
		void turnRight();
		void fireMissle();
		void jumpHyperspace();
		void loadMissles();
		void missleAsteroid();
		void missleNPS();
		void asteroidPlayership();
		void npsPlayership();
		void asteroidCollision();
		void clockTick();
		int getMissles();
		void addSpaceStation();
		int getLives();
		void map();
		void misslePlayership();
		void setSound(boolean x);
		boolean getSound();
		void soundCommand();
		String getOn();
		boolean getPlay();

	
}
