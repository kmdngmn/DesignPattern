package Adapter_Facade_Pattern_2;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {

	Enumeration enumeration;

	public EnumerationIterator(Enumeration enumeration) {
		
		this.enumeration = enumeration;
		
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

}
