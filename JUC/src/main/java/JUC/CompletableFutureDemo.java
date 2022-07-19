package JUC;

import JUC.Thread.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhujinman 2022-07-18 13:38
 **/
public class CompletableFutureDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new MyThread());

		Thread t1 = new Thread(futureTask,"t1");
		t1.start();
		System.out.println(futureTask.get());
	}
}
