package challenge.level2.domain.menu;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see Menu
 * Menu에 해당하는 단일 요소 ex)버거 Menu -> 데리버거, 새우버거
 * 이름, 가격, 설명 포함
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

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	// 메뉴를 출력할때 출력할 값을 만들기 위한 함수
	@Override
	public String toString() {
		return String.format("%s | W %s | %s", name, price, description);
	}
}
