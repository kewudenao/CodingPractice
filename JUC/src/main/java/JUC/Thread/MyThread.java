package JUC.Thread;

import java.util.concurrent.Callable;

/**
 * @author zhujinman 2022-07-18 14:27
 **/
public class MyThread implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println("----come in call()");
		return "hello";
	}
}
