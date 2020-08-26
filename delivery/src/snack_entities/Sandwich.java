package snack_entities;

import java.util.ArrayList;
import java.util.List;

import snack.Snack;

public class Sandwich extends Snack {
	
	private List<String> ingredients = new ArrayList<String>();
	private static final int preparationTime = 15;
	
	public Sandwich() {
		super();
	}

	public Sandwich(Double price, List<String> ingredients) {
		super();
		this.ingredients = ingredients;
		setPrice(price);
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public static int getPreparationtime() {
		return preparationTime;
	}
	
	// Calcular tempo de preparo e somar com o tempo de entrega
	public Double time(Double distance) {
		return (preparationTime + super.time(distance));
	}
}


