package Day1010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_15644 {
	static int Y, X;
	static int Ball2[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		Ball2 = new int[Y][X];
		String s;
		int result = -1;
		String result_s = null;
		Ball2 red = null, blue = null;
		for (int i = 0; i < Y; i++) {
			s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == '#') {
					Ball2[i][j] = 2;
				} else if (s.charAt(j) == '.') {
					Ball2[i][j] = 0;
				} else if (s.charAt(j) == 'O') {
					Ball2[i][j] = 1;
				} else if (s.charAt(j) == 'R') {
					Ball2[i][j] = 0;
					red = new Ball2(j, i);
				} else if (s.charAt(j) == 'B') {
					Ball2[i][j] = 0;
					blue = new Ball2(j, i);
				}
			}
		}
		Ball2map2 bm = new Ball2map2(red, blue, 0,"");
//		for (int i = 0; i < Y; i++) {
//			for (int j = 0; j < X; j++) {
//				System.out.print(Ball2[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
		boolean visit[][][][] = new boolean[Y][X][Y][X];
		Queue<Ball2map2> q = new LinkedList<Ball2map2>();
		q.add(bm);
		visit[bm.red.y][bm.red.x][bm.blue.y][bm.blue.x] = true;
		

		Ball2map2 b;
		int count;
		out: while (!q.isEmpty()) {
			bm = q.poll();
//			System.out.println("현재 : "+ bm.red.y + " " + bm.red.x + " " + bm.blue.y + " " + bm.blue.x);
			count = bm.count + 1;
			if (count > 10) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				b = new Ball2map2(new Ball2(bm.red.x,bm.red.y),new Ball2(bm.blue.x,bm.blue.y),count,bm.move);
				b.red = Ball2move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
				b.blue = Ball2move(b.blue.x,b.blue.y,b.red.x,b.red.y, i);
				b.red = Ball2move(b.red.x,b.red.y,b.blue.x,b.blue.y, i);
//				System.out.println(b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
				if (Ball2[b.blue.y][b.blue.x] == 1) {
					continue;
				}
				if (Ball2[b.red.y][b.red.x] == 1) {
					result = count;
					result_s = b.move+dmove[i];
					break out;
				}
				if (visit[b.red.y][b.red.x][b.blue.y][b.blue.x]) {
					continue;
				}
				visit[b.red.y][b.red.x][b.blue.y][b.blue.x] = true;
				
//				System.out.println("찾음:"+b.red.y + " " + b.red.x + " " + b.blue.y + " " + b.blue.x);
//				System.out.println();
				q.add(new Ball2map2(new Ball2(b.red.x,b.red.y),new Ball2(b.blue.x,b.blue.y),count,b.move+dmove[i]));
			}
		}

		System.out.println(result);
		if(result >0) {
			System.out.println(result_s);
		}

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static String[] dmove = {"D","U","R","L"};

	static Ball2 Ball2move(int rx,int ry,int bx,int by, int dir) {
		int nx, ny;
		int py, px;
		px = rx;
		py = ry;
		while (true) {
			nx = px+dx[dir];
			ny = py+dy[dir];
			if (Ball2[ny][nx] == 2) {
				break;
			}
			if (Ball2[py][px] == 1) {
				break;
			}
			if (ny == by && nx == bx && Ball2[ny][nx] != 1) {
				break;
			}
			px = nx;
			py = ny;
		}
		return new Ball2(px, py);
	}

}

class Ball2map2 {
	Ball2 red;
	Ball2 blue;
	int count;
	String move;

	public Ball2map2(Ball2 red, Ball2 blue, int count,String move) {
		super();
		this.red = red;
		this.blue = blue;
		this.count = count;
		this.move =move;
	}
}

class Ball2 {
	int x;
	int y;

	public Ball2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
