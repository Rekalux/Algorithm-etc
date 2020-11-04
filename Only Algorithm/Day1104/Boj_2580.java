package Day1104;

import java.util.Scanner;

public class Boj_2580 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sudoku = new int[9][9];
		dap = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}

		solve(sudoku);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(dap[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int sudoku[][];
	static int dap[][];

	static void solve(int pan[][]) {
		if(dap[0][0]!=0) {
			return;
		}
		int newsudoku[][] = new int[9][9];
		int findx = -1, findy = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newsudoku[i][j] = pan[i][j];
				if (newsudoku[i][j] == 0 && findx==-1 && findy==-1) {
					findx = j;
					findy = i;
				}
			}
		}
		if (findx == -1 && findy == -1) {
			dap = newsudoku;
			return;
		}
		out: for (int i = 1; i <= 9; i++) { // i라는 수에 대해서
			for (int j = 0; j < 9; j++) {
				if (newsudoku[j][findx] == i) {
					continue out;
				}
				if (newsudoku[findy][j] == i) {
					continue out;
				}
			}
			int findblockx = findx / 3;
			int findblocky = findy / 3;
			for (int y = findblocky * 3; y < findblocky * 3+3; y++) {
				for (int x = findblockx * 3; x < findblockx * 3+3; x++) {
					if(newsudoku[y][x] == i) {
						continue out;
					}
				}
			}
			newsudoku[findy][findx] = i;
			solve(newsudoku);
			if(dap[0][0]!=0) {
				return;
			}
			newsudoku[findy][findx] = 0;
		}

	}

}
