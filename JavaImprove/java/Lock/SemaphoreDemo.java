package Lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author kewudenao 2022-03-28 19:38
 **/
public class SemaphoreDemo {
	/**
	 *  semaphre 的作用类似于一个厕所中有五个坑位，当线程进去后坑位被占用，
	 *  当厕所中没有坑位时其他线程需要被阻塞，线程离开之后需要释放坑位。
	 * @param args
	 */

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);

		for (int i = 0; i < 15; i++) {
			int finalI = i;
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println("线程："+ finalI +"占用");
					TimeUnit.MILLISECONDS.sleep(3000);
					System.out.println("线程："+ finalI +"解除占用");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			},String.valueOf(i)).start();
		}
	}
}
