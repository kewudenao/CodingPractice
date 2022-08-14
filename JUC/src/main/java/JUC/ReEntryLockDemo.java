package JUC;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhujinman 2022-08-14 23:17
 * 可重入代码块/可重入方法
 **/

public class ReEntryLockDemo {
	/**
	 * 可重入代码块
	 */
	@Test
	public void reEntryLockDemo(){
		final Object object = new Object();

		new Thread(()->{
			synchronized (object){
				System.out.println(Thread.currentThread().getName()+"\t 外层调用");
				synchronized (object){
					System.out.println(Thread.currentThread().getName()+"\t 中层调用");
					synchronized (object){
						System.out.println(Thread.currentThread().getName()+"\t 内层调用");
					}
				}
			}
		},"t1").start();
	}

	/**
	 * 同步方法
	 */
	@Test
	public void reEntryLockDemo2(){
		ReEntryLockDemo reEntryLockDemo = new ReEntryLockDemo();

		new Thread(()->{
			reEntryLockDemo.m1();
		},"t1").start();
	}

	public synchronized void m1(){
		System.out.println(Thread.currentThread().getName()+"1");
		m2();
		System.out.println(Thread.currentThread().getName()+"4");
	}
	public synchronized void m2(){
		System.out.println(Thread.currentThread().getName()+"2");
		m3();
	}
	public synchronized void m3(){
		System.out.println(Thread.currentThread().getName()+"3");
	}
}
