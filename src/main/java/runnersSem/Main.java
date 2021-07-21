package runnersSem;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(0);

		RunnerSem runner1 = new RunnerSem(10, "Usain Bolt ", semaphore);
		RunnerSem runner2 = new RunnerSem(10, "Vlad Statkevich ", semaphore);

		String winner = "";
		try {
			semaphore.acquire();
			if (runner1.isAlive()) {
				winner = runner2.getRunnerName();
				runner1.join();
			} else {
				winner = runner1.getRunnerName();
				runner2.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(winner + "won!");
	

	}

}
