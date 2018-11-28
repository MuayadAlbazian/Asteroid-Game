package com.mycompany.Interfaces;

import com.mycompany.a3.GameObject;

public interface IIterator {
	
	public GameObject getNext();
	public boolean hasNext();
	public void remove();
}
