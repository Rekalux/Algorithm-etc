package Day1010;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_15653 {
	static int Y, X;
	static int Ball4[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		Ball4 = new int[Y][X];
		String s;
		int result = -1;
		Ball4 red = null, blue = null;
		for (int i = 0; i < Y; i++) {
			s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == '#') {
					Ball4[i][j] = 2;
				} else if (s.charAt(j) == '.') {
					Ball4[i][j] = 0;
				} else if (s.charAt(j) == 'O') {
					Ball4[i][j] = 1;
				} else if (s.charAt(j) == 'R') {
					Ball4[i][j] = 0;
					red = new Ball4(j, i);
				} else if (s.charAt(j) == 'B') {
					Ball4[i][j] = 0;
					blue = new Ball4(j, i);
				}
			}
		}
		Ball4map bm = new Ball4map(red, blue, 0);
//		for (int i = 0; i < Y; i++) {
//			for (int j = 0; j < X; j++) {
//				System.out.print(Ball4[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
		boolean visit[][][][] = new boolean[Y][X][Y][X];
		Queue<Ball4map> q = new LinkedList<Ball4map>();
		q.add(bm);
		visit[bm.red.y][bm.red.x][bm.blue.y][bm.blue.x] = true;
		

		Ball4map b;
		int count;
		out: while (!q.isEmpty()) {
			bm = q.poll();
//			System.out.println("현재 : "+ bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
			count = bm.count + 1;
			if (count > 10) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				b = new Ball4map(new Ball4(bm.red.x,bm.red.y),new Ball4(bm.blue.x,bm.blue.y),count);
				b.red = Ball4move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
				b.blue = Ball4move(b.blue.x,b.blue.y,b.red.x,b.red.y, i);
				b.red = Ball4move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
//				System.out.println(b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
				if (Ball4[b.blue.y][b.blue.x] == 1) {
					continue;
				}
				if (Ball4[b.red.y][b.red.x] == 1) {
					result = count;
					break out;
				}
				if (visit[b.red.y][b.red.x][b.blue.y][b.blue.x]) {
					continue;
				}
				visit[b.red.y][b.red.x][b.blue.y][b.blue.x] = true;
				
//				System.out.println("찾음:"+b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
//				System.out.println();
				q.add(new Ball4map(new Ball4(b.red.x,b.red.y),new Ball4(b.blue.x,b.blue.y),count));
			}
		}

		System.out.println(result);

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static Ball4 Ball4move(int rx,int ry,int bx,int by, int dir) {
		int nx, ny;
		int py, px;
		px = rx;
		py = ry;
		while (true) {
			nx = px+dx[dir];
			ny = py+dy[dir];
			if (Ball4[ny][nx] == 2) {
				break;
			}
			if (Ball4[py][px] == 1) {
				break;
			}
			if (ny == by && nx == bx && Ball4[ny][nx] != 1) {
				break;
			}
			px = nx;
			py = ny;
		}
		return new Ball4(px, py);
	}

}

class Ball4map {
	Ball4 red;
	Ball4 blue;
	int count;

	public Ball4map(Ball4 red, Ball4 blue, int count) {
		super();
		this.red = red;
		this.blue = blue;
		this.count = count;
	}
}

class Ball4 {
	int x;
	int y;

	public Ball4(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}