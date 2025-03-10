package challenge.level1.menu;

import java.util.List;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * TODO HashMap 구조가 더 효율적으로 보임
 */
public class Menu {
	private String category;
	private List<MenuItem> menuItems;

	public Menu(String category, List<MenuItem> menuItems) {
		this.category = category;
		this.menuItems = menuItems;
	}

	public String getCategory() {
		return category;
	}

	public int size() {
		return menuItems.size();
	}

	public MenuItem get(int index) {
		return menuItems.get(index);
	}
}
