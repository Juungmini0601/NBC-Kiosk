package basic.level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * NBC 키오스크 과제 기본 - Lv2
 * 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
 *
 * MenuItem 클래스와 List를 이용해 메뉴를 관리
 */
public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<MenuItem> menuItems = new ArrayList<>();
		menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
		menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
		menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
		menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


		while (true) {
			try {
				// 콘솔에 메뉴 출력
				System.out.println("[ SHAKESHACK MENU ]");
				for (int i = 0; i < menuItems.size(); i++) {
					System.out.printf("%d. %s\n", i + 1, menuItems.get(i));
				}

				System.out.println("0. 종료	| 종료");

				System.out.print("숫자 입력: ");
				int command = sc.nextInt();

				if (command == 0) {
					System.out.println("키오스크를 종료합니다.");
					break;
				}
				// 이상한 정수값 입력 되는 경우
				if (command < 0 || command > menuItems.size()) {
					throw new InputMismatchException("올바른 명령어를 입력 해주세요");
				}
				// 선택된 메뉴 출력
				System.out.println();
				System.out.printf("선택된 메뉴: %s\n\n", menuItems.get(command-1));
			} catch (InputMismatchException e) {
				System.out.println("올바른 명령어를 입력 해주세요\n");
				sc.nextLine(); // 버퍼 비우기
			}
			catch (Exception e) {
				e.printStackTrace();
				sc.nextLine(); // 버퍼 비우기
			}
		}
	}
}
