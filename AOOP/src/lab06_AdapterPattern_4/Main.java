package lab06_AdapterPattern_4;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
//        MovieMediaList list = new MovieMediaList();
//        list.load("MovieMedia.data");
//        list.printAll();
		String s = "오 브라더, 오 시스터!";
		MovieMediaManager mmm = new Adapter("MovieMedia.data"); // 위에 주석처리된 3개의 행을 Adapter패턴으로 MovieMediaManagerFile을 처리
																// Adapter를 만들어야함
		// Object Adapter 또는 Class Adapter방식으로 Adapter 클래스를 구현
		// MovieMediaManager m = new Adapter("filename"); 이런식으로 호출해야함

		// 아래코드는 변하지 않음
		// data파일에 맨 첫번째줄에 있는 숫자 10, 2번째줄부터 10번째쭐까지 9개가 하나의 데이터이다.
		System.out.println(mmm.isLoaded());
		mmm.load();
		System.out.println(mmm.isLoaded());
		System.out.println("-------------------\n");
		mmm.printAll(); // data 전부다출력
		System.out.println("Printing 4th item");
		mmm.print(4); // 0번째 data출력
		System.out.printf("Searching: %s\n", s);
		int idx = mmm.find(s); // 데이터에 스트링이 일치하는 인덱스를 출력 cntl+f 와 비슷한 기능
		if (idx >= 0) {
			System.out.printf("Found at index %d\n", idx);
			mmm.print(idx);
		} else {
			System.out.printf("%s is not found\n", s);
		}
	}
}
