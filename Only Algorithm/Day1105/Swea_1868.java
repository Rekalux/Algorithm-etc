package Day1105;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1868 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		for (int tc = 1; tc < T + 1; tc++) {
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					if (s.charAt(j) == '.') { // 아무것도 아닌 곳 0
						a[i][j] = 0;
					} else {
						a[i][j] = -2; // 지뢰 -2
					}
				}
			}
			int ny, nx;
			int tny, tnx;
			int count = 0;
			for (int i = 0; i < n; i++) {
				con: for (int j = 0; j < n; j++) {
					if (a[i][j] != 0) { // 누르지 않은 곳이면 스킵!
						continue;
					}
					for (int dir = 0; dir < 8; dir++) {
						ny = dy[dir] + i;
						nx = dx[dir] + j;
						if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
							continue;
						}
						if (a[ny][nx] == -2) { // 주변 8칸 중 지뢰가 있으면
							continue con; // 거긴 아직 누르지 마
						}
					}
					Queue<pop> q = new LinkedList<pop>();
					q.add(new pop(j, i));
					count++; // 누를 곳 찾았다!
					a[i][j] = 1;
					conn: while (!q.isEmpty()) {
						pop p = q.poll();
						for (int d = 0; d < 8; d++) {
							tny = p.y + dy[d];
							tnx = p.x + dx[d];
							if (tny < 0 || tnx < 0 || tny >= n || tnx >= n) {
								continue;
							}
							if (a[tny][tnx] == -2) { // 새로 찾을 것도 주변 8칸에 지뢰가 있으면
								continue conn; // 끝
							}
						}
						for (int d = 0; d < 8; d++) { // 주변 8개를 누를 수 있는 것에 한해서 8개를 모두 연다!
							tny = p.y + dy[d];
							tnx = p.x + dx[d];
							if (tny < 0 || tnx < 0 || tny >= n || tnx >= n) {
								continue;
							}
							if (a[tny][tnx] == 0) {
								a[tny][tnx] = 1; // 누르면 1
								q.add(new pop(tnx, tny)); // 파핑파핑
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == 0) { // 누르지 않은 것의 개수를 센다!
						count++;
					}
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}

class pop {
	int x;
	int y;

	public pop(int x, int y) {
		this.x = x;
		this.y = y;
	}
}