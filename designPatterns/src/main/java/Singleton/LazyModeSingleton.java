package Singleton;

/**
 * @author zhujinman 2022-07-13 23:07
 **/
// 线程不安全
public class LazyModeSingleton {
	private static LazyModeSingleton instance;

	private LazyModeSingleton() {
	}
/**
 *  不安全 unsafe
	public static LazyModeSingleton getInstance(){
		if (instance==null){
			instance = new LazyModeSingleton();
		}
		return instance;
	}
	效率低
	public static synchronized LazyModeSingleton getInstance(){
		if (instance == null){
			instance = new LazyModeSingleton();
		}
		return instance;
	}
 */
//保证了线程安全
	public static  LazyModeSingleton getInstance(){
		if (instance == null){
			synchronized (LazyModeSingleton.class){
				if (instance == null){
					instance = new LazyModeSingleton();
				}
			}
		}
		return instance;
	}
}
