package challenge.level2.command;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.discount.DisCountType;
import challenge.level2.domain.order.Order;
import challenge.level2.util.ScannerHolder;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 *
 * @see Command 구현체
 * 주문 프로세스를 처리하기 위한 코드
 */
public class OrderCommand implements Command {

	private static final Integer ORDER = 1;
	private static final Integer NOT_ORDER = 2;
	private final Cart cart;

	public OrderCommand(Cart cart) {
		this.cart = cart;
	}

	@Override
	public void execute() {
		// 장바구니 상태를 보여주면서 주문 할 건지 확인
		Printer.confirmOrderWithCartInfo(cart);
		int orderCode = Reader.inputOrderCode();
		// 주문하겠다고 하면 주문
		if (orderCode == ORDER) {
			Printer.showDisCountInfo();
			DisCountType disCountType = Reader.inputDiscountCode();
			// 할인 정보와 장바구니가 담겨있는 Order 객체 생성
			Order order = new Order(disCountType, cart);
			// 주문 정보를 보여주고 장바구니 리셋
			Printer.showOrderStatus(order);
			cart.clearCart();
		}
	}

	private static class Printer {
		public static void confirmOrderWithCartInfo(Cart cart) {
			System.out.println("아래와 같이 주문 하겠습니까?\n");
			System.out.println(cart);
			System.out.println();

			System.out.println("1.주문	2.메뉴판");
		}

		public static void showOrderStatus(Order order) {
			System.out.println("주문이 완료 되었습니다.");
			double finalPrice = order.getFinalPrice();
			System.out.printf("금액은 W %s 입니다.\n", finalPrice);
			System.out.println("장바구니를 비웁니다.");
		}

		public static void showDisCountInfo() {
			System.out.println("할인 정보를 입력해주세요.");
			Arrays.stream(DisCountType.values())
				.forEach(type ->
					System.out.printf("%d. %s: %d%%\n", type.getCode(), type.getDescription(), type.getDiscountRate()));
		}

		// 예외 메세지 출력
		public static void printErrorMessage(Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("올바른 명령어를 입력 해주세요!\n");
			} else {
				System.out.println("예상하지 못한 예외가 발생 했습니다.");
				e.printStackTrace();
			}
		}
	}

	private static class Reader {

		private static final Scanner sc = ScannerHolder.sc;

		public static DisCountType inputDiscountCode() {
			while (true) {
				System.out.println("숫자 입력: ");
				try {
					int disCountCode = sc.nextInt();
					return DisCountType.from(disCountCode);
				} catch (InputMismatchException e) {
					// 버퍼 비우기용 코드
					sc.nextLine();
					Printer.printErrorMessage(e);
				}
			}
		}

		public static int inputOrderCode() {
			while (true) {
				System.out.print("숫자 입력: ");
				try {
					int code = sc.nextInt();

					// 이상한 정수 값 입력 되는 경우
					if (code != ORDER && code != NOT_ORDER) {
						throw new InputMismatchException("올바른 명령어를 입력 해주세요");
					}

					return code;
				} catch (InputMismatchException e) {
					// 버퍼 비우기용 코드
					sc.nextLine();
					Printer.printErrorMessage(e);
				}
			}
		}
	}
}
