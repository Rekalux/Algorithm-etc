package Day1106;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_15685 {
	
	static ArrayList<Integer> dirlist[];
	static int a[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int x,y,dir;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		a = new int[102][102];
		
		dirlist = new ArrayList[4]; // 움직이는 방법에 대한 각 리스트를 저장해둔다.
		for(int k=0;k<4;k++) {
			dirlist[k] = new ArrayList<Integer>();
			dirlist[k].add(k);
			for(int i=0;i<10;i++) {
				int saveidx = dirlist[k].size();
				for (int ii = saveidx - 1; ii >= 0; ii--) {
					dirlist[k].add((dirlist[k].get(ii) + 1) % 4);
				}
			}
		}
		
		for (int i = 0; i < m; i++) { // 위치, 방향 세대를 받아온다.
			x = sc.nextInt();
			y = sc.nextInt();
			dir = sc.nextInt();
			int gene = sc.nextInt();
			
			dragon(0, gene, a); // 움직인다.
		}
		
		int result = 0;
		for (int i = 0; i < 100; i++) { // 각각의 2x2 박스가 1인지 확인
			con: for (int j = 0; j < 100; j++) {
				for (int ii = i; ii < i + 2; ii++) {
					for (int jj = j; jj < j + 2; jj++) {
						if (a[ii][jj] == 0) {
							continue con;
						}
					}
				}
				result++;
			}
		}
		
		System.out.println(result);
	}

	static void dragon(int diridx, int gene, int[][] a) { // 움직임
		if (gene == 0) {
			a[y][x] = 1;
			x = x + dx[dirlist[dir].get(diridx)];
			y = y + dy[dirlist[dir].get(diridx)];
			a[y][x] = 1;
			return;
		}
		dragon(diridx * 2, gene - 1, a); //힙구조임을 이용해 2번 실행한다.
		dragon(diridx * 2 + 1, gene - 1, a);
	}
}
