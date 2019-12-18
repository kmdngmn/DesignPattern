
// 객체 생성부분, 싱글턴패턴으로 구현
public class WindowCreator extends Creator {

	private volatile static WindowCreator inst;

	private Product pro; // 윈도우

	private WindowCreator() {} // 외부에서 WindowCreator (팩토리) 객체생성을 막음
	
	public static WindowCreator getInstance() { // 싱글턴 패턴; 팩토리 (객체)를 하나만 만들어야함
		if (inst == null) {
			synchronized (WindowCreator.class) {
				if (inst == null) {
					inst = new WindowCreator();
				}
			}
		}
		return inst;
	}

	@Override
	public Product createWindow(String title, int x, int y, int width, int height) { // 팩토리 메소드

		if (title.equals("Label Window")) {

			pro = new LabelWindow(title, x, y, width, height);

		} else if (title.equals("TextField Window")) {

			pro = new TextFieldWindow(title, x, y, width, height);

		} else {
			pro = null;
		}

		return pro;

	}

}
