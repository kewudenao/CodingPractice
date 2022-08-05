package JUC;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author zhujinman 2022-07-26 21:48
 **/
public class CompletableFutureMallDemo {
	static List<NetMall> list = Arrays.asList(
			new NetMall("jd"),
			new NetMall("dangdang"),
			new NetMall("TM")
	);

	public static List<String> getPrice(List<NetMall> list,String productName){
		return list.stream().map(o->String.format(productName+"in %s price is %.2f",o,o.calcPrice(productName)))
				.collect(Collectors.toList());
	}

	public static List<String> getPriceConcurrent(List<NetMall> list, String productName){

		return list.stream()
				.map(o-> CompletableFuture.supplyAsync(()->String.format(productName+"in %s price is %.2f",o,o.calcPrice(productName))))
				.collect(Collectors.toList())
				.stream().map(o->o.join()).collect(Collectors.toList());
	}
	public static void main(String[] args) {

		Long startTime = System.currentTimeMillis();

		List<String> mysql = getPriceConcurrent(list, "mysql");
		mysql.forEach(o->
						System.out.println(o)
				);
		Long endTime = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("耗时 ："+(endTime-startTime));
	}
}

class NetMall{

	@Getter
	private String netMallName;

	public NetMall(String netMallName) {
		this.netMallName = netMallName;
	}

	public String getNetMallName() {
		return netMallName;
	}

	public void setNetMallName(String netMallName) {
		this.netMallName = netMallName;
	}

	public double calcPrice(String productName){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ThreadLocalRandom.current().nextDouble()*2+productName.charAt(0);	}
}
