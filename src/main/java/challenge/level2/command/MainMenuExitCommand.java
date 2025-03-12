package challenge.level2.command;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 * @see Command 구현체
 *
 * 프로그램 종료 프로세스
 */
public class MainMenuExitCommand implements Command {

	@Override
	public void execute() {
		Printer.printKioskExitMessage();
		System.exit(0);
	}

	private static class Printer {
		// 키오스크 종료 메세지
		public static void printKioskExitMessage() {
			System.out.println("프로그램을 종료합니다.");
		}
	}
}
