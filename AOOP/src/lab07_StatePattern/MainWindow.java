package lab07_StatePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends FrameWindow implements ActionListener {
	private static final int X = 250;
	private static final int Y = 100;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 250;
	private static final int NUM_BUTTONS = 3;
	private static final int BUTTON_HEIGHT = 50;
	private static final String HUNDRED_BUTTON_TITLE = "100";
	private static final String THOUSAND_BUTTON_TITLE = "1000";
	private static final String FIVE_HUNDRED_BUTTON_TITLE = "500";
	private static final String RETURN_CHANGE_BUTTON_TITLE = "Return Changes";
	private static final String SELECT_BEVERAGE_BUTTON_TITLE = "Select a beverage";
	private JLabel balanceLabel; // 현재 투입 금액을 나타내는 화면
	private JLabel msgLabel; // 기타 메시지를 보여주기 위한 화면
	private MyButton hundredButton;
	private MyButton fiveHundredButton;
	private MyButton thousandButton;
	private MyButton returnChangesButton;
	private MyButton selectBeverageButton;

//    private enum STATES { STATE_0, STATE_LESS_500, STATE_500, STATE_LESS_1000, STATE_EQUAL_OR_MORE_1000};
//    private STATES state;
	private static int balance;

	private State state;

	private State state_0;
	private State state_Less_500;
	private State state_500;
	private State state_Less_1000;
	private State state_equal_more_1000;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public MainWindow(String title) {
		super();
		createWindow(title, X, Y, WIDTH, HEIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		balance = 0;
		state = new State_0(this);

		state_0 = new State_0(this);
		state_Less_500 = new State_Less_500(this);
		state_500 = new State_500(this);
		state_Less_1000 = new State_Less_1000(this);
		state_equal_more_1000 = new State_equal_more_1000(this);

//        state = STATES.STATE_0;
	}

	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		balanceLabel = new JLabel();
		msgLabel = new JLabel();

		// create buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		JPanel coinButtonPanel = new JPanel();
		coinButtonPanel.setLayout(new BoxLayout(coinButtonPanel, BoxLayout.X_AXIS));
		coinButtonPanel.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
		hundredButton = new MyButton(HUNDRED_BUTTON_TITLE);
		hundredButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
		coinButtonPanel.add(hundredButton);
		fiveHundredButton = new MyButton(FIVE_HUNDRED_BUTTON_TITLE);
		fiveHundredButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
		coinButtonPanel.add(fiveHundredButton);
		thousandButton = new MyButton(THOUSAND_BUTTON_TITLE);
		thousandButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
		coinButtonPanel.add(thousandButton);
		buttonPanel.add(coinButtonPanel, BorderLayout.NORTH);
		returnChangesButton = new MyButton(RETURN_CHANGE_BUTTON_TITLE);
		returnChangesButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
		buttonPanel.add(returnChangesButton, BorderLayout.CENTER);
		selectBeverageButton = new MyButton(SELECT_BEVERAGE_BUTTON_TITLE);
		selectBeverageButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
		buttonPanel.add(selectBeverageButton, BorderLayout.SOUTH);

		panel.add(buttonPanel, BorderLayout.NORTH);
		balanceLabel.setPreferredSize(new Dimension(width, (HEIGHT - BUTTON_HEIGHT) / 2));
		panel.add(balanceLabel, BorderLayout.CENTER);
		msgLabel.setPreferredSize(new Dimension(width, (HEIGHT - BUTTON_HEIGHT) / 2));
		panel.add(msgLabel, BorderLayout.SOUTH);
		setBalanceText(); // 투입 금액 0
		return panel;
	}

	public void setBalanceText() {
		balanceLabel.setText("현재 투입 금액: " + balance + "원");
	}

	public void setMsgText(String msg) {
		msgLabel.setText(msg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == hundredButton) {
			if (balance == 0) {
				state_0.insert_100();
			} else if (balance > 0 && balance < 500) {
				state_Less_500.insert_100();
			} else if (balance == 500) {
				state_500.insert_100();
			} else if (balance > 500 && balance < 1000) {
				state_Less_1000.insert_100();
			} else if (balance >= 1000) {

				state_equal_more_1000.insert_100();
			}
		} else if (e.getSource() == fiveHundredButton) {
			if (balance == 0) {
				state_0.insert_500();
			} else if (balance > 0 && balance < 500) {
				state_Less_500.insert_500();
			} else if (balance == 500) {
				state_500.insert_500();
			} else if (balance > 500 && balance < 1000) {
				state_Less_1000.insert_500();
			} else if (balance >= 1000) {

				state_equal_more_1000.insert_500();
			}
		} else if (e.getSource() == thousandButton) {
			if (balance == 0) {
				state_0.insert_1000();
			} else if (balance > 0 && balance < 500) {
				state_Less_500.insert_1000();
			} else if (balance == 500) {
				state_500.insert_1000();
			} else if (balance > 500 && balance < 1000) {
				state_Less_1000.insert_1000();
			} else if (balance >= 1000) {

				state_equal_more_1000.insert_1000();
			}
		} else if (e.getSource() == returnChangesButton) {
			if (balance == 0) {
				state_0.return_charge();
			} else if (balance > 0 && balance < 500) {
				state_Less_500.return_charge();
			} else if (balance == 500) {
				state_500.return_charge();
			} else if (balance > 500 && balance < 1000) {
				state_Less_1000.return_charge();
			} else if (balance >= 1000) {
				state_equal_more_1000.return_charge();
			}
		} else if (e.getSource() == selectBeverageButton) {
			if (balance == 0) {
				state_0.select_beverage();
			} else if (balance > 0 && balance < 500) {
				state_Less_500.select_beverage();
			} else if (balance == 500) {
				state_500.select_beverage();
			} else if (balance > 500 && balance < 1000) {
				state_Less_1000.select_beverage();
			} else if (balance >= 1000) {
				state_equal_more_1000.select_beverage();
			}
		}
		System.out.println(getState().toString());
	}
}
