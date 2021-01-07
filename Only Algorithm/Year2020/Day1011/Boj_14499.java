package Day1011;

import java.util.Scanner;

public class Boj_14499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int map[][] = new int[Y][X];
		int y = sc.nextInt();
		int x = sc.nextInt();
		int move = sc.nextInt();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Dice dice = new Dice();
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		int nx, ny;
		int nextInt = 0;
		int temp;
		for (int i = 0; i < move; i++) {
			nextInt = sc.nextInt()-1;
			nx = x + dx[nextInt];
			ny = y + dy[nextInt];
			if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
				continue;
			}
			if(nextInt==0) {
				temp = dice.noon[3];
				dice.noon[3] = dice.noon[1];
				dice.noon[1] = dice.noon[4];
				dice.noon[4] = dice.noon[6];
				dice.noon[6] = temp;
			}
			else if(nextInt==1) {
				temp = dice.noon[6];
				dice.noon[6] = dice.noon[4];
				dice.noon[4] = dice.noon[1];
				dice.noon[1] = dice.noon[3];
				dice.noon[3] = temp;
			}
			else if(nextInt==2) {
				temp = dice.noon[2];
				dice.noon[2] = dice.noon[1];
				dice.noon[1] = dice.noon[5];
				dice.noon[5] = dice.noon[6];
				dice.noon[6] = temp;
			}
			else{
				temp = dice.noon[6];
				dice.noon[6] = dice.noon[5];
				dice.noon[5] = dice.noon[1];
				dice.noon[1] = dice.noon[2];
				dice.noon[2] = temp;
			}
			System.out.println(dice.noon[1]);
			if(map[ny][nx] == 0) {
				map[ny][nx] = dice.noon[6];
			}
			else {
				dice.noon[6] = map[ny][nx];
				map[ny][nx] = 0;
			}
			//System.out.println(dice.noon[1]+" "+dice.noon[2]+" "+dice.noon[3]+" "+dice.noon[4]+" "+dice.noon[5]+" "+dice.noon[6]);
			x = nx;
			y = ny;
		}
	}
}

class Dice {
	int noon[] = new int[7];

	public Dice() {
		this.noon[6] = 0;
		this.noon[1] = 0;
		this.noon[2] = 0;
		this.noon[3] = 0;
		this.noon[4] = 0;
		this.noon[5] = 0;
	}

}