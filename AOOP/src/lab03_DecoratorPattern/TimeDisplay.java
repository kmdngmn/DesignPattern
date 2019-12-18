package lab03_DecoratorPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TimeDisplay extends DisplayDecorator {

	JPanel panel;
	LabelPanel labelPanel;

	Display displayComponent;

	TimeDisplay(Display display, int width, int height) {
		super(display, width, height);

		displayComponent = display;

	}

	@Override
	public JPanel create() {
		// 레이블을 담을 패널 생성
		panel = new JPanel();
		
		 // 패널을 시각적으로 보기위해 임의 설정
		TitledBorder tb = new TitledBorder(new LineBorder(Color.red));
		panel.setBorder(tb);
		
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

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = format.format(System.currentTimeMillis());

		Date date = format.parse(current, new ParsePosition(0));

		labelPanel.updateText("Date: " + date.toString());

	}

}
