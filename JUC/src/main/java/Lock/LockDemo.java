package Lock;

import Lock.Entity.Phone;

/**
 * @author zhujinman 2022-08-05 17:06
 **/

/**
 * 添加锁的八种情况
 * 1.标准访问有ab两个线程，先打印邮件还是短信？          对象锁被占用后，对象的其他被加锁的方法无法被同时访问
 * 2.sendEmail方法中加入暂停三秒钟，先打印邮件还是短信？
 * 3.添加一个普通的hello方法，先打印邮件还是hello？ 先打印hello 普通方法不受对象锁影响
 * 4.有两部手机，先打印邮件还是短信？     随机（锁是基于对象的）
 * 5.有两个静态同步方法，有一部手机，请问先打印邮件还是短信 静态同步方法是基于类的，使用类的静态同步方法，基于该类的
 * 6.有两个静态同步方法，有两部手机，请问先打印邮件还是短信
 * 7.有一个静态同步方法，有一个普通同步方法，有一部手机，请问先打印邮件还是短信   类锁和对象锁是不同的两个不会相互影响
 * 8.有一个静态同步方法，有一个普通同步方法，有两部手机，请问先打印邮件还是短信
 */
public class LockDemo {

	public static void main(String[] args) {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
	new Thread(()->{
		phone1.sendEmail();
	},"a").start();
	new Thread(()->{
		phone1.sendMessage();
	},"b").start();
	}
}

