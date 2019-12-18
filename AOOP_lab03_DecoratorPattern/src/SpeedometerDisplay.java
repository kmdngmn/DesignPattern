import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SpeedometerDisplay extends DisplayDecorator {

	JPanel panel;
	LabelPanel labelPanel;

	Display displayComponent;

	public SpeedometerDisplay(Display display, int width, int height) {
		super(display, width, height);
		displayComponent = display;

	}

	@Override
	public JPanel create() {
		// 레이블을 담을 패널 생성
		panel = new JPanel();
		// 레이블 또는 다른 패널이 추가될 때 세로 방향으로 나열되도록 레이아웃 설정
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// 크기 지정
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		// 문구를 보일 레이블 생성
		labelPanel = new LabelPanel();
		// 패널에 레이블을 붙임.

		panel.add(displayComponent.create());

		panel.add(labelPanel.createPanel(getWidth(), getHeight()));
		return panel;
	}

	@Override
	public void show() {
		displayComponent.show();
		labelPanel.updateText("Speed: 50");
	}

	@Override
	public int getHeight() {
		return displayComponent.getHeight() + super.getHeight();
	}

}
