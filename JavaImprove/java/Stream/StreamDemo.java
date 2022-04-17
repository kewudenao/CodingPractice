package Stream;

import Stream.util.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kewudenao 2022-04-16 16:02
 **/
// java Stream流的几种用法
public class StreamDemo {
	void StreamApi(){
		List<Employee> list = new ArrayList<>();

		// 过滤 返回过滤器中状态为true的元素
		list.stream().filter(e->e.getAge()>50).forEach(System.out::println);
		// 截断 获取list中前三个元素
		list.stream().limit(3).forEach(System.out::println);
		// 跳过n个数据
		list.stream().skip(3).forEach(System.out::println);
		// 去重  用hashCode 和equals去重
		list.stream().distinct().forEach(System.out::println);
		// map(Function f) 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素
		List<Long> collect = list.stream().map(o -> o.getId()).collect(Collectors.toList());
		//flagMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有的流连接整一个流

		Stream<Character> characterStream = list.stream().map(o -> o.getName()).flatMap(StreamDemo::demoMethod);
		// 排序  sorted  按自然顺序排序
		list.stream().sorted().forEach(System.out::println);
		// 按照指定方式进行排序
		list.stream().sorted(Comparator.comparingInt(e -> e.getAge().intValue())
				).forEach(o->o.getAge());
		// allMatch 所有的员工年龄大于20 返回一个布尔值   匹配与查找
		boolean b = list.stream().allMatch(employee -> employee.getAge() > 20);
		// anyMatch 是否存在员工工资大于1 返回一个布尔值
		boolean c = list.stream().anyMatch(employee -> employee.getAge() > 20);
		// noneMatch 是否没有匹配的元素  是 则返回true 否返回fals
		list.stream().noneMatch(employee -> employee.getAge()<1);

		Optional<Employee> first = list.stream().findFirst();

		Optional<Employee> any = list.stream().findAny();
		//计算流中元素的个数
		long count = list.stream().count();

		//reduce 将流中元素反复结合起来得到一个值
		list.stream().map(Employee::getAge).reduce(0,Integer::sum);

		// reduce(BinaryOperator) 规约操作 将map中的值计算后得到一个值的结果
		list.stream().map(Employee::getAge).reduce((d1,d2)->d1-d2);

		list.stream().map(Employee::getAge).collect(Collectors.toList());
	}


	public static Stream<Character> demoMethod(String str){
		ArrayList<Character> list = new ArrayList<>();
		for (Character c : str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}
}
