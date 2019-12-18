import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Adaptee
public class MovieMediaList {
	ArrayList<MovieMedia> list; // Adaptee 에서 ArrayList를 다루는 나머지 함수 구현
	MovieMedia movieMedia;
	BufferedReader reader;
	private boolean loaded;

	MovieMediaList() {
		list = new ArrayList<MovieMedia>();
		loaded = false;
	}

	void add(MovieMedia o) {
		list.add(o);
	}

	public boolean isLoaded(){
		return loaded;
	}
	
	void load(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String s = reader.readLine();
			int nums = Integer.parseInt(s); // 개수 읽어오기
			for (int i = 0; i < nums; i++) {
				MovieMedia movieMedia = new MovieMedia();
				readMediaDatum(movieMedia);
				list.add(movieMedia);
//                System.out.println(movieMedia);
			}
			reader.close();
			
			loaded = true;
		} catch (IOException e) {
			System.out.println("Error: reading the media file");
			e.printStackTrace();
		}
	}

	public void printAll() {
		for (MovieMedia m : list) {
			System.out.println(m);
		}
	}

	public void print(int index) {
		
		if (index < 0 || index >= list.size()) {
			System.out.println("잘못된 데이터를 출력하려고 합니다.");

		} else {
			movieMedia = list.get(index);
			System.out.println(movieMedia.toString());
		}

	}

	public int find(String str) {

		for(int i = 0; i < list.size(); i++) {
			movieMedia = list.get(i);
		
			if (movieMedia.find(str)) { // find 함수는 true false를 반환. str이 존재한다면 true를 반환
                return i;
            }
		}
		return -1;	// str이 존재하지 않을 경우 -1 리턴
	}

	private void readMediaDatum(MovieMedia mm) {
		try {
			mm.setType(reader.readLine());
			mm.setTitle(reader.readLine());
			mm.setKoreanTitle(reader.readLine());
			mm.setDirector(reader.readLine());
			mm.setActors(reader.readLine());
			String s = reader.readLine();
			mm.setYear(Integer.parseInt(s));
			mm.setSubtitle(reader.readLine());
			mm.setFileName(reader.readLine());
			mm.setResolution(reader.readLine());
		} catch (IOException e) {
			System.out.println("Error: reading the media file");
			e.printStackTrace();
		}
	}
}
