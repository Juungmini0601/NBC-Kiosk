package basic.level4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * Kiosk 클래스: 프로그램의 메뉴 관리 및 사용자의 입력 처리
 */
public class Kiosk {
	private final List<Menu> menus;
	private static final Scanner sc = new Scanner(System.in);

	public Kiosk(List<Menu> menus) {
		this.menus = menus;
	}

	public void start() {
		while (true) {
			try {
				showMainMenus();
				int mainMenuCommand = inputMainMenuCommand();

				if (mainMenuCommand == 0) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}

				Menu menu = menus.get(mainMenuCommand - 1);
				selectMenu(menu);
			}
			catch (InputMismatchException e) {
				System.out.println("올바른 명령어를 입력 해주세요\n");
				sc.nextLine(); // 버퍼 비우기
			}
			catch (Exception e) {
				e.printStackTrace();
				sc.nextLine(); // 버퍼 비우기
			}
		}
	}

	private void selectMenu(Menu menu) {
		while (true) {
			try {
				showMenus(menu);
				int selectedMenu = inputMenu(menu);

				if (selectedMenu == 0) {
					System.out.println(menu.getCategory() + "선택을 종료합니다.\n");
					return;
				}

				System.out.println("선택한 메뉴:" + menu.get(selectedMenu - 1) + "\n");

			} catch (InputMismatchException e) {
				System.out.println("올바른 명령어를 입력 해주세요\n");
				sc.nextLine(); // 버퍼 비우기
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine(); // 버퍼 비우기
			}
		}
	}

	private void showMainMenus() {
		System.out.println("[ MAIN MENU ]");

		for(int i = 0; i < menus.size(); i++) {
			System.out.println((i + 1) + ". " + menus.get(i).getCategory());
		}

		System.out.println("0. 종료");
	}

	private void showMenus(Menu menu) {
		String title = String.format("[ %s MENU ]", menu.getCategory());
		System.out.println(title);

		for(int i = 0; i < menu.size(); i++) {
			System.out.println((i + 1) + ". " + menu.get(i));
		}

		System.out.println("0. 뒤로가기");
	}

	private int inputMainMenuCommand() {
		System.out.print("숫자 입력: ");
		int command = sc.nextInt();

		// 이상한 정수값 입력 되는 경우
		if (command < 0 || command > menus.size()) {
			throw new InputMismatchException("올바른 명령어를 입력 해주세요");
		}

		return command;
	}

	private int inputMenu(Menu menu) {
		System.out.print("숫자 입력: ");
		int command = sc.nextInt();

		// 이상한 정수 값 입력 되는 경우
		if (command < 0 || command > menu.size()) {
			throw new InputMismatchException("올바른 명령어를 입력 해주세요");
		}

		return command;
	}

}
