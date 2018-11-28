package com.mycompany.a3;

public class FixedGameObject extends GameObject {
	private static int Uniqueid= 1;
	private int id;
	
	public void setID(int x) {
		this.id = x;
	}
	public int getID() {
		return id;
	}

	public static void setUID(int x) {
		FixedGameObject.Uniqueid = x;
	}
	
	public static int getUID() {
		return Uniqueid;
	}
	
	public FixedGameObject() {
		this.id = Uniqueid;
		Uniqueid++;
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " ID=" + id;
		return parentDesc + myDesc;
	}
	@Override
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
