import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final String MAIN_TITLE = "Main Window";

    Model model;
    MainWindow view;

    Controller() {
        this.model = new Model();
        this.view = new MainWindow(MAIN_TITLE, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getHundredButton()) {
            model.addHundred();
        }
        else if (e.getSource() == view.getFiveHundredButton()) {
            model.addFiveHundred();
        }
        else if (e.getSource() == view.getThousandButton()) {
            model.addThousand();
        }
        else if (e.getSource() == view.getReturnChangesButton()) {
            model.returnChanges();
        }
        else if (e.getSource() == view.getSelectBeverageButton()) {
            model.selectBeverage();
        }
        view.setMsgText(model.getMsg());
        view.setBalanceText(model.getBalance());
    }
}
