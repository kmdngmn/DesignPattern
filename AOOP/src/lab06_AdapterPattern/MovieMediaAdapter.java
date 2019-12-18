package lab06_AdapterPattern;

public class MovieMediaAdapter implements MovieMediaManager {

	private MovieMediaList movieMediaList;
	
	private String fileName;
	
	public MovieMediaAdapter(String fileName) {
		this.fileName = fileName;
		movieMediaList = new MovieMediaList();
	
	}
	
	@Override
	public void load() {

		movieMediaList.load(fileName);
		
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
