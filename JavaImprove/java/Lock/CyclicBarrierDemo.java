package Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author kewudenao 2022-03-28 12:49
 **/
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
			System.out.println("任务完成");
		});
		for (int i = 0; i < 5; i++) {
			int finalI = i;
			new Thread (()->{
				try {
					System.out.println("执行任务："+ finalI);
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}
}
