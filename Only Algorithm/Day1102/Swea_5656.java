package Day1102;

import java.util.Scanner;

public class Swea_5656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			shot = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			result = Integer.MAX_VALUE;
			int block[][] = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					block[i][j] = sc.nextInt();
				}
			}
			breaking(block, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	static int shot, x, y;
	static int count, result;

	static void breaking(int[][] block, int n) {
		if (n == shot) {
			count = 0;
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (block[i][j] != 0) {
						count++;
					}
				}
			}

//			for (int i = 0; i < y; i++) {
//				for (int j = 0; j < x; j++) {
//					System.out.print(block[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			if (result > count) {
				result = count;
			}
			return;
		}

		for (int xx = 0; xx < x; xx++) {
			int[][] newblock = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					newblock[i][j] = block[i][j];
				}
			}
			bomb(newblock, xx);
			breaking(newblock, n + 1);
		}
	}

	static void bomb(int[][] newblock, int line) {
//		if (line == 2) {
//			for (int i = 0; i < y; i++) {
//				for (int j = 0; j < x; j++) {
//					System.out.print(newblock[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		int floor = 0;
		while (newblock[floor][line] == 0) {
			floor++;
			if (floor >= y) {
				return;
			}
		}
		thebox(newblock, line, floor);
		down(newblock);
	}

	static void thebox(int block[][], int thex, int they) {
		int renum = block[they][thex];
		block[they][thex] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < renum; j++) {
				int ny = dy[i] * j + they;
				int nx = dx[i] * j + thex;
				if (ny < 0 || nx < 0 || ny >= y || nx >= x) {
					continue;
				}
				if (block[ny][nx] == 0) {
					continue;
				}
//				if (2 == they && 2 == thex) {
//				for (int ii = 0; ii < y; ii++) {
//					for (int jj = 0; jj < x; jj++) {
//						System.out.print(block[ii][jj] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
				thebox(block, nx, ny);
			}

		}
	}

	static void down(int block[][]) {
		for (int i = y - 2; i >= 0; i--) {
			for (int j = 0; j < x; j++) {
				if (block[i][j] == 0) {
					continue;
				}
				int floor = i + 1;
				while (block[floor][j] == 0) {
					floor++;
					if (floor >= y) {
						break;
					}
				}
				int temp = block[i][j];
				block[i][j] = 0;
				block[floor - 1][j] = temp;
			}
		}
	}

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
}
