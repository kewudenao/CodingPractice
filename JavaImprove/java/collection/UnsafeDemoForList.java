package collection;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author kewudenao 2022-03-22 17:30
 **/
public class UnsafeDemoForList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> list2 = new CopyOnWriteArrayList<>();
		//list.forEach(System.out::println);
		Integer in3 = new Integer(123123);
		for(int i = 0; i <= 30 ;i++){
		    new Thread(() -> {
		 		list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
		    },String.valueOf(i)).start();

		}
		/** 1.故障现象 ：java.util.ConcurrentModificationException
		 *
		 *  2.导致原因
		 *  	线程不安全的原因 public boolean add(E e) 未加锁
		 *		多个线程同时修改list导致数据不一致问题
		 *  3.解决方案
		 *		Vector 线程安全，原因是使用了synchronize关键字进行加锁，缺点是会损失性能
		 *		Collections.synchronizedList(new Arraylist());
		 *		CopyOnWriteList 写时复制，在向有 volatile 修饰符的object数组添加元素时：
		 *		1.加锁
		 *		2.新数组中 ，拷贝原数组的内容，并将原数组的长度加1
		 *		3.将添加的内容放入新的数组
		 *	    4.将旧数组替换为新数组
		 *	    5.解锁
		 *  4.优化建议
		 *
		 */

	}
}
