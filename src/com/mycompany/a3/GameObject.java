package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;


public abstract class GameObject implements ICollider{
	private int color, size;
	private double xLocation;
	private double yLocation;
	private boolean flag;
	private boolean pointFlag;
	
	
	public void setPointFlag(boolean x) {
		this.pointFlag = x;
	}
	public boolean getPointFlag() {
		return pointFlag;
	}
	
	public void setFlag(boolean x) {
		this.flag = x;
		
	}
	public boolean getFlag() {
	return flag;
}
	
	public void setColor(int x) {
		this.color = x;
	}
	public int getColor() {
		return color;
	}
	
	public void setX(double x) {
		this.xLocation = x;
		
	}
	public double getX() {
		return xLocation;
	}
	
	public void setSize(int x) {
		this.size = x;
	}
	public int getSize() {
		return size;
	}
	
	public void setY(double y) {
		this.yLocation = y;
	}
	public double getY() {
		return yLocation;
	}
	
	public String toString() {
		String myDesc = "loc= " + Math.round(xLocation*10.0)/10.0 + "," + Math.round(yLocation*10.0)/10.0 +
				" color= [" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		return myDesc;
	}
	
	public boolean collidesWith(ICollider otherObject) {
		GameObject obj = (GameObject) otherObject;
		boolean result = false;
		int thisCenterX = (int) (this.getX() + (getSize()/2));
		int thisCenterY = (int) (this.getY() + (getSize()/2));
		int otherCenterX = (int) (obj.getX() + (getSize()/2));
		int otherCenterY = (int) (obj.getY() + (getSize()/2));
		
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = (dx*dx + dy*dy);
		
		int thisRadius = getSize()/2;
		int otherRadius = getSize()/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		if(distBetweenCentersSqr <= radiiSqr ) { result = true; }
		return result;
	}

}
