package Adapter_Facade_Pattern_3;

import java.util.Enumeration;
import java.util.Iterator;

public class Adapter implements Enumeration {

	Iterator iterator;
	public Adapter(Iterator iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public Object nextElement() {
		// TODO Auto-generated method stub
		return iterator.next();
	}

}
