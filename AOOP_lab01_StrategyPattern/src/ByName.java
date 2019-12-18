
public class ByName implements Comparable {

	@Override
	public int compare(Object o1, Object o2) {

		FileInfo file1 = (FileInfo) o1;
		FileInfo file2 = (FileInfo) o2;

		return file1.getName().compareTo(file2.getName());

	}

}
