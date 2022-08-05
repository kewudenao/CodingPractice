package JUC;

import JUC.Thread.MyThread;
import org.junit.Test;

import java.util.concurrent.*;

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
	@Test
	public void completableFutureNoReturnDemo() throws ExecutionException, InterruptedException {
		//无返回值
		CompletableFuture com = CompletableFuture.runAsync(
				()->{
					System.out.println(Thread.currentThread().getName());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

		);
		System.out.println(com.get());
	}

	@Test
	public void completableFutureHaveReturnDemo(){
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "hello";
		},executorService);
		executorService.shutdown();
	}
}
