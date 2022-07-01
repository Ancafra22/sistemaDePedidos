package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//definindo formato de hora
		Locale.setDefault(Locale.US);//definindo idioma
		Scanner sc = new Scanner(System.in);//definindo o método de leitura de dados
		
		System.out.println("Enter client data: ");//entrar com os dados do cliente
		System.out.print("Name: ");//digitar o nome do cliente
		String name = sc.nextLine();//recebe o nome digitado e guarda na variável nome
		System.out.print("Email: ");//digitar o email do cliente
		String email = sc.next();//recebe o nome do cliente  e  guarda na variável email
		System.out.print("Birth date (dd/mm/yyyy)");//digitar a data de nascimento do cliente
		Date birthDate = sdf.parse(sc.next());//variável do tipo Data recebe objeto sdf e convertea data de nascimento em String
		
		/*depois de digitados os dados do cliente é preciso instanciar o objeto Client 
		 * com os parâmetros dos dados acima(nome, email e data de nascimento)*/
		Client client = new Client(name, email, birthDate);//instanciando o objeto Client e passando os parâmetros
		
		//digitar o Status do pedido
		System.out.println("Enter order data: ");
		System.out.print("Sattus: ");
		
		//instanciando a classe OrderStatus e guardando no objeto (status) o status do pedido da classe
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		/*instanciando a classe Order e criando um objeto order com os parâmetros 
		 * (data do pedido, status do pedido(que é o objeto status) e o cliente (que é o objeto client))*/
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many itens to this order? ");
		int n = sc.nextInt();//fazer a leitura da quantidade de produtos no pedido
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #"+(i)+" item data: ");//(for) para leirura dos pedidos de acordo com a quantidade digitada
			System.out.print("Product name: ");
			sc.nextLine();//para consumir a quebra linha que ficou pendente na leitura do Inteiro acima
			String productName = sc.nextLine();//faz a leitura dos nomes dos produtos e guarda na variável productName
			System.out.println("Product price: ");
			Double productPrice = sc.nextDouble();//faz a leitura dos preços dos produtos e guarda na variável productPrice
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();//faz a leitura das quantidades dos produtos e guarda na variável quantity
			
			//isntanciando as classes (Product e OrderItem) com os parâmetros 
			Product product = new Product(productName, productPrice);
			OrderItem it = new OrderItem(quantity, productPrice, product);
			order.addItem(it);//adicionando os itens na lista
		}
		
		System.out.println();
		System.out.println(order);//imprimindo o objeto order
		
		sc.close();

	}

}
