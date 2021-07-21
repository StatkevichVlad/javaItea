package runnersDCL;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RunnerDCL extends Thread {
	private String name;
	private String way = "";
	private int stepLength;
	private int roadLength;
	private CountDownLatch countDownLatch;

	public RunnerDCL(String name, int roadLength, CountDownLatch countDownLatch) {
		super();
		this.name = name;
		this.roadLength = roadLength;
		this.countDownLatch = countDownLatch;
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
				System.out.println(name + " " + (way += tmp));

			} catch (InterruptedException e) {
			}

			countDownLatch.countDown();
		}

	}

	private void generateStepLength() {
		stepLength = (int) (Math.random() * 3);
	}

}
