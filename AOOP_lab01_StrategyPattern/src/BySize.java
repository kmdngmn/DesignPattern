
public class BySize implements Comparable {

	@Override
	public int compare(Object o1, Object o2) {
		
		FileInfo file1 = (FileInfo) o1;
		FileInfo file2 = (FileInfo) o2;

		return file1.getSize() - file2.getSize();

	}

}
