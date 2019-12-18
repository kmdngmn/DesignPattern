package lab01_StrategyPattern_9;

public class ByType implements Strategy{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
	
		return f1.getType().compareTo(f2.getType());
	}

}
