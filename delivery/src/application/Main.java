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
		
		// Lop para manter o programa rodando enquanto a op��o for diferente de 4
		do {
			// Estrutura de menu
			System.out.println("-----------------------------");
			System.out.println("|      [1] sandu�ches        |");     
			System.out.println("|      [2] massas            |");
			System.out.println("|      [3] bolos             |");
			System.out.println("|      [4] sair              |");
			System.out.println("-----------------------------");
			
			// Pegar escolha do usu�rio a partir do menu
			System.out.print("Choose an option:");
			op = sc.nextInt();
			
			System.out.println("");
			
			// realizar a��o com base na escolha do usu�rio
			switch(op) {
			case 1:
				// Se usu�rio escolher op��o 1 o m�todo submenu de sandu�che � chamado
				sandwichSubmenu(); 
				break;
			case 2:
				// Se usu�rio escolher op��o 2 o m�todo submenu de massas � chamado
				pastaSubmenu();
				break;
			case 3:
				// Se usu�rio escolher op��o 3 o m�todo submenu de bolos � chamado
				cakeSubmenu();
				break;
			case 4:
				// Se usu�rio escolher op��o 4 o programa � encerrado
				System.out.println("See you!");
				break;
				
			default:
				// Se usu�rio escolher op��o != das que h� no menu o programa alerta
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
		
		//Usu�rio vai informar a quantidade de ingredientes que ele quer
		
		System.out.print("Enter the amount of up to 10 ingredients you want to add: ");
		value = sc.nextInt();
		
		// Loop para adicionar os ingredientes na lista caso a quantidade ingredientes seja menor ou igual a 10
		if(value <= 10) {
			for(int x = 1; x <= value; x++) {
				
				System.out.print(String.format("add the %d ingredient: ", x));
				ingredients.add(sc.nextLine());
				sc.next();
			}
			
			// Instanciando o objeto sandwich passando como par�metro os dados de pre�o e lista de ingredientes   
			sandwich = new Sandwich(12.00, ingredients);
			
			// Pegando dist�ncia entre a casa do cliente e o estabelecimento
			System.out.println("");
			System.out.print("How far is the establishment from your location? ");
			double distance = sc.nextDouble();
			
			// Informando o pre�o e a quantidade de tempo que o cliente vai esperar
			System.out.println("\n[Price=" + sandwich.getPrice() + "R$," + " DeliveryTime=" + sandwich.time(distance) + " minutes" + "]\n");
		}else {
			// Se n�o for, ent�o um alerta para o usu�rio e o retorno para ele escolher a quantidade de ingrediente
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
		System.out.println("|      [1] Macarr�o         |");     
		System.out.println("|      [2] Pizza            |");
		System.out.println("|      [3] lasanha          |");
		System.out.println("|      [4] voltar           |");
		System.out.println("-----------------------------");
		
		// Pegar escolha do usu�rio a partir do menu
		System.out.print("Choose an option:");
		op = sc.nextInt();
		
		// realizar a��o com base na escolha do usu�rio
		if(op == 1) {
			// M�todo chamado para relizar pedido massas passando como par�metro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 12.00);
		}else if(op == 2) {
			// M�todo chamado para relizar pedido massas passando como par�metro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 15.00);
		}else if(op == 3) {
			// M�todo chamado para relizar pedido massas passando como par�metro o tipo da massa e o valor
			makeWishPasta(DoughTypes.MACARRAO, 10.00);
		}else if(op == 4) {
			// Returna para menu principal
			System.out.println("");
		}else {
			// Para op��es inv�ldas
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
		
		//Pegar informa��es referentes a montagem do bolo
		
		System.out.print("What is the filling? ");
		filling = sc.nextLine();
		
		System.out.print("What is the mass? ");
		pasta = sc.nextLine();
		
		System.out.print("What is the roof? ");
		roof = sc.nextLine();
		
		// Instancis objeto cake passando como par�metro as informa��es para forma��o do bolo
		cake = new Cake(10.00, filling, roof, pasta);
		
		// Pegando dist�ncia entre a casa do cliente e o estabelecimento
		System.out.print("How far is the establishment from your location? ");
		double distance = sc.nextDouble();
		
		// Informando o pre�o e a quantidade de tempo que o cliente vai esperar
		System.out.println("\n[Price=" + cake.getPrice() + "R$," + " DeliveryTime=" + cake.time(distance) + " minutes" + "]");
		System.out.println("");
	}
	
	public static void makeWishPasta(DoughTypes type, Double price) {
		
		Scanner sc = new Scanner(System.in);
		
		Pasta pasta;
		String sauce;
		
		//Pegar informa��es referentes a massa
		System.out.print("Enter the sauce: ");
		sauce = sc.nextLine();
		
		// Instancis objeto pasta passando como par�metro pre�o, molho e tipo
		pasta = new Pasta(price, sauce, type);
		
		// Pegando dist�ncia entre a casa do cliente e o estabelecimento
		System.out.print("How far is the establishment from your location? ");
		double distance = sc.nextDouble();
		
		// Informando o pre�o e a quantidade de tempo que o cliente vai esperar
		System.out.println("\n[Price=" + pasta.getPrice() + "R$," + " DeliveryTime=" + pasta.time(distance) + " minutes" + "]");
		System.out.println("");
	}
}
