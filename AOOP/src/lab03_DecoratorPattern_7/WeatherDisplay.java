package lab03_DecoratorPattern_7;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherDisplay extends DisplayDecorator {

	JPanel panel;
	LabelPanel labelPanel;
	Display display;
	
	WeatherDisplay(Display display, int width, int height) {
		super(display, width, height);
		this.display = display;
		
	}

	@Override
	public JPanel create() {
		// ���̺��� ���� �г� ����
		panel = new JPanel();
		// ���̺� �Ǵ� �ٸ� �г��� �߰��� �� ���� �������� �����ǵ��� ���̾ƿ� ����
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// ũ�� ����
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		// ������ ���� ���̺� ����
		labelPanel = new LabelPanel();
		// �гο� ���̺��� ����.
		panel.add(display.create());
		panel.add(labelPanel.createPanel(getWidth(), getHeight()));
		return panel;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		display.show();
		labelPanel.updateText("Weather : 50K");

	}
	@Override
	public int getHeight() {
		return display.getHeight() + super.getHeight();
	}
}
