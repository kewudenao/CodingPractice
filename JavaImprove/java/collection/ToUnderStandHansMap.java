package collection;

/**
 * @author kewudenao 2022-04-17 16:10
 **/
public class ToUnderStandHansMap {
	/**
	 * JDK 7 在实例化后 底层创建了长度是16的一维数组Entry[] table
	 * 首先调用key1所在类的HashCode()计算key1的哈希值，此哈希值经过某种算法计算以后，
	 * 得到在Entry数组中的存放位置。
	 * 如果此位置上的数据为空，此时key1-value1添加成功，
	 * 如果此位置上的数据不为空，意味着此位置上存在一个或多个数据(以链表的形式存在)),
	 * 比较key1和以及存在的一个或多个数据的哈希值：
	 *      如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功
	 *      如果key1的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同，继续比较，
	 *      调用key1所在类的equals(key2)
	 *          如果equals()返回false 此时key1-value1添加成功
	 *          如果equals()返回true 使用value1替换value2
	 *  1.数据的存储问题 ：在JDK7中 数据以数组+链表的形式存储
	 *  2.扩容问题：扩容为原来容量的两倍，并将原来的数据复制过来
	 *
	 *  JDK8与JDK7的区别：
	 *      1.底层没有默认创建一个长度为16的数组
	 *      2.jdk8底层是Node[] jdk7是Entry[]
	 *      3.jdk 底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
	 *          当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8且当前数组的长度>64时，
	 *          此时索引位置上的所有数据改为使用红黑树存储。
	 */
}
