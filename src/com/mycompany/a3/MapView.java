package com.mycompany.a3;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;
import com.mycompany.Interfaces.IDrawable;
import com.mycompany.Interfaces.IGameWorld;
import com.mycompany.Interfaces.IIterator;

public class MapView extends Container implements Observer {

		GameWorld gw;
	
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.CYAN));
		this.getAllStyles().setBackgroundGradientEndColor(ColorUtil.BLACK);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		IGameWorld gw = (IGameWorld) arg;
		gw.map();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator iterator = GameWorld.find().getIterator();
		
		while(iterator.hasNext()) {
			GameObject obj = (GameObject) iterator.getNext();
			((IDrawable) obj).draw(g, pCmpRelPrnt);
		}
	}
	
	/*public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		if(gw.getPlay() == false) {
			IIterator iter = gw.getIterator();
			while(iter.hasNext()) {
				GameObject curObj = (GameObject) iter.getNext();
				if (curObj instanceof Asteroid){
				 	if (((Asteroid) curObj).contains(pPtrRelPrnt, pCmpRelPrnt)){
				 		    ((Asteroid) curObj).setSelected(true);		 		  
				 	}else{
				 			((Asteroid) curObj).setSelected(false);	
				 			
				 	}
			 }
			}
			
		}
	}*/
		
}
	
