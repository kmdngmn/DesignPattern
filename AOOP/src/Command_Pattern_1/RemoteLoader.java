package Command_Pattern_1;

public class RemoteLoader {
	public static void main(String[] args) {

		RemoteControl remoteControl = new RemoteControl();
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);
		remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanLow, ceilingFanOff);
		remoteControl.setCommand(0, ceilingFanOff, ceilingFanOff);
		System.out.println(remoteControl);

//		remoteControl.onButtonWasPushed(0);
//		remoteControl.offButtonWasPushed(0);
		
		remoteControl.onButtonWasPushed(1);
//		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(0);
		
		remoteControl.onButtonWasPushed(2);
		remoteControl.undoButtonWasPushed();
//		remoteControl.offButtonWasPushed(2);
		
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);

		remoteControl.undoButtonWasPushed();
		
	}
}
