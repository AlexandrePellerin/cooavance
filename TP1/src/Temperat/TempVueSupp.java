package Temperat;

import java.util.Observer;

public abstract class TempVueSupp implements Observer{

	protected String label;
	protected TemperatureModel model;
	protected TemperatureController controller;

	public TempVueSupp(String label, TemperatureModel model, TemperatureController controller){
		this.label = label;
		this.model = model;
		this.controller = controller;
	}
	
	public void enableWarningColor() {
	}

	public void disableWarningColor() {
	}
}
