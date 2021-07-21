package runnersSem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RunnerSem extends Thread {
	private Semaphore semaphore;
	private String name;
	private String way = "";
	private int stepLength;
	private int roadLength;

	public RunnerSem(int roadLength, String name, Semaphore semaphore) {
		this.roadLength = roadLength;
		this.name = name;
		this.semaphore = semaphore;

		start();
	}

	public String getRunnerName() {
		return name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= roadLength; i++) {

			String tmp = "";
			generateStepLength();
			for (int j = 0; j <= stepLength; j++) {
				tmp += "_";
			}
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(name + (way += tmp));

			} catch (InterruptedException e) {
			}

		}
		semaphore.release();

	}

	private void generateStepLength() {
		stepLength = (int) (Math.random() * 3);
	}

}
