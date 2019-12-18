package lab06_AdapterPattern_5;

public class Adapter implements MovieMediaManager {

	private MovieMediaList movieMediaList;
	private String filename;

	public Adapter(String filename) {
		this.filename = filename;

		movieMediaList = new MovieMediaList();
	}

	@Override
	public void load() {
		movieMediaList.load(filename);
	}

	@Override
	public boolean isLoaded() {
		return movieMediaList.isLoaded();
	}

	@Override
	public void print(int index) {

		movieMediaList.print(index);

	}

	@Override
	public void printAll() {
		movieMediaList.printAll();
	}

	@Override
	public int find(String str) {
		return movieMediaList.find(str);
	}

}
