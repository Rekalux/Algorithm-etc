package Day1212;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_18513_re { // 테스트케이스 수정으로 코드 수정
	static int n, k;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 치킨집 개수
		k = sc.nextInt(); // 지을 집 개수

		visited = new boolean[200300001]; // 집을 지을 수 있는지 체크할 배열
		Queue<int[]> q = new LinkedList<int[]>(); // 현재 위치를 넣을 큐
		int pos[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			pos[i] = sc.nextInt()+100150000;
		}

		// 치킨 집 위치 큐에 삽입
		for (int i = 0; i < n; i++) {
			int x = pos[i];
			q.offer(new int[] { x, 0 });// 치킨집 위치와 치킨지수를 0으로 초기화 해서 큐에 삽입
			visited[x] = true; // 치킨집 위치는 집을 지을 수 없다.
		}

		long result = 0; // 결과 값
		int num = 0;// 지은 집
		int dx[] = { -1, 1 };
		out: while (!q.isEmpty()) {
			int[] x = q.poll(); // 값을 하나 꺼낸다.

			int nx; // 다음 집을 지을 위치
			int ny = x[1] + 1; // 치킨 지수
			for (int i = 0; i < 2; i++) {
				nx = x[0] + dx[i];
				if (nx >= 200300000 || nx <= 0 || visited[nx]) {
				} // 범위를 넘어가거나 이미 무언가 지어져 있다면 다음으로 넘어감
				else {// 지을 수 있다면 집을 짓는다.
					visited[nx] = true; // 집을 지었다고 체크
					q.offer(new int[] { nx, ny }); // 현재 위치와 치킨 지수 큐에 삽입
					result += ny; // 결과 값에 치킨 지수를 더한다.
					num++;
					if (num == k)
						break out; // 현재 지어진 건물 +1 한다. 만약 k개 만큼 집을 지었다면 break
				}
			}
		}

		System.out.println(result);// 결과 출력
	}
}