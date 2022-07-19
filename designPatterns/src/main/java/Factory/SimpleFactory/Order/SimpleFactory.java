package Factory.SimpleFactory.Order;

import Factory.SimpleFactory.Menu.ChessPizza;
import Factory.SimpleFactory.Menu.Pizza;

/**
 * @author zhujinman 2022-07-14 23:17
 **/
public  class SimpleFactory {
	static final SimpleFactory simpleFactory = new SimpleFactory();
	public static Pizza getPizza(String type){
		return simpleFactory.createPizza(type);
	}

	private Pizza createPizza(String type){
		// 直接从数据库查
		return new ChessPizza();
	}
}
