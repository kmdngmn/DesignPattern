package lab06_AdapterPattern_2;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
//        MovieMediaList list = new MovieMediaList();
//        list.load("MovieMedia.data");
//        list.printAll();
		String s = "백설공주";
//        MovieMediaManager mmm = new MovieMediaManagerFile("MovieMedia.data"); // 위에 주석처리된 3개의 행을 Adapter패턴으로 MovieMediaManagerFile을 처리 Adapter를 만들어야함
		MovieMediaManager m = new Adapter("MovieMedia.data");

		// Object Adapter 또는 Class Adapter방식으로 Adapter 클래스를 구현

		// 아래코드는 변하지 않음
		// data파일에 맨 첫번째줄에 있는 숫자 10, 2번째줄부터 10번째쭐까지 9개가 하나의 데이터이다.
		System.out.println(m.isLoaded());
		m.load();
		System.out.println(m.isLoaded());
		System.out.println("----------------\n");
		
		m.printAll(); // data 전부다출력
		System.out.println("Printing 0th item");
		m.print(2); // 0번째 data출력
		System.out.printf("Searching: %s\n", s);
		int idx = m.find(s); // 데이터에 스트링이 일치하는 인덱스를 출력 cntl+f 와 비슷한 기능
		if (idx >= 0) {
			System.out.printf("Found at index %d\n", idx);
			m.print(idx);
		} else {
			System.out.printf("%s is not found\n", s);
		}
	}
}
