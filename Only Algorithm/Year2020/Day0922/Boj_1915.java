package Day0922;

import java.util.Scanner;

public class Boj_1915 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean a[][] = new boolean[n][m];
		boolean find = false;
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == '1') {
					a[i][j] = true;
					find = true;
				}
			}
		}
		if(!find) { // 모두 0이 들어온 경우
			System.out.println(0);
			return;
		}
		
		boolean firstfind = false;
		int count = 0;
		while (true) {
			// find 초기화. count 늘려줌
			find = false;
			count++;
			for (int i = 0; i < n - count; i++) {
				for (int j = 0; j < m - count; j++) {// 2 x 2 크기의 true 정사각형이 있는지 찾음
					if (a[i][j] && a[i + 1][j] && a[i][j + 1] && a[i + 1][j + 1]) {
						find = true;// 찾으면 find를 true로 바꿔줌
						a[i][j] = true;// 수행하는 연산으로 새로운 맵을 만들어줌
					} else {
						a[i][j] = false;
					}
				}
			}
			if (!find) {// find가 false이면 종료 후 전의 카운트 값을 저장
				break;
			}
			// 새로운 맵으로 다음 진행할 맵으로 바꿔줌 (자연스럽게 바뀜)
		}
		System.out.println((count) * (count));
	}
}
