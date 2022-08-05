package JUC;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujinman 2022-07-26 22:25
 **/
public class CompletableFutureMallConcurrentDemo {

}

class NetMall2{

	@Getter
	private String netMallName;

	public NetMall2(String netMallName) {
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
