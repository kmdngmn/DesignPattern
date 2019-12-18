package Command_Pattern;

public class Stereo {

	String receiver;
	
	public Stereo(String receiver) {
		this.receiver = receiver;
	}
	
	public void on() {
		System.out.println(receiver+ " Stereo on");
	}
	public void off() {
		System.out.println(receiver + " Stereo off");
	}
	
	
	public void setCD() {
		System.out.println(receiver + " CD 가 세팅되었습니다.");
	}
	
	public void setVolume(int volume) {
		System.out.println(receiver + " 의볼륨이 " + volume + "으로 설정되었습니다.");
	}
	
}
