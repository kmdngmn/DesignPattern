import javax.swing.*;

public class UndoCommandButton extends CommandButton {
    Command lastCommand;

    UndoCommandButton(String text, JLabel label) {
        super(text, label, null);
        icon = null;
    }

    void setLastCommand(Command command) {
        lastCommand = command;
    }

    @Override
    public void execute() {
          if (lastCommand != null) {
              lastCommand.undo();
          }
    }
}
