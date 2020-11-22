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
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(cube[i][j][0]);
				}
				System.out.println();
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
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[i][j][swit] = paper[i][j];
			}
		}
		if(swit==0 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[0][i][3];
				cube[0][i][3] = cube[0][i][4];
				cube[0][i][4] = cube[0][i][2];
				cube[0][i][2] = cube[0][i][5];
				cube[0][i][5] = tempnum;
			}
		}
		else if(swit==0 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[0][i][3];
				cube[0][i][3] = cube[0][i][5];
				cube[0][i][5] = cube[0][i][2];
				cube[0][i][2] = cube[0][i][4];
				cube[0][i][4] = tempnum;
			}
		}
		else if(swit==1 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[2][i][3];
				cube[2][i][3] = cube[2][i][5];
				cube[2][i][5] = cube[2][i][2];
				cube[2][i][2] = cube[2][i][4];
				cube[2][i][4] = tempnum;
			}
		}
		else if(swit==1 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[2][i][3];
				cube[2][i][3] = cube[2][i][4];
				cube[2][i][4] = cube[2][i][2];
				cube[2][i][2] = cube[2][i][5];
				cube[2][i][5] = tempnum;
			}
		}
		else if(swit==2 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[2][i][0];
				cube[2][i][0] = cube[2-i][2][4];
				cube[2-i][2][4] = cube[2][i][1];
				cube[2][i][1] = cube[i][0][5];
				cube[i][0][5] = tempnum;
			}
		}
		else if(swit==2 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[2][i][0];
				cube[2][i][0] = cube[i][0][5];
				cube[i][0][5] = cube[2][i][1];
				cube[2][i][1] = cube[2-i][2][4];
				cube[2-i][2][4] = tempnum;
			}
		}
		else if(swit==3 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[0][i][0];
				cube[0][i][0] = cube[i][2][5];
				cube[i][2][5] = cube[0][i][1];
				cube[0][i][1] = cube[2-i][0][4];
				cube[2-i][0][4] = tempnum;
			}
		}
		else if(swit==3 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[0][i][0];
				cube[0][i][0] = cube[2-i][0][4];
				cube[2-i][0][4] = cube[0][i][1];
				cube[0][i][1] = cube[i][2][5];
				cube[i][2][5] = tempnum;
			}
		}
		else if(swit==4 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[i][0][0];
				cube[i][0][0] = cube[2-i][2][3];
				cube[2-i][2][3] = cube[2-i][2][1];
				cube[2-i][2][1] = cube[i][0][2];
				cube[i][0][2] = tempnum;
			}
		}
		else if(swit==4 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[i][0][0];
				cube[i][0][0] = cube[i][0][2];
				cube[i][0][2] = cube[2-i][2][1];
				cube[2-i][2][1] = cube[2-i][2][3];
				cube[2-i][2][3] = tempnum;
			}
		}
		else if(swit==5 && landr==0) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[i][2][0];
				cube[i][2][0] = cube[i][2][2];
				cube[i][2][2] = cube[2-i][0][1];
				cube[2-i][0][1] = cube[2-i][0][3];
				cube[2-i][0][3] = tempnum;
			}
		}
		else if(swit==5 && landr==1) {
			char tempnum;
			for(int i=0;i<3;i++) {
				tempnum = cube[i][2][0];
				cube[i][2][0] = cube[2-i][0][3];
				cube[2-i][0][3] = cube[2-i][0][1];
				cube[2-i][0][1] = cube[i][2][2];
				cube[i][2][2] = tempnum;
			}
		}
	}
}
