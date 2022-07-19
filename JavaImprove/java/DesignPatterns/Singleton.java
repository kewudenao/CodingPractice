package DesignPatterns;

/**
 * @author zhujinman 2022-06-05 18:52
 **/
public class Singleton {
	private volatile static Singleton singleton;

	public Singleton() {
	}

	public static Singleton getSingleton(){
		if (singleton==null){
			synchronized (Singleton.class){
				if (singleton==null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
