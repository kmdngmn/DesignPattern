package theory;

public class Main implements InterfaceTest{

	static int a;
	
	public static void main(String[] args) {

		Main main = new Main();
		main.method1();
		
		//디폴트메소드 호출		
		InterfaceTest i = new Main();
		i.method2();

		System.out.println("a=" + a);
		
	}

	@Override
	public void method1() {
		System.out.println("메소드1");
	
	
	}
	

}
