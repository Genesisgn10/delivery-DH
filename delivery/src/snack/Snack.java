package snack;

public abstract class Snack {
	
	private Double price;
	private static final Integer deliveryTime = 10;
	
	public Snack() {
		super();
	}

	public Snack(Double price) {
		super();
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// Calcular tempo de entrega
	public Double time( Double distance) {
		return deliveryTime * distance;
	}
}
