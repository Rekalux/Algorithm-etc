package Day0920;

import java.util.Scanner;

public class Boj_2564 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int num = sc.nextInt();
		int point[][] = new int[num][2];
		for (int i = 0; i < num; i++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}
		int xdir = sc.nextInt();
		int xobj = sc.nextInt();

		// 입력받기 끝

		int total = 0;
		for (int i = 0; i < num; i++) {

			if (point[i][0] == xdir) {
				total += Math.abs(point[i][1] - xobj); // 같은 경우
			}

			else if (xdir == 1) {

				if (point[i][0] == 2) {
					int a = xobj + point[i][1] + y; // a는 왼쪽경로
					int b = 2 * x - xobj - point[i][1] + y; // b는 오른쪽경로
					total += Math.min(a, b);
				}
				else if (point[i][0] == 3) {
					total += point[i][1] + xobj;
				}
				else if (point[i][0] == 4) {
					total += point[i][1] + x - xobj;
				}

			}

			else if (xdir == 2) {
				
				if (point[i][0] == 1) {
					int a = xobj + point[i][1] + y; // a는 왼쪽경로
					int b = 2 * x - xobj - point[i][1] + y; // b는 오른쪽경로
					total += Math.min(a, b);
				}
				else if (point[i][0] == 3) {
					total += y-point[i][1] + xobj;
				}
				else if (point[i][0] == 4) {
					total += y-point[i][1] + x - xobj;
				}

			}

			else if (xdir == 3) {
				if (point[i][0] == 1) {
					total += point[i][1] + xobj;
				}
				else if (point[i][0] == 2) {
					total += point[i][1] + y - xobj;
				}
				else if(point[i][0] == 4) {
					int a = xobj + point[i][1] + x; // a는 왼쪽경로
					int b = 2 * y - xobj - point[i][1] + x; // b는 오른쪽경로
					total += Math.min(a, b);
				}
			}

			else if (xdir == 4) {
				if (point[i][0] == 1) {
					total += x-point[i][1] + xobj;
				}
				else if (point[i][0] == 2) {
					total += x-point[i][1] + y - xobj;
				}
				else if(point[i][0] == 3) {
					int a = xobj + point[i][1] + x; // a는 왼쪽경로
					int b = 2 * y - xobj - point[i][1] + x; // b는 오른쪽경로
					total += Math.min(a, b);
				}
			}
		}
		System.out.println(total);
	}
}
