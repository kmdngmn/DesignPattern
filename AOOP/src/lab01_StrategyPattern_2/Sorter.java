package lab01_StrategyPattern_2;

public class Sorter {

	Comparable comparable;

	public void bubbleSort(Object[] objs) {
		for (int i = 0; i < objs.length - 1; i++) {
			for (int j = 0; j < objs.length - 1; j++) {
				if (comparable.compare(objs[j], objs[j + 1]) > 0) { // swap objs[j] > objs[j + 1]
					Object temp = objs[j];
					objs[j] = objs[j + 1];
					objs[j + 1] = temp;
				}
			}
		}
	}

	public void setComparable(Comparable comparable) {
		this.comparable = comparable;
	}
}
