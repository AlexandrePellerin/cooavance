package Temperat;

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

public class TemperatureSlider extends TempVueSupp{
	private JSlider slider;
	protected TemperatureModel model;
	protected TemperatureController controller;
	private JFrame temperatureJFrame;
	
	TemperatureSlider(String label, TemperatureModel model, TemperatureController controller, int posX, int posY) {
		super(label, model, controller);
		this.slider = new JSlider(SwingConstants.VERTICAL, -20, 100, (int)model.getC());
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.setMajorTickSpacing(10);
		this.slider.setMinorTickSpacing(10);
		temperatureJFrame = new JFrame(this.label);
		this.temperatureJFrame.add(slider,BorderLayout.CENTER);
		temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addObserver(this); // Connexion entre la vue et le modele
		temperatureJFrame.setSize(150, 200);
		temperatureJFrame.setLocation(posX, posY);
		temperatureJFrame.setVisible(true);
	}

	public void update(Observable o, Object arg) {
		this.slider.setValue((int)model.getC());
	}
	
	public void setDisplay(String s){
		this.slider.setValue((int)Double.parseDouble(s));
	}
	
	public double getDisplay(){
		return this.slider.getValue();
	}
	
	public void addChangeListener(ChangeListener c) {
		this.slider.addChangeListener(c);
	}
}
