package Day0921;

import java.util.Scanner;

public class Boj_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int n[] = new int[6];
		for (int i = 0; i < 6; i++) {
			int temp = sc.nextInt(); // 방향 버려
			n[i] = sc.nextInt(); // 길이 받아옴
		}
		int idx = 0; // 저장할 인덱스
		int big = 0;
		for (int i = 0; i < 6; i++) {
			int gob = n[i] * n[(i + 1) % 6]; // 최대 넓이의 사각형을 찾음
			if (big < gob) { // 최대인가?
				big = gob; // 최대의 넓이를 저장
				idx = i; // 그 때의 인덱스를 저장
			}
		}
		int small = n[(idx + 3) % 6] * n[(idx + 4) % 6]; // 그 인덱스의 +3 +4 한 인덱스가 작은 직사각형의 가로 세로 길이 (인덱스 초과시 6으로 나눠줌)
		int result = K * (big - small);
		System.out.println(result);
	}
}