package mcDonalds;

public class Cashier  {
	private int serviceTime;
	private boolean cashBoxOpen = true;

	public Cashier() {

	}

	
	public synchronized void workWithClient() {
		if (cashBoxOpen == true) {
			try {
				System.out.println("CashBox is open. Hello quest");
				Thread.sleep(1000 * calcServiseTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Free cash desk");
		}
		else {
			System.out.println("CashBox is closed. Bye quest.");
		}
		possibilityCloseCashbox();
	}

	private int calcServiseTime() {
		return serviceTime = (int) (Math.random() * 6 + 3);
	}

	private boolean possibilityCloseCashbox() {
		int tmp;
		tmp = (int) Math.random() * 2;
		if (tmp == 1) {
			cashBoxOpen = false;
		}
		return cashBoxOpen;

	}
}
