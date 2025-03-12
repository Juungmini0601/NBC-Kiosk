package challenge.level2.domain.order;

import challenge.level2.domain.cart.Cart;
import challenge.level2.domain.discount.DisCountType;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 12.
 *
 * @see DisCountType 할인 타입
 * @see Cart 장바구니
 *
 * cart와 DiscountType을 이용하여 최종 주문 정보를 계산하기 위한 클래스
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
