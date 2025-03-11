package challenge.level2;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 * NBC 키오스크 과제 첼린지 - Lv1
 *
 * 장바구니 생성 및 관리 기능
 * 장바구니는 메뉴명, 수량, 가격 정보를 저장하며 항목을 동적으로 추가 및 조회할 수 있어야 한다.
 * 장바구니에 담긴 모든 메뉴와 총 금액을 출력한다.
 * 장바구니 추가 취소 가능
 */
public class Main {
	public static void main(String[] args) {
		Kiosk kiosk = new Kiosk();
		kiosk.start();
	}
}
