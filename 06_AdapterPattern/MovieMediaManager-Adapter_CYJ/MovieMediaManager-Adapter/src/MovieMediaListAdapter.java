public class MovieMediaListAdapter implements MovieMediaManager {
    ExtendedMovieMediaList movieMediaList;
    String fileName;
    boolean loaded = false;

    MovieMediaListAdapter(String fileName) {
        this.fileName = fileName;
        movieMediaList = new ExtendedMovieMediaList();
        load();
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
        if (index < 0 || index >= movieMediaList.size()) {
            System.out.println("잘못된 데이터를 출력하려고 합니다");
        }
        else {
            MovieMedia m = movieMediaList.get(index);
            System.out.println(m);
        }
    }

    @Override
    public void printAll() {
        movieMediaList.printAll();
    }

    @Override
    public int find(String str) {
        for (int i = 0; i < movieMediaList.size(); i++) {
            MovieMedia m = movieMediaList.get(i);
            if (m.find(str)) {
                return i;
            }
        }
        return -1;
    }
}
