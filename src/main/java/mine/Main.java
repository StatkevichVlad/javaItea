package mine;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Mine mine = new Mine();
		
		Factory factory = new Factory(mine);
		Miner miner1 = new Miner("Miner 1", mine);
		Miner miner2= new Miner("Miner 2", mine);
		Miner miner3= new Miner("Miner 3", mine);
		
		
	}

}
