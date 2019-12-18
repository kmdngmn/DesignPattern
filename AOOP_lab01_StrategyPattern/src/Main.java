import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 과제수정*
 * 
 * Comparable 인터페이스를 생성하여 (implements x) compare 메소드를 override 하기.
 * ArrageBy 인터페이스가아닌 Comparable 인터페이스로 구현
 * Compare 메소드를 override 해서 어떤 타입이든 비교할 수 있게 BubbleSort 메소드를 Object[] 타입으로 일반화
 * Compare 를 setCompare ? 해서 if문 안에 비교하는문 만 바뀌어야함.
 * 어떤 타입이 새롭게 들어오더라도 compare문만 수정할 수 있게 Strategy Pattern 작성  
 * 
 */

public class Main extends Sorter {
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
		for (FileInfo list : fileLists) {
			System.out.println(list.toString());
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		Main m = new Main();
		FileInfo[] fileLists = m.createFileInfoArrays();

		System.out.println("원본 리스트");
		m.printFileLists(fileLists);

		// 나머지 코드 추가

		Sorter s = new Sorter();

		System.out.println("파일 이름으로 정렬된 리스트");
		s.setCompare(new ByName());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("파일 종류로 정렬된 리스트");
		s.setCompare(new ByType());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("파일 크기로 정렬된 리스트");
		s.setCompare(new BySize());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

		System.out.println("파일 수정 시간으로 정렬된 리스트");
		s.setCompare(new ByModifiedDate());
		s.bubbleSort(fileLists);
		m.printFileLists(fileLists);

	}
}
