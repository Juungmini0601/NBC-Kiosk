package basic.level5;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
public class MenuItem {
	private final String name;
	private final double price;
	private final String description;

	public MenuItem(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	// 메뉴를 출력할때 출력할 값을 만들기 위한 함수
	@Override
	public String toString() {
		return String.format("%s | W %s | %s", name, price, description);
	}
}
