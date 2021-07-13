package mcDonalds;

public class Main {

	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		
		Client client1 = new Client(cashier);
		Client client2 = new Client(cashier);
		Client client3 = new Client(cashier);
		Client client4 = new Client(cashier);
		Client client5 = new Client(cashier);
	}

}
