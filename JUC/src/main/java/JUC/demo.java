package JUC;

/**
 * @author zhujinman 2022-07-28 16:33
 **/
public class demo {
	public static void main(String[] args) {
		String a = "100001,100012,100033";
		String[] split = a.split(",");
		for (String s : split) {
			System.out.println(s);
		}
	}
}
