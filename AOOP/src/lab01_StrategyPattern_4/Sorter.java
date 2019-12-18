package lab01_StrategyPattern_4;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sorter {

	Comparable comparable;

	public void setComparable(Comparable comparable) {
		this.comparable = comparable;
	}

	public void bubbleSortInts(Object[] obj) {
		for (int i = 0; i < obj.length - 1; i++) {
			for (int j = 0; j < obj.length - 1; j++) {
				if (comparable.compare(obj[j], obj[j + 1]) > 0) { // swap
					Object temp = obj[j];
					obj[j] = obj[j + 1];
					obj[j + 1] = temp;
				}
			}
		}
	}

}
