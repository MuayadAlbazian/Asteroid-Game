package com.mycompany.a3;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.ISelectable;


public class Asteroid extends MoveableGameObject implements IDrawable, ISelectable, ICollider{
	private Random rand = new Random();
	private int size = rand.nextInt(31) + 6;
	public GameWorld gw;

	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Asteroid() { // setting up the asteroid constructer
		//color
		this.setColor(ColorUtil.rgb(255, 102, 0));
		//location
		this.setX(rand.nextInt(1024));
		this.setY(rand.nextInt(768));
		//speed
		this.setSpeed(rand.nextInt(10));
		//direction
		this.setDirection(rand.nextInt(359));
		
	}
	
	
	
	public String toString() {
		String parentDesc = super.toString();
		String stats = parentDesc + ", size=" + size;
		return "Asteroid: " + stats;
	}
	
	private boolean isSelect;
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
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int x = (int)(pCmpRelPrnt.getX() + this.getX());
		int y = (int)(pCmpRelPrnt.getY() + this.getY());
		int startAngle = 360;
		int arcAngle = 360;
		g.setColor(getColor());
		
		if(isSelected()) {
			g.drawArc(x, y, getSize(), getSize(), startAngle, arcAngle);
		}
		else {
			g.fillArc(x, y, getSize(), getSize(), startAngle, arcAngle);
		}
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
