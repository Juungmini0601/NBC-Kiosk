package challenge.level2.domain.menu;

import java.util.List;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see MenuItem 을 원소로 가지는 배열
 * 카테고리에 해당하는 메뉴를 가지고 있음
 */
public class Menu {
	private final String category;
	private final List<MenuItem> menuItems;

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
