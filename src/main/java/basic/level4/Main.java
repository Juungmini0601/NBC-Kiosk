package basic.level4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 * NBC 키오스크 과제 기본 - Lv4
 * Menu 클래스 추가하기
 */
public class Main {
	public static void main(String[] args) {
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

		List<Menu> menus = List.of(hamburgerMenu, beverageMenu, dessertMenu);

		Kiosk kiosk = new Kiosk(menus);
		kiosk.start();
	}
}
