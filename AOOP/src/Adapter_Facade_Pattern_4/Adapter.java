package Adapter_Facade_Pattern_4;

import java.util.Enumeration;
import java.util.Iterator;

public class Adapter implements Iterator{

	private Enumeration enumeration;
	
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}
	
	public static void main(String[] args) {
		Adapter a = new Adapter();
		
		System.out.println(a.hasNext());
	}

}
