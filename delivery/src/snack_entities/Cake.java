package snack_entities;

import snack.Snack;

public class Cake extends Snack {
	
	private String filling;
	private String roof;
	private String pasta;
	private static final int cakePreparationTime = 10;
	
	public Cake() {
		
	}

	public Cake(Double price, String filling, String roof, String pasta) {
		super();
		this.filling = filling;
		this.roof = roof;
		this.pasta = pasta;
		setPrice(price);
	}

	public String getFilling() {
		return filling;
	}

	public void setFilling(String filling) {
		this.filling = filling;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}
	
	// Calcular tempo de preparo e somar com o tempo de entrega
	public Double time(double distance) {
		return cakePreparationTime + super.time(distance);
	}
}
