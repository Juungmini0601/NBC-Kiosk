package challenge.level2.command;

import java.util.InputMismatchException;
import java.util.Scanner;

import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.menu.Menu;
import challenge.level2.domain.menu.MenuItem;
import challenge.level2.util.ScannerHolder;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 *
 * @see Command 구현체
 * 선택된 메뉴에 대한 단일 item 선택 프로세스
 */
public class SelectMenuItemCommand implements Command {
	private static final Integer EXIT_CODE = 0;
	private static final Integer ADD_CART = 1;
	private static final Integer NOT_ADD_CART = 2;
	private final Menu menu;
	private final Cart cart;

	public SelectMenuItemCommand(Menu menu, Cart cart) {
		this.menu = menu;
		this.cart = cart;
	}

	@Override
	public void execute() {
		while (true) {
			Printer.showMenuItems(menu);
			int menuItemCode = Reader.inputMenuItemCode(menu);
			// 나가기를 선택할 경우 진행하지 않는다.
			if (menuItemCode == EXIT_CODE) {
				Printer.printSelectMenuItemExitMessage(menu.getCategory());
				return;
			}
			// 메뉴를 고른 경우 메뉴 정보를 보여준다.
			MenuItem menuItem = menu.get(menuItemCode - 1);
			Printer.printSelectedMenu(menuItem);

			// 카트에 넣을지 확인한다.
			Printer.confirmAddCartMessage();
			int addCartCode = Reader.inputAddCartCode();

			// 카트에 넣는다고 하면 카트에 넣어준다.
			if (addCartCode == ADD_CART) {
				cart.addMenuItem(menuItem);
				Printer.successAddCartMessage(menuItem);
			}
		}
	}

	private static class Printer {

		public static void successAddCartMessage(MenuItem menuItem) {
			System.out.println(menuItem.getName() + "이 장바구니에 추가 되었습니다.");
		}

		public static void confirmAddCartMessage() {
			System.out.println("위 메뉴를 장바구니에 추가 하시겠습니까?");
			System.out.println("1.확인 	2.취소");
		}

		public static void printSelectedMenu(MenuItem menuItem) {
			System.out.println("선택한 메뉴:" + menuItem + "\n");
		}

		public static void showMenuItems(Menu menu) {
			String title = String.format("[ %s MENU ]", menu.getCategory());
			System.out.println(title);

			for (int i = 0; i < menu.size(); i++) {
				System.out.println((i + 1) + ". " + menu.get(i));
			}

			System.out.println("0. 뒤로가기");
			// 입력 구분 편하게 하기 위해서 줄바꿈
			System.out.println();
		}

		public static void printErrorMessage(Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("올바른 명령어를 입력 해주세요!\n");
			} else {
				System.out.println("예상하지 못한 예외가 발생 했습니다.");
				e.printStackTrace();
			}
		}

		public static void printSelectMenuItemExitMessage(String category) {
			System.out.println(category + "선택을 종료합니다.\n");
		}
	}

	private static class Reader {

		private static final Scanner sc = ScannerHolder.sc;

		public static int inputMenuItemCode(Menu menu) {
			while (true) {
				System.out.print("숫자 입력: ");
				try {
					int code = sc.nextInt();

					// 이상한 정수 값 입력 되는 경우 TODO Input 받는 코드에서 Menu 관련 로직을 알 필요가 있는 건지?
					if (code < 0 || code > menu.size()) {
						throw new InputMismatchException("올바른 명령어를 입력 해주세요");
					}

					return code;
				} catch (InputMismatchException e) {
					// 버퍼 비우기용 코드
					sc.nextLine();
					Printer.printErrorMessage(e);

					// 잘못 입력하면 메뉴를 다시 보여줌
					Printer.showMenuItems(menu);
				}
			}
		}

		public static int inputAddCartCode() {
			while (true) {
				System.out.print("숫자 입력: ");
				try {
					int code = sc.nextInt();

					// 이상한 정수 값 입력 되는 경우
					if (code != ADD_CART && code != NOT_ADD_CART) {
						throw new InputMismatchException("올바른 명령어를 입력 해주세요");
					}

					return code;
				} catch (InputMismatchException e) {
					// 버퍼 비우기용 코드
					sc.nextLine();
					Printer.printErrorMessage(e);
				}
			}

		}
	}
}
