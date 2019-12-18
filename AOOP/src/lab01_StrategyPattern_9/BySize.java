package lab01_StrategyPattern_9;

public class BySize implements Strategy{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
	
		return f1.getSize() - f2.getSize();
	}

}
