package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.ISelectable;

public class NonPlayerShip extends MoveableGameObject implements ISelectable, IDrawable, ICollider{
	private int [] arr = {10, 20};
	
	private Random rand = new Random();
	private int size = 20;
	private int missleCount = 2;
	
	public int getMissile() {
		return missleCount;
	}
	public void setMissile(int x) {
		this.missleCount = x;
		
	}

	
	public void setSize(int x) {
		this.size = x;
	}
	public int getSize() {
		return size;
	}
	
	public NonPlayerShip() { //NonPlayerShip Constructer
		this.setColor(ColorUtil.rgb(255, 0, 0));
		this.setX(rand.nextInt(1024));
		this.setY(rand.nextInt(768));
		this.setDirection(rand.nextInt(359));
		this.setSpeed(rand.nextInt(10));
		
	}
	
	public String toString(){
		String parentDesc = super.toString();
		String stats = parentDesc + ", size=" + size + "MissleCount= " + getMissile();
		return "NonPlayer Ship: " + stats;
	}
	public boolean isSelect;
	@Override
	public void setSelected(boolean yesNo) {
		isSelect = yesNo;
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
		
		if((px  >= xLoc) && (px <= xLoc + getSize()) && (py >= yLoc) && (py <= yLoc + getSize())) {
			return true;
		} else {
			return false; 
		}
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		int mapX = (int)pCmpRelPrnt.getX();
		int mapY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getX() + mapX);
		int currentY = ((int)this.getY() + mapY);
		g.fillRect(currentX, currentY, getSize(), getSize());
		
		// TODO Auto-generated method stub
		
	}
	public GameWorld gw;
	public void handleCollision(ICollider otherObject) {
		
		if(otherObject instanceof Missile) {
			setFlag(true);
			this.setPointFlag(true);
			System.out.println("MISSILE COLLISION");
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
	
		
	}	
	

}
