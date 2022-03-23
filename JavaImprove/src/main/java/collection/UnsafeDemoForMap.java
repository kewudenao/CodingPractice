package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kewudenao 2022-03-23 14:33
 **/
public class UnsafeDemoForMap {
	/**
	 *  Map 是线程不安全的类，解决办法是使用ConcurrentHashMap
	 *  ConcurrentHashMap 是基于AbstractMap的类 大致内容与HashMap一致
	 *  但对一些关键的变量添加了transient关键字保证了变量的可见性
	 *  如何保证原子性？
	 *  transient 的缺点是无法保证原子性 可能会出现aba问题 ，但是这一点在HashMap中是被允许的
	 *  原因：HashMap的特点就是元素的唯一性 ，即结果是幂等的，无需额外加锁。
	 */

}
