package snack_entities;

import doughTypes.DoughTypes;
import snack.Snack;

public class Pasta extends Snack {
	
	private String sauce;
	private static final int doughPreparationTime = 30;
	private DoughTypes type;	
	
	public Pasta() {
		super();
	}
	
	public Pasta(Double price, String sauce, DoughTypes type) {
		super();
		this.sauce = sauce;
		this.type = type;
		setPrice(price);
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public DoughTypes getType() {
		return type;
	}

	public void setType(DoughTypes type) {
		this.type = type;
	}

	// Calcular tempo de preparo e somar com o tempo de entrega
	public Double time(double distance) {
		return doughPreparationTime + super.time(distance);
	}
}
