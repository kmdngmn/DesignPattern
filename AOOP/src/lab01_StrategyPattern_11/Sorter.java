package lab01_StrategyPattern_11;

public class Sorter {

	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	void bubbleSort(Object[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				if (strategy.compare(data[j], data[j + 1]) > 0) { // swap
					Object temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
	}

}
