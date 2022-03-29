package Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kewudenao 2022-03-27 14:20
 * 读写锁
 *  读写锁主要是为了解决可冲入锁在大量读的情况下性能相对较低的问题
 *      读-读共享
 *      读-写互斥
 *      写-写互斥
 *     主要用到JUC中的ReentrantReadWriteLock 可重入读写锁
 *     其中用readlock 和writelock来分别控制读写
 **/
class Resources{
	private volatile Map<String,Object> map  = new HashMap<>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void put(String key,Object value){
		lock.writeLock().lock();
		System.out.println(Thread.currentThread().getName()+"\t 写入"+key);
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			map.put(key,value);
			System.out.println(Thread.currentThread().getName()+"\t 写入完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}


	}

	public void get(String key,Object value){
		lock.writeLock().lock();

		try {
			System.out.println(Thread.currentThread().getName()+"\t 读取"+key);
			TimeUnit.MILLISECONDS.sleep(300);
			Object o = map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t 读取结束"+o);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}

	}
}
public class readAndWriteLock {


	public static void main(String[] args) {
		Resources resources = new Resources();
		for (int i = 0; i <5 ; i++) {
			int finalI = i;
			new Thread(()->{
				resources.put(String.valueOf(finalI), finalI);
			},String.valueOf(i)).start();
		}

		for (int i = 0; i <5 ; i++) {
			int finalI = i;
			new Thread(()->{
				resources.get(String.valueOf(finalI), finalI);
			},String.valueOf(i)).start();
		}
	}
}
