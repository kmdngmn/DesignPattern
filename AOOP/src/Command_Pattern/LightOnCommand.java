package Command_Pattern;

public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) {

		this.light = light;

	}

	@Override
	public void undo() {
		light.off();
	}

	@Override
	public void execute() {
		light.on();
	}

}
