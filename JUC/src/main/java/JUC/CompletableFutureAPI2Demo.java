package JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujinman 2022-07-31 21:36
 **/
public class CompletableFutureAPI2Demo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletableFuture.supplyAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1;
		},executorService).handle((f,e)->{
			int i = 10/0;
			return f+2;
		}).handle((f,e)->{
			System.out.println(f);
			return f+3;
		}).whenComplete((v,e)->{
			if (e==null){
				System.out.println("计算结果："+v);
				executorService.shutdown();
			}
		}).exceptionally(e->{
			e.printStackTrace();
			System.out.println(e.getMessage());
			executorService.shutdown();
			return null;
		});
	}
}
