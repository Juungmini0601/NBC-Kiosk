package challenge.level2.command;

import java.util.InputMismatchException;
import java.util.Scanner;

import challenge.level2.domain.cart.Cart;
import challenge.level2.util.ScannerHolder;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 *
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
		Printer.showCartStatus(cart);
		int orderCode = Reader.inputOrderCode();

		if (orderCode == ORDER) {
			// TODO 할인 정책 추가 예정
			Printer.showOrderStatus(cart);
		}
	}

	private static class Printer {
		public static void showCartStatus(Cart cart) {
			System.out.println("아래와 같이 주문 하겠습니까?\n");
			System.out.println(cart);
			System.out.println();

			System.out.println("1.주문	2.메뉴판");
		}

		public static void showOrderStatus(Cart cart) {
			System.out.println("주문이 완료 되었습니다.");
			double totalValue = cart.getTotalPrice();
			System.out.printf("금액은 W %s 입니다.\n", totalValue);
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
