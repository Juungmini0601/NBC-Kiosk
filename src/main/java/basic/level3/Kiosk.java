package basic.level3;

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
	private final List<MenuItem> menuItems;
	private static final Scanner sc = new Scanner(System.in);

	public Kiosk(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void start() {
		while (true) {
			try {
				showMenu();
				int command = inputCommand();

				if (command == 0) {
					return;
				}

				// 선택된 메뉴 출력
				System.out.println();
				System.out.printf("선택된 메뉴: %s\n\n", menuItems.get(command-1));
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

	private void showMenu() {
		System.out.println("[ SHAKESHACK MENU ]");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, menuItems.get(i));
		}

		System.out.println("0. 종료	| 종료");
	}

	private int inputCommand() {
		System.out.print("숫자 입력: ");
		int command = sc.nextInt();

		// 이상한 정수값 입력 되는 경우
		if (command < 0 || command > menuItems.size()) {
			throw new InputMismatchException("올바른 명령어를 입력 해주세요");
		}

		return command;
	}
}
