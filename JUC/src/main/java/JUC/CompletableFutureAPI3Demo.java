package JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujinman 2022-07-31 22:01
 **/
public class CompletableFutureAPI3Demo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {
			System.out.println("A is come in");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "playA";
		});

		CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {
			System.out.println("B is come in");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "play b";
		});


		CompletableFuture<String> stringCompletableFuture = playA.applyToEither(playB, f -> {
			return f + " is winer";
		});

		System.out.println(Thread.currentThread().getName()+"\t"+"------"+stringCompletableFuture.join());


		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 10;
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 20;
		}), (x, y) -> {
			return x + y;
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 666;
		}), (x, y) -> {
			System.out.println("aaa");
			return x + y;
		});
		System.out.println("任务结束");
		System.out.println(completableFuture.get());


	}
}
