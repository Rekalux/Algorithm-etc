package Day1010;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_13460 {
	static int Y, X;
	static int ball[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		ball = new int[Y][X];
		String s;
		int result = -1;
		Ball red = null, blue = null;
		for (int i = 0; i < Y; i++) {
			s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == '#') {
					ball[i][j] = 2;
				} else if (s.charAt(j) == '.') {
					ball[i][j] = 0;
				} else if (s.charAt(j) == 'O') {
					ball[i][j] = 1;
				} else if (s.charAt(j) == 'R') {
					ball[i][j] = 0;
					red = new Ball(j, i);
				} else if (s.charAt(j) == 'B') {
					ball[i][j] = 0;
					blue = new Ball(j, i);
				}
			}
		}
		Ballmap bm = new Ballmap(red, blue, 0);
//		for (int i = 0; i < Y; i++) {
//			for (int j = 0; j < X; j++) {
//				System.out.print(ball[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
		boolean visit[][][][] = new boolean[Y][X][Y][X];
		Queue<Ballmap> q = new LinkedList<Ballmap>();
		q.add(bm);
		visit[bm.red.y][bm.red.x][bm.blue.y][bm.blue.x] = true;
		

		Ballmap b;
		int count;
		out: while (!q.isEmpty()) {
			bm = q.poll();
//			System.out.println("현재 : "+ bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
			count = bm.count + 1;
			if (count > 10) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				b = new Ballmap(new Ball(bm.red.x,bm.red.y),new Ball(bm.blue.x,bm.blue.y),count);
				b.red = ballmove(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
				b.blue = ballmove(b.blue.x,b.blue.y,b.red.x,b.red.y, i);
				b.red = ballmove(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
//				System.out.println(b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
				if (ball[b.blue.y][b.blue.x] == 1) {
					continue;
				}
				if (ball[b.red.y][b.red.x] == 1) {
					result = count;
					break out;
				}
				if (visit[b.red.y][b.red.x][b.blue.y][b.blue.x]) {
					continue;
				}
				visit[b.red.y][b.red.x][b.blue.y][b.blue.x] = true;
				
//				System.out.println("찾음:"+b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
//				System.out.println();
				q.add(new Ballmap(new Ball(b.red.x,b.red.y),new Ball(b.blue.x,b.blue.y),count));
			}
		}

		System.out.println(result);

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static Ball ballmove(int rx,int ry,int bx,int by, int dir) {
		int nx, ny;
		int py, px;
		px = rx;
		py = ry;
		while (true) {
			nx = px+dx[dir];
			ny = py+dy[dir];
			if (ball[ny][nx] == 2) {
				break;
			}
			if (ball[py][px] == 1) {
				break;
			}
			if (ny == by && nx == bx && ball[ny][nx] != 1) {
				break;
			}
			px = nx;
			py = ny;
		}
		return new Ball(px, py);
	}

}

class Ballmap {
	Ball red;
	Ball blue;
	int count;

	public Ballmap(Ball red, Ball blue, int count) {
		super();
		this.red = red;
		this.blue = blue;
		this.count = count;
	}
}

class Ball {
	int x;
	int y;

	public Ball(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}