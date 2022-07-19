package Singleton;

/**
 * @author zhujinman 2022-07-13 22:57
 **/
//饿汉式
public class HungryModeSingleton {
	private final static HungryModeSingleton  instance = new HungryModeSingleton();

	private HungryModeSingleton() {
	}

	public static HungryModeSingleton getInstance(){
		return instance;
	}
}
//饿汉静态代码块模式
class HungryModeStaticSingleton{
	private HungryModeStaticSingleton() {
	}
	private static HungryModeStaticSingleton  instance;

	static {
		instance = new HungryModeStaticSingleton();
	}
	public static HungryModeStaticSingleton getInstance(){
		return instance;
	}
}
// 不使用会造成内存浪费