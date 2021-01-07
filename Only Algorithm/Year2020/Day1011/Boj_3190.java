package Day1011;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj_3190 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Point> q = new LinkedList<Point>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int map[][] = new int[N][N];
		int x, y;
		for (int i = 0; i < K; i++) {
			y = sc.nextInt() - 1;
			x = sc.nextInt() - 1;
			map[y][x] = 1;
		}
		String s;
		int L = sc.nextInt();
		Time[] time = new Time[L];
		for (int i = 0; i < L; i++) {
			time[i] = new Time();
			time[i].time = sc.nextInt();
			s = sc.next();
			if (s.equals("D")) {
				time[i].dir = 1;
			} else {
				time[i].dir = -1;
			}
		}
		int t = 0;
		Point p;
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		int dir = 0;
		int time_idx = 0;
		q.addFirst(new Point(0, 0));
		out: while (true) {
			t++;
			p = q.peekFirst();
			x = p.x + dx[dir];
			y = p.y + dy[dir];
			if (x < 0 || y < 0 || x >= N || y >= N) {
				break;
			}
			for (Point point : q) {

				if (point.x == x && point.y == y) {
					break out;
				}
			}
			q.addFirst(new Point(x, y));
			if (map[y][x] == 0) {
				q.pollLast();
			}
			map[y][x] = 0;
			if (time[time_idx].time == t) {
				dir = dir + time[time_idx].dir;
				if (dir < 0) {
					dir += 4;
				}
				dir %= 4;
				time_idx++;
				time_idx %= L;
			}
		}
		System.out.println(t);
	}
}

class Time {
	int time;
	int dir;
}
