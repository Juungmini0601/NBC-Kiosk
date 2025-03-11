package challenge.level2.command;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 *
 * @see challenge.level2.Kiosk
 * Kiosk에서 선택될 메뉴를 실행할 프로세스 추상 클래스
 */
@FunctionalInterface
public interface Command {
	void execute();
}
