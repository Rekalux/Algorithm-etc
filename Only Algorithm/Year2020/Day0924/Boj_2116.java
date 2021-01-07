package Day0924;

import java.util.Scanner;

public class Boj_2116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dice[][][] = new int[num][6][2]; // 맨 앞 인덱스는 주사위개수, 중간 인덱스는 주사위의 눈개수, 마지막 인덱스는 앞 수/반대 수
		for (int i = 0; i < num; i++) { // 각 주사위를 받으면서
			for (int j = 0; j < 6; j++) { // 각 눈을 받으면서
				dice[i][j][0] = sc.nextInt();
			} // 각각의 아랫수에 대한 윗수를 저장
			dice[i][0][1] = dice[i][5][0]; // 0 - 5
			dice[i][1][1] = dice[i][3][0]; // 1 - 3
			dice[i][2][1] = dice[i][4][0]; // 2 - 4
			dice[i][3][1] = dice[i][1][0]; // 3 - 1
			dice[i][4][1] = dice[i][2][0]; // 4 - 2
			dice[i][5][1] = dice[i][0][0]; // 5 - 0
		} // 주사위 입력받음
		int max = 0;
		for (int i = 0; i < 6; i++) { // 밑면을 정하는 반복문
			int sum = 0;
			int bottom = dice[0][i][0]; // 밑면
			int top = dice[0][i][1]; // 윗면
			for (int j = 0; j < num; j++) { // 주사위를 쌓아 올리는 반복문

				for (int k = 0; k < 6; k++) { // bottom값 갱신을 위한 코드
					if (dice[j][k][0] == bottom) {
						top = dice[j][k][1];
					}
				}
				if (bottom + top == 11)
					sum += 4;
				else if (bottom == 6 || top == 6)
					sum += 5;
				else
					sum += 6;
				bottom = top;
			}
			if (max < sum) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}