package com.mycompany.a3;
import java.util.Random;

import com.mycompany.Interfaces.iMoveable;

public class MoveableGameObject extends GameObject implements iMoveable{
	
	private Random random = new Random();
	private int speed = random.nextInt(10);
	private int direction = random.nextInt(359);
	
	
	public void setSpeed(int s) {
		this.speed = s;
	}
	public int getSpeed() {
		return speed;
	}
	
	public void setDirection(int x) {
		this.direction = x;
	}
	public int getDirection() {
		return direction;
	}
	
	public void moving() { 
		double theta = 90 - getDirection();
		double deltaX = Math.cos(Math.toRadians(theta))*getSpeed();
		double deltaY = Math.sin(Math.toDegrees(theta))*getSpeed();
		double x = getX() + deltaX;
		double y = getY() + deltaY;
		
		setX(x);
		setY(y);
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Direction= " +  Math.round(direction*10.0)/10.0 + " Speed= " + speed;
		return parentDesc + myDesc;
	}
	@Override
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}

}
