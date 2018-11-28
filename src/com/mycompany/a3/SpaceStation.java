package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.ISelectable;

public class SpaceStation extends FixedGameObject implements IDrawable, ICollider{
	
	private Random rand = new Random();
	private int blinkRate = rand.nextInt(4);
	private boolean blink;
	
	

	
	public void setBlinkRate(int x) {
		this.blinkRate = x;
	}
	public int getBlinkRate() {
		return blinkRate;
	}
	public boolean getBlink() {
		return blink;
	}
	public void setBlink(boolean x) {
		blink = x;
		
	}
	public SpaceStation() {
		this.setColor(ColorUtil.CYAN); //setting color
		this.setX(rand.nextInt(1024));
		this.setY(rand.nextInt(768));
		blink = true;
		blinkRate = blinkRate;
		
		
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Blink-Rate=" + blinkRate;
		return "Space-Station: " + parentDesc + myDesc;
		
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		int mapX = (int)pCmpRelPrnt.getX();
		int mapY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getX() + mapX);
		int currentY = ((int)this.getY() + mapY);
		int width = 50; 
		int height = 50;
		g.drawRect(currentX, currentY, width, height);
		
		// TODO Auto-generated method stub
		
	}
	
	public void handleCollision(ICollider otherObject) {
		if(otherObject instanceof Missile) {
			this.setFlag(true);
		}
		if(otherObject instanceof PlayerShip) {
			this.setFlag(true);
		}
		if(otherObject instanceof Asteroid) {
			this.setFlag(true);
		}
		if(otherObject instanceof NonPlayerShip) {
			this.setFlag(true);
		}
		if(otherObject instanceof SpaceStation) {
			this.setFlag(true);
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}	
	
	

}
