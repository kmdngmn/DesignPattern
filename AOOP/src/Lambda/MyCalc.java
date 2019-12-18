package Lambda;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Login {

	private String name;
	private String firstPassword;
	private String secondPassword;

	public Login(String firstPassword, String secondPassword) {
		this.firstPassword = firstPassword;
		this.secondPassword = secondPassword;
	}

	public String getName() {
		return name;
	}

	public String getFirstPassword() {
		return firstPassword;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

}

// 회원가입후 맵을이용하여 Person 클래스를 밸류로 이름을 키로 받아 1차,2차비밀번호 로그인후 리스너이용한 계산기 구현
public class MyCalc extends JFrame {

	Container c = getContentPane();
	JButton button1 = new JButton("회원가입");
	JButton button2 = new JButton("Login");

	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton mult = new JButton("x");
	JButton div = new JButton("/");
	JButton equal = new JButton("=");

	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);

	JTextField tf4 = new JTextField(20);// 계산기부분

	JLabel lb1 = new JLabel("ID : ");
	JLabel lb2 = new JLabel("Password1 : ");
	JLabel lb3 = new JLabel("Password2 : ");

	JLabel lb4 = new JLabel("Enter Your Log In Info...");// 성공or실패

	JTextArea ta = new JTextArea(20, 7);// 스크롤페인 장착

	public MyCalc() {

		super("실습예제");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);

		button1.addActionListener(new Mylistener());
		button2.addActionListener(new Mylistener());

		lb1.setSize(20, 10);
		lb2.setSize(20, 10);
		lb3.setSize(20, 10);
		lb4.setSize(300, 10);

		tf1.setSize(20, 10);
		tf2.setSize(20, 10);
		tf3.setSize(20, 10);
		tf4.setSize(250, 40);

		ta.setSize(280, 335);

		plus.setEnabled(false);
		minus.setEnabled(false);
		mult.setEnabled(false);
		div.setEnabled(false);
		equal.setEnabled(false);
		tf4.setEnabled(false);

		button1.setSize(10, 10);
		button2.setSize(10, 10);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLayout(new GridLayout(1, 2, 10, 0));
		jp2.setLayout(new GridLayout(3, 2, 5, 3));
		jp3.setLayout(new GridLayout(1, 5));

		jp1.add(button1);
		jp1.add(button2);

		jp2.add(lb1);
		jp2.add(tf1);
		jp2.add(lb2);
		jp2.add(tf2);
		jp2.add(lb3);
		jp2.add(tf3);

		jp3.add(plus);
		jp3.add(minus);
		jp3.add(mult);
		jp3.add(div);
		jp3.add(equal);

		ta.setLocation(10, 10);
		c.add(ta);

		jp1.setSize(260, 50);
		jp1.setLocation(310, 10);
		c.add(jp1);

		jp2.setSize(261, 150);
		jp2.setLocation(310, 70);
		c.add(jp2);

		lb4.setLocation(370, 230);
		c.add(lb4);

		tf4.setLocation(310, 260);
		c.add(tf4);

		jp3.setSize(250, 30);
		jp3.setLocation(310, 310);
		c.add(jp3);

		setResizable(false);
		setVisible(true);
	}

	// 성공실패부분 성공하면 초록색 실패시 빨간색 일반 검정색 로그인되면 계산기버튼과 택스트창 활성화
	class Mylistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			HashMap<String, Login> map = new HashMap<String, Login>();

			JButton jb = (JButton) e.getSource();

			if (jb.getText().equals("회원가입")) {
				Login info = new Login(tf2.getText(), tf3.getText());
				map.put(tf1.getText(), info);
				lb4.setText("Sign Complete!!");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");

			} else if (jb.getText().equals("Login")) {
				if (true) {// error
					lb4.setText("Correct!!!");
					lb4.setForeground(Color.GREEN);

					plus.setEnabled(true);
					minus.setEnabled(true);
					mult.setEnabled(true);
					div.setEnabled(true);
					equal.setEnabled(true);
					tf4.setEnabled(true);

				} else {
					lb4.setText("False!!!");
					lb4.setForeground(Color.RED);
				}

			}

		}
	}

	public static void main(String[] args) {

		new MyCalc();
		System.out.println("Complete!!");
	}

}