package basic.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * NBC 키오스크 과제 기본 - Lv1
 * 기본적인 키오스크 프로그래밍
 *
 * 1. 햄버거 메뉴 출력 및 선택하기
 * 	- 실행시 햄버거 메뉴 표시, 이후 숫자를 입력 받아서 메뉴 선택
 * 	- 입력받은 메뉴에 따라서 다른 로직을 실행하는 코드 작성
 * 	- 특정 번호가 입력되면 프로그램을 종료한다.
 */
public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] names = {"ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"};
		double[] prices = {6.9, 8.9, 6.9, 5.4};
		String[] descriptions = {
			"토마토, 양상추, 쉑소스가 토핑된 치즈버거",
			"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
			"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
			"비프패티를 기반으로 야채가 들어간 기본버거"
		};

		while (true) {
			try {
				// 콘솔에 메뉴 출력
				System.out.println("[ SHAKESHACK MENU ]");
				for (int i = 0; i < names.length; i++) {
					System.out.printf("%d. %s | W %f | %s\n", i + 1, names[i], prices[i], descriptions[i]);
				}

				System.out.println("0. 종료	| 종료");

				System.out.print("숫자 입력: ");
				int command = sc.nextInt();

				if (command == 0) {
					System.out.println("키오스크를 종료합니다.");
					break;
				}
				// 이상한 정수값 입력 되는 경우
				if (command < 0 || command > names.length) {
					throw new InputMismatchException("올바른 명령어를 입력 해주세요");
				}
				// 선택된 메뉴 출력
				System.out.println();
				System.out.printf("선택된 메뉴: %s | W %f | %s\n\n", names[command -1], prices[command -1], descriptions[command -1]);
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
