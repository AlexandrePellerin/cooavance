package exo;

import java.util.ArrayList;

public abstract class Subject {

	ArrayList<Observer> observers = new ArrayList<>();
	
	public void attach(Observer obs){
		this.observers.add(obs);
	}
	
	public void detach(Observer obs){
		this.observers.remove(obs);
	}
	
	public void notifyObservers(){
		for(Observer o : observers){
			o.Update();
		}
	}
}
