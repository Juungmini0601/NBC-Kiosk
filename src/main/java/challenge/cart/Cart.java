package challenge.cart;

import java.util.HashMap;
import java.util.Map;

import challenge.menu.MenuItem;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 *
 * 카트에 들어있는 상품을 표현하기 위한 클래스
 */
public class Cart {
	private final Map<MenuItem, Integer> cart;

	public Cart() {
		this.cart = new HashMap<>();
	}

	public void addMenuItem(MenuItem item) {
		cart.put(item, cart.getOrDefault(item, 0) + 1);
	}


	// 카트에 있는 전체 합계 계산
	public double getTotalPrice() {
		double sum = 0;

		for (MenuItem menuItem: cart.keySet()) {
			sum += menuItem.getPrice() * cart.get(menuItem);
		}

		return sum;
	}

	// 장바구니 비우기
	public void clearCart() {
		cart.clear();
	}

	/**
	 * 카트 출력용
	 *
	 * [ Orders ]
	 * SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
	 *
	 * [ Total ]
	 * W 8.9
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ Orders ]");
		sb.append("\n");

		for (MenuItem menuItem: cart.keySet()) {
			sb.append(menuItem)
				.append("	수량: ")
				.append(cart.get(menuItem))
			  	.append("\n");
		}

		sb.append("\n")
			.append("[ Total ]")
			.append("\n")
			.append("W ")
			.append(getTotalPrice())
			.append("\n");

		return sb.toString();
	}
}
