package Singleton;

/**
 * @author zhujinman 2022-07-13 23:26
 **/

public class InsideStaticClassSingleton {
	public static void main(String[]args){
		InsideStaticClassSingleton in1 = InsideStaticClassSingleton.getInstance();
		InsideStaticClassSingleton in2 = InsideStaticClassSingleton.getInstance();
		System.out.println(in1.hashCode());
		System.out.println(in2.hashCode());
	}

	private InsideStaticClassSingleton() {
	}


	private static class Singleton{
		private static final InsideStaticClassSingleton INSTANCE = new InsideStaticClassSingleton();
	}

	public static InsideStaticClassSingleton getInstance(){
		return Singleton.INSTANCE;
	}
}
