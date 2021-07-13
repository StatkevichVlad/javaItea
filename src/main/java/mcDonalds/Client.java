package mcDonalds;

public class Client extends Thread {
	private Cashier cashier;
	
	public Client(Cashier cashier) {
		this.cashier = cashier;
		start();
	}
	
	
	@Override
	public void run() {
		cashier.workWithClient();
	}

	
	
	
}
