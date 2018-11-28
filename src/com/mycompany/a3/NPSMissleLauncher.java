package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.Interfaces.IDrawable;

public class NPSMissleLauncher extends MissleLauncher implements IDrawable{
	
	private Point2D spawn;
	private int LENGTH = 40;
	
	public NPSMissleLauncher(double x, double y, int speed) {
		super((double)x, (double)y, (int)speed);
		this.setColor(ColorUtil.rgb(120, 60, 20));
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setDirection(0);
		this.spawn =new Point2D(this.getX() + (LENGTH* Math.cos(Math.toRadians(this.getDirection() + 90.0))),
				this.getY() + LENGTH* Math.sin(Math.toRadians(this.getDirection() + 90.0)));
		}

	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " ";
		return "NPS Missle Launcher: " + parentDesc + myDesc;
		
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
