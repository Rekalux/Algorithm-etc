package Day1104;

import java.util.Scanner;

public class Boj_17136 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][] = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		coloring(a,0);
		System.out.println(result == 26 ? -1 : result);
	}
	static int result = 26;
	static int papersize[] = {5,5,5,5,5};
	static void coloring(int[][] paper, int idx) {
		if (idx == 100) {
			int sum = 25;
			for(int i=0;i<5;i++) {
				sum -= papersize[i];
			}
			if(result > sum) {
				result = sum;
			}
			return;
		}
		int y = idx / 10;
		int x = idx % 10;
		if (paper[y][x] == 1) {
			out: for (int size = 1; size < 6; size++) { // 1x1 색종이부터 5x5 색종이까지 붙여본다.
				if(papersize[size-1]==0) { // 그 색종이가 있나?
					continue;
				}
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if(y+i >= 10 || x+j >= 10) {
							continue out;
						}
						if (paper[y + i][x + j] == 0) { // 못 붙이는 경우
							continue out;
						}
					}
				}
				papersize[size-1]--; // 색종이 사용
				
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						paper[y + i][x + j] = 0;
					}
				}
				coloring(paper,idx+1);
				
				papersize[size-1]++; // 색종이 안사용
				
				for (int i = 0; i < size; i++) { // 원상복귀
					for (int j = 0; j < size; j++) {
						paper[y + i][x + j] = 1;
					}
				}
			}
		} else {
			coloring(paper, idx + 1);
		}
	}
}
