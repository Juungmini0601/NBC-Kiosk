package challenge.level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import challenge.level2.command.Command;
import challenge.level2.command.MainMenuCommandFactory;
import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.menu.Menu;
import challenge.level2.domain.menu.MenuItem;
import challenge.level2.util.ScannerHolder;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see Kiosk 키오스크 프로세스 관리
 * 	1. 메인 메뉴 표시(메뉴에 있는 음식들 카테고리 출력)
 * 	2. 메뉴 아이템 선택(카테고리 메뉴에 해당하는 음식 선택 가능)
 *
 * @see Cart 장바구니 표현용 클래스
 * @see Menu MenuItem을 담고 있는 클래스
 * @see MainMenuCommandFactory Command(프로그램 종료, 메뉴 선택, 주문 등등)를 담고 있는 클래스
 * @see Command 각 명령을 추상화한 인터페이스
 */
public class Kiosk {
	private final List<Menu> menus;
	private final Cart cart;
	private final MainMenuCommandFactory mainMenuCommandFactory;

	public Kiosk() {
		List<MenuItem> hamburgers = new ArrayList<>();
		hamburgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
		hamburgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
		hamburgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
		hamburgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

		Menu hamburgerMenu = new Menu("Burger", hamburgers);

		// 음료수 메뉴 생성
		List<MenuItem> drinks = new ArrayList<>();
		drinks.add(new MenuItem("Coke", 2.5, "시원한 탄산 콜라"));
		drinks.add(new MenuItem("Diet Coke", 2.5, "칼로리를 낮춘 다이어트 콜라"));
		drinks.add(new MenuItem("Sprite", 2.5, "깔끔한 탄산 사이다"));
		drinks.add(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));

		Menu beverageMenu = new Menu("Drink", drinks);

		// 디저트(감자튀김) 메뉴 생성
		List<MenuItem> desserts = new ArrayList<>();
		desserts.add(new MenuItem("Fries", 3.5, "바삭바삭하고 고소한 감자튀김"));
		desserts.add(new MenuItem("Cheese Fries", 4.5, "녹아내린 치즈가 듬뿍 얹어진 감자튀김"));
		desserts.add(new MenuItem("Bacon Cheese Fries", 5.5, "베이컨과 치즈가 듬뿍 토핑된 감자튀김"));
		desserts.add(new MenuItem("Loaded Fries", 6.0, "베이컨, 치즈, 할라피뇨가 토핑된 스페셜 감자튀김"));
		Menu dessertMenu = new Menu("Dessert", desserts);

		this.menus = List.of(hamburgerMenu, beverageMenu, dessertMenu);
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
