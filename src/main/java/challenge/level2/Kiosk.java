package challenge.level2;

import static challenge.level2.menu.MainMenuConstant.*;
import static challenge.level2.menu.SelectMenuItemConstant.*;
import static challenge.level2.util.ConsoleIOUtil.*;

import java.util.List;

import challenge.level2.cart.Cart;
import challenge.level2.cart.CartConstant;
import challenge.level2.menu.Menu;
import challenge.level2.menu.MenuItem;
import challenge.level2.order.OrderConstant;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see Kiosk 키오스크 프로세스 관리
 * 	1. 메인 메뉴 표시(메뉴에 있는 음식들 카테고리 출력)
 * 	2. 메뉴 아이템 선택(카테고리 메뉴에 해당하는 음식 선택 가능)
 *
 * @see Cart 장바구니 표현용 클래스
 *
 * @see challenge.level2.util.ConsoleIOUtil 입출력 관련 유틸 클래스
 */
public class Kiosk {
	private final List<Menu> menus;
	private final Cart cart;

	public Kiosk(List<Menu> menus) {
		this.menus = menus;
		cart = new Cart();
	}

	/**
	 * 키오스크 프로그램의 시작 메소드 초기 메뉴 출력
	 * @see #selectMenuItem(Menu) 음식 선택 메뉴로 이동 할 시 수행되는 메소드
	 * @see challenge.level2.util.ConsoleIOUtil 입출력 관련 유틸 클래스(입력 예외는 Kiosk로 Throwing)
	 */
	public void start() {
		while (true) {
			showMainMenus(menus);
			int mainMenuCommand = inputMainMenuCommand(menus);

			// 종료가 선택되면 프로그램을 종료한다.
			if (mainMenuCommand == MAIN_MENU_EXIT) {
				printKioskExitMessage();
				return;
			}

			// 주문이 선택되면 주문 프로세스로 이동한다.
			if (mainMenuCommand == ORDER) {
				order();
				continue;
			}

			// 주문이 취소되면 장바구니를 비운다.
			if (mainMenuCommand == ORDER_CANCEL) {
				cart.clearCart();
				printCancelOrderMessage();
				continue;
			}

			Menu menu = menus.get(mainMenuCommand - 1);
			selectMenuItem(menu);
		}
	}

	/**
	 * @param menu 선택된 메뉴에 대한 단일 item 선택 프로세스
	 */
	private void selectMenuItem(Menu menu) {
		while (true) {
			showMenuItems(menu);
			int selectedMenu = inputMenuItemCommand(menu);
			// Menu Item 선택 종료가 눌리면 선택을 종료하고 다시 메인 메뉴 프로세스 선택 프로세스로 이동
			if (selectedMenu == SELECT_MENU_EXIT) {
				printSelectMenuItemExitMessage(menu.getCategory());
				return;
			}

			MenuItem selectedItem = menu.get(selectedMenu - 1);

			printSelectedMenu(selectedItem);

			// 카트 관련 기능 추가
			confirmAddCartMessage();
			int addCartCommand = inputAddCartCommand();
			// 카트에 상품을 넣는다.
			if (addCartCommand == CartConstant.ADD_CART) {
				cart.addMenuItem(selectedItem);
				successAddCartMessage(selectedItem);
			}
		}
	}

	// 주문 프로세스 처리용 코드
	private void order() {
		showCartStatus(cart);
		int orderCommand = inputOrderCommand();

		if (orderCommand == OrderConstant.ORDER) {
			System.out.println("주문이 완료 되었습니다.");
			double totalValue = cart.getTotalPrice();
			System.out.printf("금액은 W %s 입니다.\n", totalValue);
		}
	}
}
