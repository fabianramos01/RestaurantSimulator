package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import controller.Command;
import controller.ConstantList;
import controller.Controller;

public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;

	private JSlider sliderPerson;
	private JSlider sliderCredit;
	private JSlider sliderLunch;

	public PanelInfo(Controller controller) {
		setLayout(new GridLayout(7, 1));
		add(UtilityList.createJLabel(ConstantList.PERSON_TIME, ConstantList.WORD_FONT, Color.BLACK));
		sliderPerson = createSlider(1, ConstantList.MAX_PERSON_TIME, 10, controller);
		add(sliderPerson);
		add(UtilityList.createJLabel(ConstantList.LUNCH_TIME, ConstantList.WORD_FONT, Color.BLACK));
		sliderCredit = createSlider(1, ConstantList.MAX_CREDIT_TIME, 20, controller);
		add(sliderCredit);
		add(UtilityList.createJLabel(ConstantList.CREDIT_TIME, ConstantList.WORD_FONT, Color.BLACK));
		sliderLunch = createSlider(1, ConstantList.MAX_CREDIT_TIME, 20, controller);
		add(sliderLunch);
		add(UtilityList.createJButtonText(Command.COMMAND_PLAY.getCommand(), Command.COMMAND_PLAY.getTitle(),
				Color.WHITE, Color.BLACK, ConstantList.WORD_FONT, controller));
	}

	private JSlider createSlider(int minValue, int maxValue, int majorSpacing, ChangeListener changeListener) {
		JSlider slider = new JSlider(minValue, maxValue);
		slider.addChangeListener(changeListener);
		slider.setMajorTickSpacing(majorSpacing);
		slider.setPaintLabels(true);
		slider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		return slider;
	}
	
	public int getPersonTime() {
		return sliderPerson.getValue();
	}
	
	public int getCreditTime() {
		return sliderCredit.getValue();
	}
	
	public int getLunchTime() {
		return sliderLunch.getValue();
	}
}