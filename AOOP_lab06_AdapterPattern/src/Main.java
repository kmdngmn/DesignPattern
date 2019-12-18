import java.util.Collections;

/*
 * Object Adapter 또는 Class Adapter방식으로 Adapter 클래스를 구현
 * 
 * MovieMedia.data의 2번째줄부터 10번째쭐까지 9개가 하나의 데이터이다. 총 10개의 데이터로 구성 
 * 
 * MovieMediaManager m = new 어댑터클래스("MovieMedia.data"); 이런식으로 선언하여 쓰도록 어댑터 클래스를 생성
 * 
 * lab06 Adapter Pattern 실습문제는 어댑터의 기본 개념과 ArrayList를 잘 다룰 수만 있다면 어렵지 않음
 */

public class Main {
    public static void main(String[] args) {
//        MovieMediaList list = new MovieMediaList();
//        list.load("MovieMedia.data");
//        list.printAll();
// 		    위 주석 3개 코드는 테스트용으로 선언된것임.
       	
        String s = "아메리칸 셰프";	// 찾고자 하는 string 입력. 가장 먼저 나오는 string이 찾아짐
 
/*
* 어댑터 패턴 적용
*/
        MovieMediaManager m = new MovieMediaAdapter("MovieMedia.data");
        m.load();
        m.printAll(); // data 전부다출력
        System.out.println("Printing 7th item"); // n번째 data출력
        m.print(7); // n번째 data출력  
        System.out.printf("Searching: %s\n", s);
        int idx = m.find(s); // 데이터에 스트링이 일치하는 인덱스를 출력 cntl+f 와 비슷한 기능.가장 맨 위에 있는 일치하는 스트링을 탐색  
        if (idx >= 0) {
            System.out.printf("Found at index %d\n", idx);
            m.print(idx);
        }
        else {
            System.out.printf("%s is not found\n", s);
        }
        
       
/*
 *  어댑터 패턴 사용전 코드
 */
        
//      MovieMediaManager mmm = new MovieMediaManagerFile("MovieMedia.data"); 
        
//        mmm.printAll(); //  data 전부다출력
//        System.out.println("Printing 0th item");
//        mmm.print(0); // 0번째 data출력  
//        System.out.printf("Searching: %s\n", s);
//        int idx = mmm.find(s); // 데이터에 스트링이 일치하는 인덱스를 출력 cntl+f 와 비슷한 기능.가장 맨 위에 있는 일치하는 스트링을 탐색
//        if (idx >= 0) {
//            System.out.printf("Found at index %d\n", idx);
//            mmm.print(idx);
//        }
//        else {
//            System.out.printf("%s is not found\n", s);
//        }
    }
}
