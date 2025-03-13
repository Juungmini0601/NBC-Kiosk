package challenge.level2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import challenge.level2.command.Command;
import challenge.level2.command.MainMenuCommandFactory;
import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.menu.Menu;
import challenge.level2.util.ScannerHolder;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see Kiosk 키오스크 프로세스 관리
 * @see Cart 장바구니 표현용 클래스
 * @see Menu MenuItem을 담고 있는 클래스
 * @see challenge.level2.domain.discount.DisCountType 할인정보를 담고 있는 클래스
 * @see challenge.level2.domain.order.Order DiscountType, Cart를 포함한 최종 주문 정보를 담고 있는 클래스
 * @see MainMenuCommandFactory Command(프로그램 종료, 메뉴 선택, 주문 등등)를 담고 있는 클래스
 * @see Command 각 명령을 추상화한 인터페이스
 */
public class Kiosk {
	private final List<Menu> menus;
	private final Cart cart;
	private final MainMenuCommandFactory mainMenuCommandFactory;

	public Kiosk(List<Menu> menus) {
		this.menus = menus;
		cart = new Cart();
		mainMenuCommandFactory = new MainMenuCommandFactory(menus, cart);
	}

	public void start() {
		while (true) {
			Printer.showMainMenus(menus);
			int mainMenuCode = Reader.inputMainMenuCode(menus);

			Command command = mainMenuCommandFactory.getCommandFrom(mainMenuCode);
			command.execute();
		}
	}

	private static class Reader {

		private static final Scanner sc = ScannerHolder.sc;

		public static int inputMainMenuCode(List<Menu> menus) {
			while (true) {
				System.out.print("숫자 입력: ");
				try {
					int command = sc.nextInt();

					// 이상한 정수값 입력 되는 경우
					if (command < 0 || command > menus.size() + 2) {
						throw new InputMismatchException("올바른 명령어를 입력 해주세요");
					}

					return command;
				} catch (InputMismatchException e) {
					// 버퍼 비우기용 코드
					sc.nextLine();
					Printer.printErrorMessage(e);
					// 잘못 입력하면 메뉴를 다시 보여줌
					Printer.showMainMenus(menus);
				}
			}
		}
	}

	private static class Printer {
		public static void showMainMenus(List<Menu> menus) {
			System.out.println("[ MAIN MENU ]");

			for (int i = 0; i < menus.size(); i++) {
				System.out.println((i + 1) + ". " + menus.get(i).getCategory());
			}

			System.out.println("0. 종료\n");

			System.out.println("[ ORDER MENU ]");
			System.out.printf("%d. Orders\n", (menus.size() + 1));
			System.out.printf("%d. Cancel\n", (menus.size() + 2));
			// 입력 구분 편하게 하기 위해 줄바꿈
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
	}
}
