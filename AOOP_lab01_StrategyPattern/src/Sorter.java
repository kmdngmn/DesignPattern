
public class Sorter {

	Comparable comparable = new ByName();

	public void setCompare(Comparable comparable) {

		this.comparable = comparable;

	}

	public void bubbleSort(Object[] objs) {

		for (int i = 0; i < objs.length - 1; i++) {
			for (int j = 0; j < objs.length - 1; j++) {

				if (comparable.compare(objs[j], objs[j + 1]) > 0) { // swap
					Object temp = objs[j];
					objs[j] = objs[j + 1];
					objs[j + 1] = temp;
				}

			}
		}

	}

}
