package Day1006;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2667 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int board[][] = new int[n][n];
		String s;
		for (int i = 0; i < n; i++) {
			s = sc.next();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '0') {
					board[i][j] = 0;
				} else {
					board[i][j] = -1;
				}
			}
		}

		int count = 0;
		Queue<Point> q = new LinkedList<Point>();
		Point p;
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { 1, -1, 0, 0 };
		int nx, ny;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == -1) {
					count++;
					q.add(new Point(j, i));
					board[i][j] = count;
					while (!q.isEmpty()) {
						p = q.poll();
						for (int k = 0; k < 4; k++) {
							ny = p.y + dy[k];
							nx = p.x + dx[k];
							if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
								continue;
							}
							if (board[ny][nx] != -1) {
								continue;
							}
							board[ny][nx] = count;
							q.add(new Point(nx,ny));
						}
					}
				}
			}
		}
		System.out.println(count);
		int num[] = new int[count];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j] != 0) {
					num[board[i][j]-1]++;
				}
			}
		}
		Arrays.sort(num);
		for(int i=0;i<count;i++) {
			System.out.println(num[i]);
		}
	}
}
