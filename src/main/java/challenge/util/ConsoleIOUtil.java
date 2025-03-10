package challenge.util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import challenge.cart.Cart;
import challenge.cart.CartConstant;
import challenge.menu.Menu;
import challenge.menu.MenuItem;
import challenge.order.OrderConstant;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 *
 * 콘솔 메뉴 입력 출력을 담당하는 유틸 클래스
 */
public final class ConsoleIOUtil {

	private static final Scanner sc = new Scanner(System.in);

	private ConsoleIOUtil() {}

	public static void showMainMenus(List<Menu> menus) {
		System.out.println("[ MAIN MENU ]");

		for(int i = 0; i < menus.size(); i++) {
			System.out.println((i + 1) + ". " + menus.get(i).getCategory());
		}

		System.out.println("0. 종료\n");

		System.out.println("[ ORDER MENU ]");
		System.out.println("4. Orders");
		System.out.println("5. Cancel");
		// 입력 구분 편하게 하기 위해 줄바꿈
		System.out.println();
	}

	// 키오스크 종료 메세지
	public static void printKioskExitMessage() {
		System.out.println("프로그램을 종료합니다.");
	}

	// 메뉴 선택(ex 햄버거, 드링크) 종료 메세지
	public static void printSelectMenuItemExitMessage(String category) {
		System.out.println(category + "선택을 종료합니다.\n");
	}

	// 선택된 메뉴 출력 메시지
	public static void printSelectedMenu(MenuItem menu) {
		System.out.println("선택한 메뉴:" + menu + "\n");
	}

	// 메뉴 목록 출력
	public static void showMenus(Menu menu) {
		String title = String.format("[ %s MENU ]", menu.getCategory());
		System.out.println(title);

		for(int i = 0; i < menu.size(); i++) {
			System.out.println((i + 1) + ". " + menu.get(i));
		}

		System.out.println("0. 뒤로가기");
		// 입력 구분 편하게 하기 위해서 줄바꿈
		System.out.println();
	}

	// 메인 메뉴 선택
	public static int inputMainMenuCommand(List<Menu> menus) {
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
			throw e;
		}
	}

	// 카테고리에 해당하는 메뉴 선택(ex 햄버거1, 햄버거2, 햄버거3)
	public static int inputMenuItemCommand(Menu menu) {
		System.out.print("숫자 입력: ");
		try {
			int command = sc.nextInt();

			// 이상한 정수 값 입력 되는 경우
			if (command < 0 || command > menu.size()) {
				throw new InputMismatchException("올바른 명령어를 입력 해주세요");
			}

			return command;
		} catch (InputMismatchException e) {
			// 버퍼 비우기용 코드
			sc.nextLine();
			throw e;
		}
	}

	// 예외 메세지 출력
	public static void printErrorMessage(Exception e) {
		if (e instanceof InputMismatchException) {
			System.out.println("올바른 명령어를 입력 해주세요!\n");
		} else {
			System.out.println("예상하지 못한 예외가 발생 했습니다.");
			e.printStackTrace();
		}
	}

	// 카트에 넣을지 유무 메세지 확인 추가
	public static void confirmAddCartMessage() {
		System.out.println("위 메뉴를 장바구니에 추가 하시겠습니까?");
		System.out.println("1.확인 	2.취소");
	}

	// 카트에 넣을지 말지를 입력 받는 함수
	public static int inputAddCartCommand() {
		System.out.print("숫자 입력: ");
		try {
			int command = sc.nextInt();

			// 이상한 정수 값 입력 되는 경우
			if (command != CartConstant.ADD_CART && command != CartConstant.NOT_ADD_CART) {
				throw new InputMismatchException("올바른 명령어를 입력 해주세요");
			}

			return command;
		} catch (InputMismatchException e) {
			// 버퍼 비우기용 코드
			sc.nextLine();
			throw e;
		}
	}

	public static void successAddCartMessage(MenuItem menuItem) {
		System.out.println(menuItem.getName() +"이 장바구니에 추가 되었습니다.");
	}

	// 카트에 있는 모든 아이템 출력
	public static void showCartStatus(Cart cart) {
		System.out.println("아래와 같이 주문 하겠습니까?\n");
		System.out.println(cart);
		System.out.println();

		System.out.println("1.주문	2.메뉴판");
	}

	// 주문 관련 명령어 입력 받는 함수
	public static int inputOrderCommand() {
		System.out.print("숫자 입력: ");
		try {
			int command = sc.nextInt();

			// 이상한 정수 값 입력 되는 경우
			if (command != OrderConstant.ORDER && command != OrderConstant.NOT_ORDER) {
				throw new InputMismatchException("올바른 명령어를 입력 해주세요");
			}

			return command;
		} catch (InputMismatchException e) {
			// 버퍼 비우기용 코드
			sc.nextLine();
			throw e;
		}
	}

	// 주문 취소 메뉴가 선택 되었을 때 메세지
	public static void printCancelOrderMessage() {
		System.out.println("주문이 취소 되었습니다.");
		System.out.println("장바구니를 비웁니다.\n");
	}
}
