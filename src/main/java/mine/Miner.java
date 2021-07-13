package mine;

public class Miner extends Thread {
	private Mine mine;
	private String name;

	public Miner(String name, Mine mine) {
		this.name = name;
		this.mine = mine;
		start();
	}

	@Override
	public void run() {
		
			while (mine.getGold() > 0) {
				synchronized (mine) {
					if(mine.getGold() < 3) {
						mine.setGold(0);
					}
					else {
						mine.setGold(mine.getGold() - 3);
					}
				
				System.out.println("Golds left = " + mine.getGold() + ", " + name + " mined 3 golds");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public String toString() {
		return "Golds left = " + mine.getGold() + ", " + name + " mined 3 golds";
	}

}
