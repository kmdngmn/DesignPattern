package lab03_DecoratorPattern_3;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class WeatherDisplay extends DisplayDecorator {
	JPanel panel;
	LabelPanel labelPanel;

	Display display;

	WeatherDisplay(Display display, int width, int height) {
		super(display, width, height);
		// TODO Auto-generated constructor stub
		this.display = display;
	}

	@Override
	public JPanel create() {
		panel = new JPanel();
		// 레이블 또는 다른 패널이 추가될 때 세로 방향으로 나열되도록 레이아웃 설정
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// 크기 지정
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		// 문구를 보일 레이블 생성
		labelPanel = new LabelPanel();
		// 패널에 레이블을 붙임.
		panel.add(display.create());
		panel.add(labelPanel.createPanel(getWidth(), getHeight()));
		return panel;
	}

	@Override
	public void show() {
		display.show();
		labelPanel.updateText("Wheather: 온도: 20도, 습도: 60");

	}

	@Override
	public int getHeight() {
		return display.getHeight() + super.getHeight();
	}
}
