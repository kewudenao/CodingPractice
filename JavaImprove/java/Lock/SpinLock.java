package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 *  自旋锁
 *  获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少上下文切换消耗，缺点是会消耗cpu
 *  比较常见的自旋锁CAS AtomicInteger
 *
 */
// 如何手写一个自旋锁？
public class SpinLock {
    AtomicReference<Thread> lock = new AtomicReference<>();

    public void spinLockDemo(){
        while (!lock.compareAndSet(null,Thread.currentThread()));
    }

    public void spinunLockDemo(){
        while (!lock.compareAndSet(Thread.currentThread(),null));
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.spinLockDemo();
            System.out.println("线程1正在执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.spinunLockDemo();
            System.out.println("线程1执行结束");
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            spinLock.spinLockDemo();
            System.out.println("线程2正在执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.spinunLockDemo();
            System.out.println("线程2执行结束");
        }).start();

    }
}
