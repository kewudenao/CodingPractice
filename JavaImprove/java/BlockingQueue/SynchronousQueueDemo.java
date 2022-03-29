package BlockingQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 单个元素的阻塞队列，可以用于控制一些信息同时只能被一个线程占用的场景。
 *
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {

        SynchronousQueue synchronousQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                synchronousQueue.put("A");
                System.out.println(Thread.currentThread().getName()+"\t A进入队列");

                System.out.println(Thread.currentThread().getName()+"\t B进入队列");
                synchronousQueue.put("B");

                synchronousQueue.put("C");
                System.out.println(Thread.currentThread().getName()+"\t C进入队列");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A Thread").start();

        new Thread(()->{
            try {
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t A出队列");
                TimeUnit.SECONDS.sleep(3);
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t B出队列");
                TimeUnit.SECONDS.sleep(3);
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t C出队列");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B Thread").start();
    }
}
