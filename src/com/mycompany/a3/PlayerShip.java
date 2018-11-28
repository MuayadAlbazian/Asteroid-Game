package com.mycompany.a3;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.ISelectable;
import com.mycompany.Interfaces.iSteerable;

public class PlayerShip extends MoveableGameObject implements iSteerable, IDrawable, ISelectable, ICollider{
	private int MissleCount = 10;
	private int maxSpeed = 10;
	private PlayerMissleLauncher ms;
	private int width = 10;
	private int height = 50;
	
 
	
	public void setMissleCount(int x) {
		this.MissleCount = x;
	}
	public int getMissleCount() {
		return MissleCount;
	}
	
	public void accelerate() {
		if(maxSpeed > getSpeed() + 2) {
			setSpeed(getSpeed() + 2);
		}
	}
	
	public void decelerate() {
		if(-1 < getSpeed() - 2) {
			setSpeed(getSpeed() - 2);
		}
	}
	
	public void turnLeft() {
		int currentDirection = this.getDirection();
		if(currentDirection-20>=0) {
			this.setDirection(currentDirection - 20);
		}else {
			this.setDirection(Math.abs(360+(currentDirection-20)));
		}
	}
	public void turnRight() {
		int currentDirection = this.getDirection();
		if(currentDirection-20>=0) {
			this.setDirection(currentDirection + 20);
		}else {
			this.setDirection(Math.abs(360-(currentDirection+20)));
		}
	}
	
	
	public GameWorld gw;
	public PlayerShip() {
		this.setColor(ColorUtil.BLUE);
		//location
		this.setX(512);
		this.setY(384);
		//direction and speed
		this.setDirection(0);
		this.setSpeed(0);
		ms = new PlayerMissleLauncher(this.getX(), this.getY(),this.getSpeed());
		
		
	}
	
	public PlayerMissleLauncher getMS() {
		return ms;
	}
	
	public String toString() {
		
		String parentDesc = super.toString();
		String myDesc = " Missiles= " + MissleCount + " Missle Launcher diretion= " + Integer.toString(ms.getDirection());
		return "Ship: " + parentDesc + myDesc;
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
		
		if((px  >= xLoc) && (px <= xLoc + width) && (py >= yLoc) && (py <= yLoc + height)) {
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
		g.fillRect(currentX, currentY, width, height);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCollision(ICollider otherObject) {
		if(otherObject instanceof Missile) {
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
