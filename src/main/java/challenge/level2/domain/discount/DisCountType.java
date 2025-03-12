package challenge.level2.domain.discount;

import java.util.InputMismatchException;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 12.
 */
public enum DisCountType {
	PERSON_OF_NATIONAL(1, 10, "국가 유공자"),
	SOLDIER(2, 5, "군인"),
	STUDENT(3, 3, "학생"),
	GENERAL(4, 0, "일반");

	private final int code;
	private final int discountRate;
	private final String description;

	DisCountType(int code, int discountRate, String description) {
		this.code = code;
		this.discountRate = discountRate;
		this.description = description;
	}

	public static DisCountType from(int inputCode) {
		for (DisCountType type : values()) {
			if (type.code == inputCode) {
				return type;
			}
		}

		throw new InputMismatchException("올바른 명령어를 입력 해주세요!");
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
