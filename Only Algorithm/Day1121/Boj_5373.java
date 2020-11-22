package Day1121;

import java.util.Scanner;

public class Boj_5373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) { // 각 테스트케이스마다
			char cube[][][] = new char[3][3][6]; // 큐브 선언!
			for(int i=0;i<6;i++) {
				char temp='a';
				if(i==0) {
					temp  ='w';
				}else if(i==1){
					temp = 'y';
				}else if(i==2) {
					temp = 'r';
				}else if(i==3) {
					temp = 'o';
				}else if(i==4) {
					temp = 'g';
				}else if(i==5) {
					temp = 'b';
				}
				for(int ii=0;ii<3;ii++) {
					for(int jj=0;jj<3;jj++) {
						cube[ii][jj][i] = temp;
					}
				}
			}
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				int swit = 0;
				int landr = 0;
				String s = sc.next();
				char c = s.charAt(0);
				char turning = s.charAt(1);
				if(c=='U') {
					swit = 0;
				}else if(c=='D') {
					swit = 1;
				}else if(c=='F') {
					swit = 2;
				}else if(c=='B') {
					swit = 3;
				}else if(c=='L') {
					swit = 4;
				}else if(c=='R') {
					swit = 5;
				}
				if(turning == '+') {
					landr = 0;
				}
				else {
					landr = 1;
				}
				turn(cube,swit,landr);
			}
		}
		
	}
	static void turn(char[][][] cube, int swit,int landr) {
		// swit 0 은 윗면 1은 아랫면 2는 앞면 3은 뒷면 4는 왼면 5는 오른면
		//landr 0 은 시계방향 1은 반시계방향
		char[][] paper = new char[3][3];
		if(landr==0) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					paper[i][j] = cube[2-j][i][swit];
				}
			}
		}
		else if(landr==1) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					paper[i][j] = cube[j][2-i][swit];
				}
			}
		}
	}
}
