package Day0913;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1261 {

	static int N, M;
	static int map[][];
	static PriorityQueue<p> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		String instring;
		for (int i = 0; i < N; i++) {
			instring = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = instring.charAt(j) - '0';
			}

		}

		q = new PriorityQueue<p>();
		map[0][0] = 2;
		find = false;
		p P = new p(0, 0, 0);
		q.add(P);
		while (!q.isEmpty()) {
			bfs(q.poll());
			if (find)
				break;
		}

		System.out.println(result);

	}

	static boolean find;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int x, y, nx, ny,wall;
	static int result;
	public static void bfs(p pp) {
		x = pp.x;
		y = pp.y;
		wall = pp.wall;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
				continue;
			}
			if (ny == N - 1 && nx == M - 1) {
				find = true;
				result = pp.wall;
				return;
			}
			if (map[ny][nx] == 2)
				continue;
			if (map[ny][nx] == 1) {
				map[ny][nx] = 2;
				q.add(new p(nx,ny,wall+1));
				continue;
			}
			map[ny][nx] = 2;
			q.add(new p(nx, ny, wall));
		}

	}

}

class p implements Comparable<p>{
	int x;
	int y;
	int wall;
	
	@Override
	public int compareTo(p o) {
		return this.wall - o.wall;
	}

	public p(int x, int y, int wall) {
		super();
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}