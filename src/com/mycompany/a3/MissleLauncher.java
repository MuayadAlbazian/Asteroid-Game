package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
import com.mycompany.Interfaces.iSteerable;

public class MissleLauncher extends MoveableGameObject implements iSteerable{
	
	private PlayerShip ps;
	private Point2D spawn;
	private int LENGTH = 90;
	
	
	public MissleLauncher(double x, double y, int speed) {

		this.setColor(ColorUtil.CYAN);
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setDirection(0);
		this.spawn =new Point2D(this.getX() + (LENGTH* Math.cos(Math.toRadians(this.getDirection() + 90.0))),
				this.getY() + LENGTH* Math.sin(Math.toRadians(this.getDirection() + 90.0)));
		}
	
	public void setLocation(Point2D location)
	{
		// update where missiles spawn
		spawn.setX((this.getX() + (LENGTH* Math.cos(Math.toRadians(this.getDirection() + 90.0)))));
		spawn.setY(this.getY() + LENGTH* Math.sin(Math.toRadians(this.getDirection() + 90.0)));
	}
	
	public Point2D getSpawn() {
		return spawn;
	}

	@Override
	public void turnLeft() {
		setDirection(getDirection() + 10);
	}

	@Override
	public void turnRight() {
		setDirection(getDirection() - 10);
		
	}

	@Override
	public void accelerate() {
		int x = ps.getSpeed();
		setSpeed(x);
	}

	@Override
	public void decelerate() {
		int x = ps.getSpeed();
		setSpeed(x);
		
	}
	
	@Override
    public String toString() {
        String parentDesc = super.toString();
        String myDesc = " ";
        return "Missle Launcher: " + parentDesc + myDesc;
    }

}
