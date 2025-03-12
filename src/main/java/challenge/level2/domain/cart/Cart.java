package challenge.level2.domain.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import challenge.level2.domain.menu.MenuItem;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 *
 * @see MenuItem 을 원소로 가진다.
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
		return cart.entrySet().stream()
			.mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum();
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
		String orderString = cart.entrySet().stream()
			.map(entry -> String.format("%s\t수량: %d", entry.getKey(), entry.getValue()))
			.collect(Collectors.joining("\n")); // Stream의 요소를 \n 구분자를 넣어가며 합쳐준다.

		return String.format("""
			[ Orders ]
			%s
			
			[ Total ]
			W %.2f
			""", orderString, getTotalPrice());
	}
}
