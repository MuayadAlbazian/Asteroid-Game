package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.iSteerable;

public class PlayerMissleLauncher extends MissleLauncher implements iSteerable, IDrawable{
	
	private Point2D spawn;
	private int LENGTH = 20;
	public PlayerMissleLauncher(double x, double y, int speed) {
		super((double)x, (double)y, (int)speed);
		this.setColor(ColorUtil.CYAN);
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setDirection(0);
		this.spawn =new Point2D(this.getX() + (LENGTH* Math.cos(Math.toRadians(this.getDirection() + 90.0))),
				this.getY() + LENGTH* Math.sin(Math.toRadians(this.getDirection() + 90.0)));
		}

	
	@Override
	public void turnLeft() {
		setDirection(getDirection() + 10);
	}

	@Override
	public void turnRight() {
		setDirection(getDirection() - 10);
		
	}
	public String toString() {
        String parentDesc = super.toString();
        String myDesc = " ";
        return "Player Missle Launcher: " + parentDesc + myDesc;
    }

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int width = 5;
		int height = 20;
		g.setColor(this.getColor());
		int mapX = (int)pCmpRelPrnt.getX();
		int mapY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getX() + mapX);
		int currentY = ((int)this.getY() + mapY);
		g.fillRect(currentX, currentY, width, height);
		
		// TODO Auto-generated method stub
		
	}

}
