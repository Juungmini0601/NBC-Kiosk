package challenge.level2.domain.menu;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * Burger, Drinks, Dessert가 표현하는 정보가 동일하므로 이 이상의 추상화는 진행하지 않는다.
 * 변경 가능성이 있다면 추상 클래스로 변경 후 확장
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
