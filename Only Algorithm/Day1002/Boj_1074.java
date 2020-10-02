package Day1002;

import java.util.Scanner;

public class Boj_1074 {
	static int X, Y;
	static int result;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Y = sc.nextInt();
		X = sc.nextInt();
		count = 0;
		find(0, 0, N);
		System.out.println(result);
	}

	static int nx, ny;
	static int dx[] = { 0, 1, 0, 1 };
	static int dy[] = { 0, 0, 1, 1 };

	static void find(int x, int y, int n) {
		if (n == 1) {
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx == X && ny == Y) {
					result = count;
				}
				count++;
			}
			return;
		}
		find(x, y, n - 1);
		find(x + (1 << (n - 1)), y, n - 1);
		find(x, y + (1 << (n - 1)), n - 1);
		find(x + (1 << (n - 1)), y + (1 << (n - 1)), n - 1);
	}
}