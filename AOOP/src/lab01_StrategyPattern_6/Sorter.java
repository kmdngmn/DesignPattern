package lab01_StrategyPattern_6;

public class Sorter {

	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void bubbleSort(Object[] objs) {
		for (int i = 0; i < objs.length - 1; i++) {
			for (int j = 0; j < objs.length - 1; j++) {
				if (strategy.compare(objs[j], objs[j + 1]) > 0) { // swap
					Object temp = objs[j];
					objs[j] = objs[j + 1];
					objs[j + 1] = temp;
				}
			}
		}
	}

}
