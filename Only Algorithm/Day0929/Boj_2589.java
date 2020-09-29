package Day0929;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2589 {
	public static void main(String[] args){
		System.out.println(Pororo.execute());
	}
}
class Pororo {
	static int Y = 0;
	static int X = 0;
	public static int execute(){
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		map = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			String s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == 'L') {
					map[i][j] = true;
				}
			}
		}

		result = 0;
		q = new LinkedList<Point>();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (!map[i][j]) { // 육지를 찾음
					continue;
				}
				visit = new boolean[Y][X];
				q.add(new Point(j, i, 0)); // 각 위치에서 bfs 수행
				visit[i][j] = true;
				while (!q.isEmpty()) {
					bfs(q.poll());
				}
			}
		}
		return result; // 가장 긴 최단거리 출력
	} // end of execute

	static boolean map[][];
	static Queue<Point> q;
	static boolean visit[][];
	static int max;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int nx, ny;
	static int result;

	static void bfs(Point p) {
		int x = p.x;
		int y = p.y;
		int des = p.des;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
				continue;
			}
			if (visit[ny][nx]) {
				continue;
			}
			if (!map[ny][nx]) {
				continue;
			}

			visit[ny][nx] = true;
			if (result < des + 1) {
				result = des + 1;
			}
			q.add(new Point(nx, ny, des + 1));
		}

	}

	
} // end of class

class Point { // bfs를 사용할 클래스
	int x;
	int y;
	int des;

	public Point(int x, int y, int des) {
		this.x = x;
		this.y = y;
		this.des = des;
	}
}
