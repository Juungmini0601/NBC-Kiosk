package challenge;

import static challenge.menu.MainMenuConstant.*;
import static challenge.menu.SelectMenuItemConstant.*;
import static challenge.util.ConsoleIOUtil.*;

import java.util.List;

import challenge.menu.Menu;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 *
 * @see Kiosk 키오스크 프로세스 관리
 * 	1. 메인 메뉴 표시(메뉴에 있는 음식들 카테고리 출력)
 * 	2. 메뉴 아이템 선택(카테고리 메뉴에 해당하는 음식 선택 가능)
 *
 * @see challenge.util.ConsoleIOUtil 입출력 관련 유틸 클래스
 */
public class Kiosk {
	private final List<Menu> menus;

	public Kiosk(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * 키오스크 프로그램의 시작 메소드 초기 메뉴 출력
	 * @see #selectMenuItem(Menu) 음식 선택 메뉴로 이동 할 시 수행되는 메소드
	 * @see challenge.util.ConsoleIOUtil 입출력 관련 유틸 클래스(입력 예외는 Kiosk로 Throwing)
	 */
	public void start() {
		while (true) {
			try {
				showMainMenus(menus);
				int mainMenuCommand = inputMainMenuCommand(menus);
				printKioskExitMessage();

				// 종료가 선택되면 프로그램을 종료한다.
				if (mainMenuCommand == MAIN_MENU_EXIT) {
					printKioskExitMessage();
					return;
				}

				Menu menu = menus.get(mainMenuCommand - 1);
				selectMenuItem(menu);
			} catch (Exception e) {
				printErrorMessage(e);
			}
		}
	}

	/**
	 * @param menu 선택된 메뉴에 대한 단일 item 선택 프로세스
	 */
	private void selectMenuItem(Menu menu) {
		while (true) {
			try {
				showMenus(menu);
				int selectedMenu = inputMenu(menu);
				// Menu Item 선택 종료가 눌리면 선택을 종료하고 다시 메인 메뉴 프로세스 선택 프로세스로 이동
				if (selectedMenu == SELECT_MENU_EXIT) {
					printSelectMenuExitMessage(menu.getCategory());
					return;
				}

				printSelectedMenu(menu.get(selectedMenu - 1));
			} catch (Exception e) {
				printErrorMessage(e);
			}
		}
	}
}
