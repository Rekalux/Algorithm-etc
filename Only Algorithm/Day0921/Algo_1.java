package Day0921;

import java.util.Scanner;

public class Algo_1 { // 도너츠 합 구하는 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt(); // 행 개수
			int M = sc.nextInt(); // 열 개수
			int K = sc.nextInt(); // 도넛길이
			int map[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; // 최대값 최소값 초기화
			for (int i = 0; i < N - K + 1; i++) {
				for (int j = 0; j < M - K + 1; j++) { // 기준점 정하고
					int sum = 0; // 합계를 초기화하고
					
					for (int ii = 0; ii < K; ii++) {
						for (int jj = 0; jj < K; jj++) { // 도너츠돌리고
							if (ii == 0 || jj == 0 || ii == K - 1 || jj == K - 1) { // 해당하는 수만 고르고
								sum += map[i + ii][j + jj]; // 값 누적하고
							}
						}
					}

					if (max < sum) { // 최대인지 확인
						max = sum;
					}
					if (min > sum) { // 최소인지 확인
						min = sum;
					}
				}
			}
			System.out.println("#" + tc + " " + (max - min)); // 차이 출력

		}
	}
}
