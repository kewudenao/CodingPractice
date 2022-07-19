package Factory.SimpleFactory.Menu;

/**
 * @author zhujinman 2022-07-14 23:15
 **/
public class ChessPizza extends Pizza{
	@Override
	public void prepare() {
		System.out.println("ChessPizza is preparing");
	}

	@Override
	public void baking() {
		System.out.println("ChessPizza is baking");
	}

	@Override
	public void cutting() {
		System.out.println("ChessPizza is cutting");
	}
}
