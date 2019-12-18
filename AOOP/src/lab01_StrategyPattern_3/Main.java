package lab01_StrategyPattern_3;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
	String[] names = { "CompareModifiedDate", "CompareFileType", "CompareFileName", "Main", "CompareSize" };
	String[] types = { "java", "java", "class", "java", "Class" };
	int[] sizes = { 120, 80, 150, 85, 100 };
	String[] dateStrings = { "2019-09-13T21:59:00", "2019-09-12T21:59:00", "2019-09-13T16:54:00", "2019-09-12T21:54:00",
			"2019-09-13T11:59:00" };

	// 앞에서 정의된 파일 이름, 타입, 크기, 날짜 정보를 이용해서 FileInfo 배열 생성
	public FileInfo[] createFileInfoArrays() {
		FileInfo[] fileLists = new FileInfo[names.length];
		SimpleDateFormat dateTimeInstance = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		for (int i = 0; i < fileLists.length; i++) {
			Date date = dateTimeInstance.parse(dateStrings[i], new ParsePosition(0));
			fileLists[i] = new FileInfo(names[i], types[i], sizes[i], date);
		}
		return fileLists;
	}

	public void printFileLists(FileInfo[] fileLists) {

		// 코드 추가
		for (FileInfo fileInfo : fileLists) {
			System.out.println(fileInfo.toString());
		}

	}

	public static void main(String[] args) {
		Main m = new Main();
		FileInfo[] fileLists = m.createFileInfoArrays();
		System.out.println("원본 리스트");
		m.printFileLists(fileLists);

		Sorter s = new Sorter();

		System.out.println("\n\n파일 이름으로 정렬된 리스트");
		s.setComparable(new ByName());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("\n\n파일 종류로 정렬된 리스트");
		s.setComparable(new ByType());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("\n\n파일 크기로 정렬된 리스트");
		s.setComparable(new BySize());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("\n\n파일 수정 시간으로 정렬된 리스트");
		s.setComparable(new ByModifiedDate());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		// 나머지 코드 추가
	}
}
