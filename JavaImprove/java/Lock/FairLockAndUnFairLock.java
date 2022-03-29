package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kewudenao 2022-03-23 14:59
 **/
class Phone{
	public synchronized void sendTest() throws Exception{
		System.out.println(Thread.currentThread().getId()+"测试1asdfasdfasdf");
//		new TestLock().methodOne();
	}
}
public class FairLockAndUnFairLock {
	public static void main(String[] args) {
		/**
		 * 公平锁 多个线程按照申请锁的顺序来获取锁，类似队列FIFO
		 * 非公平锁 不是按照顺序，后申请的线程和先申请的线程获取锁的概率是一样的
		 *          在高并发的情况下可能造成优先级反转或饥饿现象。会先尝试占有锁，如果尝试失败，再采用类似公平锁那种方式
		 *  可重入锁（递归锁）
		 *      同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码
		 *      在同一个线程在外层方法获取锁的时候在进入内层方法会自动获取该锁。
		 *  关于锁的几个重要的地方：
		 *    1.当线程拥有可重入锁后可访问所有同类型被加锁的代码块，优点是避免死锁情况。
		 *    2.一个代码块是可以被多个加锁的，但是加锁之后解锁要匹配，否则会出现资源占用无法结束的情况。
		 *    3.非公平锁提高了锁的使用效率，避免了资源浪费
		 *  ReentrantLock 默认使用非公平锁
		 *
		 *
 		 */


//		Lock lock = new ReentrantLock();
		Phone phone = new Phone();
		new Thread (()->{
			try {
				phone.sendTest();
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"a").start();
		new Thread (()->{
			try {
				phone.sendTest();
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"t2").start();
	}
}
