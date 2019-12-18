package lab01_StrategyPattern_7;

public class ByName implements Strategy{

	@Override
	public int compare(Object o1, Object o2) {
		
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
		
		return f1.getName().compareTo(f2.getName());
		
	}

	
	
}
