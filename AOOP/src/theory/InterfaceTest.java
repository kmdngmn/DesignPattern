package theory;

public interface InterfaceTest {

	public void method1();

	default void method2() {
		System.out.println("디폴트메소드입니다."); // 디폴트메소드는 인터페이스에 함수 내용까지 작성한다.
	}
}
