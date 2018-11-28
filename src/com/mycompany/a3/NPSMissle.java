package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;

public class NPSMissle extends Missile{

	public NPSMissle(int d, double x, double y) {
		super(d, x, y);
		this.setColor(ColorUtil.rgb(220, 20, 60));
		this.setX(x);
		this.setY(y);
		this.setDirection(d);
		this.setSpeed(15);
		// TODO Auto-generated constructor stub
	} 
	

}
