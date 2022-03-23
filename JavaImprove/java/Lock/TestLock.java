package Lock;

/**
 * @author kewudenao 2022-03-23 19:15
 **/
public class TestLock {
	public synchronized void methodOne(){
		System.out.println(Thread.currentThread().getId()+"asdfadf");
	}
}
