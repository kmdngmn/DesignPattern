
public class ByType implements Comparable{

	@Override
	public int compare(Object o1, Object o2) {
		
		FileInfo file1 = (FileInfo) o1;
		FileInfo file2 = (FileInfo) o2;

		return file1.getType().compareTo(file2.getType());

	}

	
}
