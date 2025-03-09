package basic.level2;

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

	@Override
	public String toString() {
		return String.format("%s | W %f | %s", name, price, description);
	}
}
