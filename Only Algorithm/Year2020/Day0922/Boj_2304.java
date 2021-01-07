package Day0922;

import java.util.Scanner;

public class Boj_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int map[] = new int[1001];
		int a, b;
		int m = 0, idx = 0; // 가장 큰 값과 인덱스
		int start = 1000, end = 0; // 가장 왼쪽 인덱스, 가장 오른쪽 인덱스
		for (int i = 0; i < num; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a] = b;
			if (m < b) {
				m = b;
				idx = a;
			}
			if (start > a) {
				start = a;
			}
			if (end < a) {
				end = a;
			}
		}

		int sum = 0; // 넓이 누적
		int value = 0; // 왼쪽에서 가면서 최대의 값
		for (int i = start; i < idx; i++) { // 왼쪽 다각형 넓이 구하기
			value = Math.max(value, map[i]);
			sum += value;
		}
		value = 0;
		for (int i = end; i > idx; i--) { // 오른쪽 다각형 넓이 구하기
			value = Math.max(value, map[i]);
			sum += value;
		}
		sum += m;
		System.out.println(sum);
	}
}