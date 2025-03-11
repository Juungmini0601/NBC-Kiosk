package challenge.level2.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import challenge.level2.cart.Cart;
import challenge.level2.menu.Menu;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 */
public class MainMenuCommandFactory {
	private final Map<Integer, Command> mainManuCommand;

	public MainMenuCommandFactory(List<Menu> menus, Cart cart) {
		mainManuCommand = new HashMap<>();
		// 종료 Command
		mainManuCommand.put(0, new MainMenuExitCommand());
		// Select MenuItem Command
		for (int i = 0; i < menus.size(); i++) {
			mainManuCommand.put(i + 1, new SelectMenuItemCommand(menus.get(i), cart));
		}
		// Order Command
		mainManuCommand.put(menus.size() + 1, new OrderCommand(cart));
		// Order Cancel Command
		mainManuCommand.put(menus.size() + 2, new OrderCancelCommand(cart));
	}

	public Command getCommandFrom(int code) {
		return mainManuCommand.get(code);
	}
}
