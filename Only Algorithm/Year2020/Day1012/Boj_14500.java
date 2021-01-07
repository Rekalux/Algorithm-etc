package Day1012;

import java.util.Scanner;

public class Boj_14500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int map[][] = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int dxy[][][] = // (x,y) 순서쌍으로 주어짐 
		{{{0,1},{0,2},{0,3}},{{1,0},{2,0},{3,0}},{{1,-1},{1,0},{1,1}},{{-1,-1},{-1,0},{-1,1}},{{-1,1},{0,1},{1,1}},{{-1,-1},{0,-1},{1,-1}} // 긴막대 2, ㅗ 4
		,{{1,1},{1,0},{0,1}},{{1,0},{1,1},{2,1}},{{0,1},{-1,1},{-1,2}},{{0,1},{1,1},{1,2}},{{1,0},{1,-1},{2,-1}}, // ㅁ 1, ㄹ 4
		{{-1,0},{-1,1},{-1,2}}, {{0,1},{1,1},{2,1}},{{1,0},{1,-1},{1,-2}},{{0,-1},{-1,-1},{-2,-1}}, // ㄴ 4 
		{{0,1},{-1,1},{-2,1}},{{-1,0},{-1,-1},{-1,-2}},{{0,-1},{1,-1},{2,-1}},{{1,0},{1,1},{1,2}} // ㄱ 4
		}; //도합 19개
		
		int max = 0;
		int nx,ny;
		int sum = 0;
		for(int i=0;i<Y;i++) {
			for(int j=0;j<X;j++) {
				find : for(int k=0;k<19;k++) {
					sum = map[i][j];
					for(int p=0;p<3;p++) {
						nx = j + dxy[k][p][0];
						ny = i + dxy[k][p][1];
						if(nx <0 || ny<0 || nx>=X || ny>=Y) {
							continue find;
						}
						sum += map[ny][nx];
					}
					if(sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
