package lab06_AdapterPattern_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Adaptee
public class MovieMediaList {
	ArrayList<MovieMedia> list;
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

	public boolean isLoaded() {
		return loaded;
	}

	public int find(String str) {

		for (int i = 0; i < list.size(); i++) {
			movieMedia = list.get(i);
			if (movieMedia.find(str)) {
				return i;
			}
		}
		return -1;
	}

	public void print(int index) {

		if (index < 0 || index >= list.size()) {
			System.out.println("잘못된 데이터를 출력하려고 합니다");
		} else {
			movieMedia = list.get(index);
			System.out.println(movieMedia);
		}

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
		} catch (IOException e) {
			System.out.println("Error: reading the media file");
			e.printStackTrace();
		}
		loaded = true;
	}

	public void printAll() {
		for (MovieMedia m : list) {
			System.out.println(m);
		}
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
