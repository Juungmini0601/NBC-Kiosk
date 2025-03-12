package challenge.level2.domain.order;

import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.discount.DisCountType;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 12.
 */
public class Order {
	private final DisCountType disCountType;
	private final Cart cart;

	public Order(DisCountType disCountType, Cart cart) {
		this.disCountType = disCountType;
		this.cart = cart;
	}

	public double getFinalPrice() {
		double totalPrice = cart.getTotalPrice();
		double discountAmount = totalPrice * (disCountType.getDiscountRate() / 100.0);

		return totalPrice - discountAmount;
	}
}
