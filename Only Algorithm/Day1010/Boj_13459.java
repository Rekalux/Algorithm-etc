package Day1010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_13459 {
	static int Y, X;
	static int Ball3[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		Ball3 = new int[Y][X];
		String s;
		int result = -1;
		Ball3 red = null, blue = null;
		for (int i = 0; i < Y; i++) {
			s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == '#') {
					Ball3[i][j] = 2;
				} else if (s.charAt(j) == '.') {
					Ball3[i][j] = 0;
				} else if (s.charAt(j) == 'O') {
					Ball3[i][j] = 1;
				} else if (s.charAt(j) == 'R') {
					Ball3[i][j] = 0;
					red = new Ball3(j, i);
				} else if (s.charAt(j) == 'B') {
					Ball3[i][j] = 0;
					blue = new Ball3(j, i);
				}
			}
		}
		Ball3map bm = new Ball3map(red, blue, 0);
//		for (int i = 0; i < Y; i++) {
//			for (int j = 0; j < X; j++) {
//				System.out.print(Ball3[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
		boolean visit[][][][] = new boolean[Y][X][Y][X];
		Queue<Ball3map> q = new LinkedList<Ball3map>();
		q.add(bm);
		visit[bm.red.y][bm.red.x][bm.blue.y][bm.blue.x] = true;
		

		Ball3map b;
		int count;
		out: while (!q.isEmpty()) {
			bm = q.poll();
//			System.out.println("현재 : "+ bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
			count = bm.count + 1;
			if (count > 10) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				b = new Ball3map(new Ball3(bm.red.x,bm.red.y),new Ball3(bm.blue.x,bm.blue.y),count);
				b.red = Ball3move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
				b.blue = Ball3move(b.blue.x,b.blue.y,b.red.x,b.red.y, i);
				b.red = Ball3move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
//				System.out.println(b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
				if (Ball3[b.blue.y][b.blue.x] == 1) {
					continue;
				}
				if (Ball3[b.red.y][b.red.x] == 1) {
					result = count;
					break out;
				}
				if (visit[b.red.y][b.red.x][b.blue.y][b.blue.x]) {
					continue;
				}
				visit[b.red.y][b.red.x][b.blue.y][b.blue.x] = true;
				
//				System.out.println("찾음:"+b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
//				System.out.println();
				q.add(new Ball3map(new Ball3(b.red.x,b.red.y),new Ball3(b.blue.x,b.blue.y),count));
			}
		}

		System.out.println(result>0 ? 1 : 0);

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static Ball3 Ball3move(int rx,int ry,int bx,int by, int dir) {
		int nx, ny;
		int py, px;
		px = rx;
		py = ry;
		while (true) {
			nx = px+dx[dir];
			ny = py+dy[dir];
			if (Ball3[ny][nx] == 2) {
				break;
			}
			if (Ball3[py][px] == 1) {
				break;
			}
			if (ny == by && nx == bx && Ball3[ny][nx] != 1) {
				break;
			}
			px = nx;
			py = ny;
		}
		return new Ball3(px, py);
	}

}

class Ball3map {
	Ball3 red;
	Ball3 blue;
	int count;

	public Ball3map(Ball3 red, Ball3 blue, int count) {
		super();
		this.red = red;
		this.blue = blue;
		this.count = count;
	}
}

class Ball3 {
	int x;
	int y;

	public Ball3(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}