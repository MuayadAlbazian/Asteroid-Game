package com.mycompany.a3;

import java.util.ArrayList;

import com.mycompany.Interfaces.ICollection;
import com.mycompany.Interfaces.IIterator;

public class GameCollection implements ICollection{
	
	private IIterator iterator;
	private ArrayList<GameObject> objectList;
	
	private class Iterator implements IIterator {
		private int index;
		private Iterator() {
			index = -1;
		}
		
		public GameObject getNext() {
			index++;
			return objectList.get(index);
		}

		@Override
		public boolean hasNext() {
			if(objectList.size() == 0) {
				return false;
			}
			if(index == objectList.size() - 1) {
				return false;
			}
			return true;
		}
		public void remove() {
			// TODO Auto-generated method stub
			objectList.remove(index);
			this.index--;
		}
		


		
	}
	public void remove(GameObject o) {
		// TODO Auto-generated method stub
		objectList.remove(o);
	}
	
	public GameCollection () {
		iterator = new Iterator();
		objectList = new ArrayList<>();
	}
	
	public void add(GameObject o) {
		this.objectList.add(o);
	}
	public IIterator getIterator() {
		return new Iterator();
	}



	

}
