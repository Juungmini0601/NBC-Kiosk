package challenge.level2.command;

import challenge.level2.domain.cart.Cart;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 * @see Command 구현체
 * 주문 취소 프로세스
 */
public class OrderCancelCommand implements Command {

	private final Cart cart;

	public OrderCancelCommand(Cart cart) {
		this.cart = cart;
	}

	@Override
	public void execute() {
		cart.clearCart();
		Printer.printCancelOrderMessage();
	}

	private static class Printer {
		public static void printCancelOrderMessage() {
			System.out.println("주문이 취소 되었습니다.");
			System.out.println("장바구니를 비웁니다.\n");
		}
	}
}
