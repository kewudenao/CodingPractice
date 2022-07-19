package Singleton;
//枚举实现单例模式
enum EnumSingleton {
	INSTANCE,
	INSTANCE2;
	public static void say(){
		System.out.println("say hi");
	}

	public static void main(String[] args) {
		EnumSingleton instance = EnumSingleton.INSTANCE;
		EnumSingleton instance3 = EnumSingleton.INSTANCE;
		EnumSingleton instance2 = EnumSingleton.INSTANCE2;
		System.out.println(instance.hashCode());
		System.out.println(instance3.hashCode());
		System.out.println(instance2.hashCode());
	}
}

