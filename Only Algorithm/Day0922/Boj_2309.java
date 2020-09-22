package Day0922;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[9];
		for (int i = 0; i < 9; i++) {
			n[i] = sc.nextInt();
		}
		// 입력 끝
		find(0, 0, n); // 합이 100인 
		Arrays.sort(sel); // 오름차순 정렬
		for (int i = 0; i < 7; i++) {
			System.out.println(sel[i]); // 출력
		}
	}
	static boolean check = false;
	static int sel[] = new int[7]; // 선택한 난장이의 키가 들어갈 배열

	static void find(int s, int a, int[] n) {
		if (check)
			return; // 찾은경우 아무일도 일어나지 않게 한다.
		if (a == 7) { // 7개를 선택했을 때
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += sel[i];
			}
			if (sum == 100) { // 합이 100인지 확인
				check = true; // 찾았음을 표현
			}
			return;
		}
		if (s == 9) { // 9 난쟁이를 다 확인했을 때
			return;
		}
		sel[a] = n[s]; // 난쟁이의 키를 집어넣고
		find(s + 1, a + 1, n); // 선택을 한 경우
		find(s + 1, a, n); // 선택을 안 한 경우
	}
}