//Adapter
public class MovieMediaAdapter implements MovieMediaManager {

	private MovieMediaList movieMediaList;
	private String fileName;
	private boolean loaded;

	public MovieMediaAdapter(String fileName) {
		this.fileName = fileName;
		movieMediaList = new MovieMediaList();
		loaded = false;
	}

	@Override
	public void load() {
		movieMediaList.load(fileName);
		loaded = true;
	}

	@Override
	public boolean isLoaded() {
		return loaded;
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
