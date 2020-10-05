package Day1005;

import java.util.Scanner;

public class Boj_2630 {
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 입력값 받기
		
		cut(N,0,0);
		
		System.out.println(white);
		System.out.println(blue);
	}
	static int white = 0;
	static int blue = 0;
	static void cut(int N,int x,int y) {
		// 역할 : 정사각형인지 확인하고 아니면 4등분
		// 재귀는 내가만든 함수가 이미 잘 돌아간다고 가정하고 만들어야 해
		
		// 1. count로 2중 for문 돌면서 0, N^2 인지 확인
		int count = 0;
		for(int i=x;i<x+N;i++) {
			for(int j=y;j<y+N;j++) {
				count += board[i][j];
			}
		}
		// 2. count 값이 0이면 화이트증가
		if(count == 0) {
			white++;
			return;
		}
		// 3. count 값이 N^2이면 블루증가
		if(count == N*N) {
			blue++;
			return;
		}
		
		// 4. 그 외의 count 값이면 4부분으로 잘라서 재귀함수 호출
		cut(N/2,x,y);
		cut(N/2,x+N/2,y);
		cut(N/2,x,y+N/2);
		cut(N/2,x+N/2,y+N/2);
	}
}
