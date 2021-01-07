package Day0917;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_18513 {
	public static void main(String[] args) {
		int n, k;
		boolean[] visited;
		int M = 100000000;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 샘터 개수
		k = sc.nextInt(); // 지을 집 개수
		visited = new boolean[2 * M + 1]; // 집을 지을 수 있는지 체크할 배열
		Queue<int[]> q = new LinkedList<>(); // 현재 위치를 넣을 큐
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt() + M;
			q.offer(new int[] { x, 0 });// 0으로 초기화 해서 큐에 삽입
			visited[x] = true; // 샘터 위치는 집을 지을 수 없다.
		}

		long result = 0; // 결과 값
		int num = 0;// 지은 집
		int dx[] = { -1, 1 };
		out: while (true) {
			int[] x = q.poll(); // 값을 하나 꺼낸다.

			int nx; // 다음 집을 지을 위치
			int ny = x[1] + 1; // 거리
			for (int i = 0; i < 2; i++) {
				nx = x[0] + dx[i];
				if (nx >= 2 * M || nx <= 0 || visited[nx]) {
				} // 범위를 넘어가거나 이미 무언가 지어져 있다면 다음으로 넘어감
				else {// 지을 수 있다면 집을 짓는다.
					visited[nx] = true; // 집을 지었다고 체크
					q.offer(new int[] { nx, ny }); // 현재 위치와 거리를 큐에 삽입
					result += ny; // 결과 값에 거리를 더한다.
					num++;
					if (num == k)
						break out; // 현재 지어진 건물 +1 한다. 만약 k개 만큼 집을 지었다면 break
				}
			}
		}

		System.out.println(result);// 결과 출력
	}
}