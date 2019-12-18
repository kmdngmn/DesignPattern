package lab01_StrategyPattern;

public class ByModifiedDate implements Comparable {

	@Override
	public int compare(Object o1, Object o2) {

		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;

		return f1.getModifiedDate().compareTo(f2.getModifiedDate());
	}

}
