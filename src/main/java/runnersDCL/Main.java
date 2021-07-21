package runnersDCL;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);

		RunnerDCL runner1 = new RunnerDCL("runner 1", 10, countDownLatch);
		RunnerDCL runner2 = new RunnerDCL("runner 2", 10, countDownLatch);

		new Thread(runner1).start();
		new Thread(runner2).start();
		String winnerName = "no one";
		
		try {
			countDownLatch.await();
			if (runner1.isAlive()) {
				winnerName = runner2.getRunnerName();
				runner1.join();
			} else if (runner2.isAlive()){
				winnerName = runner1.getRunnerName();
				runner2.join();
			}	
			
			System.out.println(winnerName + " won!");


		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
}
