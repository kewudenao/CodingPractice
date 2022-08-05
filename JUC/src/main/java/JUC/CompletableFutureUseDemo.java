package JUC;

import java.util.concurrent.*;

/**
 * @author zhujinman 2022-07-26 16:31
 **/
public class CompletableFutureUseDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "---come in");
			int result = ThreadLocalRandom.current().nextInt(10);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("-----1 秒后出结果：" + result);
			return result;
		}, executorService).whenComplete((v, e) -> {
			if (e == null) {
				System.out.println("计算完成，更新系统updateVa" + v);
			}
		}).exceptionally(e -> {
			e.printStackTrace();
			System.out.println("异常情况" + e.getCause() + "\t" + e.getMessage());
			return null;
		});

//		exceptionally.get();
//		exceptionally.join();
		// 主线程结束后 ForkJoinPool会立即关闭
	}
}
