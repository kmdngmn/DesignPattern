package lab03_DecoratorPattern_10;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class WeatherDisplays extends DisplayDecorator {

	private Display display;
	JPanel panel;
	LabelPanel labelPanel;

	WeatherDisplays(Display display, int width, int height) {
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
		display.show();
		labelPanel.updateText("Weather: 30K");
	}
	
	@Override
	public int getHeight() {
		return display.getHeight() + super.getHeight();
	}

}
