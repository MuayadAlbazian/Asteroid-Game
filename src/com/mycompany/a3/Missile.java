package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.ISelectable;

public class Missile extends MoveableGameObject implements IDrawable, ISelectable, ICollider{
	private int fuelLevel = 10;
	private int width = 10;
	private int height = 20;
	
	public void setFuel(int x) {
		this.fuelLevel = x;
	}
	public int getFuel() {
		return fuelLevel;
	}
	
	public Missile(int d, double x, double y) { //Missile Constructer
		this.setColor(ColorUtil.BLACK);
		//location
		this.setX(x);
		this.setY(y);
		//direction and speed
		this.setDirection(d);
		this.setSpeed(20);				
	}

	public String toString() {
		String parentDesc = super.toString();
		String myDesc =  " fuel=" + fuelLevel;
		return "Missile: " + parentDesc + myDesc;
	}
	
	private boolean isSelect;
	@Override
	public void setSelected(boolean yesNo) {
		isSelect= yesNo;
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return isSelect;
	}
	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int iShapeX = (int)this.getX();
		int iShapeY = (int)this.getY();
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		int xLoc = pCmpRelPrnt.getX() + iShapeX;
		int yLoc = pCmpRelPrnt.getY() + iShapeY;
		
		if((px  >= xLoc) && (px <= xLoc + width) && (py >= yLoc) && (py <= yLoc + height)) {
			return true;
		} else {
			return false; 
		}
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		moving();
		g.setColor(this.getColor());
		int mapX = (int)pCmpRelPrnt.getX();
		int mapY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getX() + mapX);
		int currentY = ((int)this.getY() + mapY);
		g.fillRect(currentX, currentY, width, height);
		
		// TODO Auto-generated method stub
		
	}
	@Override
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
			System.out.println("NPS COLLISION");
			}
		if(otherObject instanceof SpaceStation) {
			this.setFlag(true);
		}
		// TODO Auto-generated method stub
		
	}


}
