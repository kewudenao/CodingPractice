package Lock.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhujinman 2022-08-05 17:09
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
	private String name;
	private String phoneNumber;

	public static synchronized void sendEmail(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("send email");
	}

	public synchronized void sendMessage(){
		System.out.println("send Massage");
	}

	public void hello(){
		System.out.println("-------hello");
	}
}
