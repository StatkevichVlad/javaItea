package mine;

public class Factory extends Thread {
	private Mine mine;
	private int minerNumber = 3;

	public Factory(Mine mine) {
		this.mine = mine;
		start();
	}

	@Override
	public void run() {
		while (mine.getGold() > 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Miner("Miner " + ++minerNumber, mine);
		}
	}

}
