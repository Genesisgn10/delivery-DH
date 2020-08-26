package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import doughTypes.DoughTypes;
import snack.Snack;
import snack_entities.Cake;
import snack_entities.Pasta;
import snack_entities.Sandwich;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int op;
		
		// Lop para manter o programa rodando enquanto a opção for diferente de 4
		do {
			// Estrutura de menu
			System.out.println("-----------------------------");
			System.out.println("|      [1] sanduíches        |");     
			System.out.println("|      [2] massas            |");
			System.out.println("|      [3] bolos             |");
			System.out.println("|      [4] sair              |");
			System.out.println("-----------------------------");
			
			// Pegar escolha do usuário a partir do menu
			System.out.print("Choose an option:");
			op = sc.nextInt();
			
			System.out.println("");
			
			// realizar ação com base na escolha do usuário
			switch(op) {
			case 1:
				// Se usuário escolher opção 1 o método submenu de sanduíche é chamado
				sandwichSubmenu(); 
				break;
			case 2:
				// Se usuário escolher opção 2 o método submenu de massas é chamado
				pastaSubmenu();
				break;
			case 3:
				// Se usuário escolher opção 3 o método submenu de bolos é chamado
				cakeSubmenu();
				break;
			case 4:
				// Se usuário escolher opção 4 o programa é encerrado
				System.out.println("See you!");
				break;
				
			default:
				// Se usuário escolher opção != das que há no menu o programa alerta
				System.out.println("invalid option");
				break;
		}
			
		}while(op != 4);
		
		sc.close();	
	}
	
public static void sandwichSubmenu() {
		
		Scanner sc = new Scanner(System.in);
		
		int value;
		Snack sandwich;
		List<String> ingredients = new ArrayList<String>();
		
		//Usuário vai informar a quantidade de ingredientes que ele quer
		
		System.out.print("Enter the amount of up to 10 ingredients you want to add: ");
		value = sc.nextInt();
		
		// Loop para adicionar os ingredientes na lista caso a quantidade ingredientes seja menor ou igual a 10
		if(value <= 10) {
			for(int x = 1; x <= value; x++) {
				
				System.out.print(String.format("add the %d ingredient: ", x));
				ingredients.add(sc.nextLine());
				sc.next();
			}
			
			// Instanciando o objeto sandwich passando como parâmetro os dados de preço e lista de ingredientes   
			sandwich = new Sandwich(12.00, ingredients);
			
			// Pegando distância entre a casa do cliente e o estabelecimento
			System.out.println("");
			System.out.print("How far is the establishment from your location? ");
			double distance = sc.nextDouble();
			
			// Informando o preço e a quantidade de tempo que o cliente vai esperar
			System.out.println("\n[Price=" + sandwich.getPrice() + "R$," + " DeliveryTime=" + sandwich.time(distance) + " minutes" + "]\n");
		}else {
			// Se não for, então um alerta para o usuário e o retorno para ele escolher a quantidade de ingrediente
			System.out.println("Only up to 10 ingredients \n");
			sandwichSubmenu();
		}
	}

	public static void pastaSubmenu() {
		
		Pasta pasta;
		
		Scanner sc = new Scanner(System.in);
		int op;
		
		// Estrutura de menu massas
		System.out.println("-----------------------------");
		System.out.println("|      [1] Macarrão         |");     
		System.out.println("|      [2] Pizza            |");
		System.out.println("|      [3] lasanha          |");
		System.out.println("|      [4] voltar           |");
		System.out.println("-----------------------------");
		
		// Pegar escolha do usuário a partir do menu
		System.out.print("Choose an option:");
		op = sc.nextInt();
		
		// realizar ação com base na escolha do usuário
		if(op == 1) {
			// Método chamado para relizar pedido massas passando como parâmetro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 12.00);
		}else if(op == 2) {
			// Método chamado para relizar pedido massas passando como parâmetro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 15.00);
		}else if(op == 3) {
			// Método chamado para relizar pedido massas passando como parâmetro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 10.00);
		}else if(op == 4) {
			// Returna para menu principal
			System.out.println("");
		}else {
			// Para opções inváldas
			System.out.println("invalid option \n");
			pastaSubmenu();
		}
	}

	public static void cakeSubmenu() {
		
		Scanner sc = new Scanner(System.in);
		
		Cake cake;
		String filling;
		String pasta;
		String roof;
		
		//Pegar informações referentes a montagem do bolo
		
		System.out.print("What is the filling? ");
		filling = sc.nextLine();
		
		System.out.print("What is the mass? ");
		pasta = sc.nextLine();
		
		System.out.print("What is the roof? ");
		roof = sc.nextLine();
		
		// Instancis objeto cake passando como parâmetro as informações para formação do bolo
		cake = new Cake(10.00, filling, roof, pasta);
		
		// Pegando distância entre a casa do cliente e o estabelecimento
		System.out.print("How far is the establishment from your location? ");
		double distance = sc.nextDouble();
		
		// Informando o preço e a quantidade de tempo que o cliente vai esperar
		System.out.println("\n[Price=" + cake.getPrice() + "R$," + " DeliveryTime=" + cake.time(distance) + " minutes" + "]");
		System.out.println("");
	}
	
	public static void makeWishPasta(DoughTypes type, Double price) {
		
		Scanner sc = new Scanner(System.in);
		
		Pasta pasta;
		String sauce;
		
		//Pegar informações referentes a massa
		System.out.print("Enter the sauce: ");
		sauce = sc.nextLine();
		
		// Instancis objeto pasta passando como parâmetro preço, molho e tipo
		pasta = new Pasta(price, sauce, type);
		
		// Pegando distância entre a casa do cliente e o estabelecimento
		System.out.print("How far is the establishment from your location? ");
		double distance = sc.nextDouble();
		
		// Informando o preço e a quantidade de tempo que o cliente vai esperar
		System.out.println("\n[Price=" + pasta.getPrice() + "R$," + " DeliveryTime=" + pasta.time(distance) + " minutes" + "]");
		System.out.println("");
	}
}
