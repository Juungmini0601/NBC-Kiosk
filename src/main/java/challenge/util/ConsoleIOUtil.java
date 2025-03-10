package challenge.util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import challenge.menu.Menu;
import challenge.menu.MenuItem;

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

		System.out.println("0. 종료");
	}

	// 키오스크 종료 메세지
	public static void printKioskExitMessage() {
		System.out.println("프로그램을 종료합니다.");
	}

	// 메뉴 선택(ex 햄버거, 드링크) 종료 메세지
	public static void printSelectMenuExitMessage(String category) {
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
	}

	// 메인 메뉴 선택
	public static int inputMainMenuCommand(List<Menu> menus) {
		System.out.print("숫자 입력: ");
		try {
			int command = sc.nextInt();

			// 이상한 정수값 입력 되는 경우
			if (command < 0 || command > menus.size()) {
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
	public static int inputMenu(Menu menu) {
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
}
