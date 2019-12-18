package Command_Pattern;

public class Light {

	String receiver;
	
	public Light(String receiver) {
		this.receiver = receiver;
	}
	
	public void on() {
		System.out.println(receiver + " Light on");
	}

	public void off() {
		System.out.println(receiver + " Light off");
	}

}
