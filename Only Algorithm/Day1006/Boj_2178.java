package Day1006;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { 1, -1, 0, 0 };
		int nx, ny;
		int[][] board = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			String s = sc.next();
			for (int j = 0; j < X; j++) {
				if (s.charAt(j) == '1')
					board[i][j] = 0;
				else {
					board[i][j] = -1;
				}
			}
		}
//		for(int i=0;i<Y;i++) {
//			for(int j=0;j<X;j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		Queue<Point> q = new LinkedList<Point>();
		board[0][0] = 1;
		q.add(new Point(0, 0));
		Point p;
		while (!q.isEmpty()) {
			p = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx <0 || ny<0 || nx>=X || ny>=Y) {
					continue;
				}
				if(board[ny][nx] != 0) {
					continue;
				}
				board[ny][nx] = board[p.y][p.x] + 1;
				q.add(new Point(nx,ny));
			}
		}
		System.out.println(board[Y-1][X-1]);
	}
}
