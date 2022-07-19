package Factory.SimpleFactory.Menu;

/**
 * @author zhujinman 2022-07-14 23:16
 **/
public class ChinaPizza extends Pizza{
	@Override
	public void prepare() {
		System.out.println("ChinaPizza is preparing");
	}

	@Override
	public void baking() {
		System.out.println("ChinaPizza is baking");
	}

	@Override
	public void cutting() {
		System.out.println("ChinaPizza is cutting");
	}
}
