package challenge.level2.util;

import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 11.
 *
 * Scanner를 어플리케이션 전역에서 사용하기 위한 유틸 클래스
 */
public final class ScannerHolder {
	public final static Scanner sc = new Scanner(System.in);

	// ScannerHolder 인스턴스 생성 금지 및 상속 불가능
	private ScannerHolder() {

	}
}
