package collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author kewudenao 2022-03-23 14:19
 * HashSet 底层是HashMap add的形式是将value设置为一个常量值
 * public boolean add(E e) {
 *         return map.put(e, PRESENT)==null;
 *     }
 * 是线程不安全的，因为在add过程中并没有给元素加锁
 **/
public class UnsafeDemoForSet {
	public static void main(String[] args) {
		Set<String> list = new HashSet();
		Thread thread = new Thread(()->{
			list.add(UUID.randomUUID().toString().substring(0,8));
		});

		/**
		 * 解决方法 使用CopyOnWriteSet
		 *  new CopyOnWriteArrayList<E>(),实际上底层创建的还是CopyOnWriteArrayList
		 *  但是CopyOnWriteArrayList，在加入元素的时候会有一个校验的逻辑，
			 *  private static int indexOf(Object o, Object[] elements,
			 *                                int index, int fence) {
			 *         if (o == null) {
			 *             for (int i = index; i < fence; i++)
			 *                 if (elements[i] == null)
			 *                     return i;
			 *         } else {
			 *             for (int i = index; i < fence; i++)
			 *                 if (o.equals(elements[i]))
			 *                     return i;
			 *         }
			 *         return -1;
			 *     }
		 *  因为set特点：保证元素的唯一性
 		 */

		CopyOnWriteArraySet set = new CopyOnWriteArraySet();

	}
}
