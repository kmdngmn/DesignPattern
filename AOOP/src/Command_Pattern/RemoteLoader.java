package Command_Pattern;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		Light livingRoomLight = new Light("Living Room");
	//	Light livingRoomLight = new Light("Kitchen");
		Stereo stereo = new Stereo("Living Room");
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		//LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
	//	LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
	//	StereoOffWithCDCommand stereoOff = new StereoOffCommand(stereo);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
	//	remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
	//	remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		System.out.println(remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		System.out.println("--undo--\n");
		remoteControl.undoButtonWasPushed();
		
		
		remoteControl.offButtonWasPushed(0);
		System.out.println("--undo--\n");
		remoteControl.undoButtonWasPushed();
		
		
//		remoteControl.onButtonWasPushed(1);
//		remoteControl.offButtonWasPushed(1);
//		remoteControl.onButtonWasPushed(3);
//		remoteControl.offButtonWasPushed(3);

	}

}
