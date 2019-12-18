package Adapter_Facade_Pattern;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Adapter implements Iterator {

	Enumeration e;

	public Adapter(Enumeration e) {

		this.e = e;

	}

	@Override
	public boolean hasNext() {
		return e.hasMoreElements();
	}

	@Override
	public Object next() {
		return e.nextElement();
	}
	
	public void remove() {
//		throw new UnsupportedAddressTypeException();
	}

}

public class Drive {

	public static void printIterator(Iterator i) {
		while(i.hasNext()) {
			System.out.println(" " + i.next());
		}
	}
	
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		for(int i = 0; i < 10; i ++) {
			v.add(i);
		}
		
		Enumeration e = v.elements();
		Adapter a = new Adapter(e);
		
		Drive.printIterator(a);
		
	}
	
}
