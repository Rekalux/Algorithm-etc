package algo;

import java.util.Scanner;

public class Boj_14890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), l = sc.nextInt();
		int a[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		boolean road[][] = new boolean[n][n];
		out : for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j==n-1) {
					
					result++;
					continue;
				}
				if (a[i][j] != a[i][j + 1]) {// 뒤랑 다르면 어떻게 다른지 확인
					if (a[i][j] == a[i][j + 1] + 1) { // 오른쪽이 낮으면
						int jj = 0;
						while (true) { // 오른쪽으로 가면서 놓을 수 있는 지 확인
							if(j + 1 + jj >= n || a[i][j + 1] != a[i][j + 1 + jj] || road[i][j+1+jj]) {
								continue out; // 안되면 다음 가로 확인
							}
							road[i][j + 1 + jj] = true; // 경사로 설치
							jj++;
							if(jj>=l) {
								break;
							}
						}
					}
					else if (a[i][j] == a[i][j + 1] - 1) { // 왼쪽이 낮으면
						//System.out.println(j);
						int jj = 0;
						while (true) { // 왼쪽으로 가면서 놓을 수 있는 지 확인
							if(j + jj < 0 || a[i][j] != a[i][j + jj] || road[i][j+jj]) {
								continue out; // 안되면 다음 가로 확인
							}
							road[i][j+ jj] = true; // 경사로 설치
							jj--;
							if((-jj)>=l) {
								break;
							}
						}
					}
					else {
						continue out;
					}
					
				}
			}
		}
		//System.out.println(result);
		road = new boolean[n][n];
		out : for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if(i==n-1) {
					//System.out.println(j);
					result++;
					continue;
				}
				if (a[i][j] != a[i+1][j]) {// 뒤랑 다르면 어떻게 다른지 확인
					//System.out.println(j+" "+a[i][j]+" "+a[i+1][j]);
					if (a[i][j] == a[i+1][j] + 1) { // 오른쪽이 낮으면
						int ii = 0;
						while (true) { // 오른쪽으로 가면서 놓을 수 있는 지 확인
							if(i + 1 + ii >= n || a[i+1][j] != a[i+ii+1][j] || road[i+1+ii][j]) {
								continue out; // 안되면 다음 가로 확인
							}
							road[i+1+ii][j] = true; // 경사로 설치
							ii++;
							if(ii>=l) {
								break;
							}
						}
					}
					else if (a[i][j] == a[i+1][j] - 1) { // 왼쪽이 낮으면
						//System.out.println(j);
						int ii = 0;
						while (true) { // 왼쪽으로 가면서 놓을 수 있는 지 확인
							if(i + ii < 0 || a[i][j] != a[i+ii][j] || road[i+ii][j]) {
								continue out; // 안되면 다음 가로 확인
							}
							road[i+ii][j] = true; // 경사로 설치
							ii--;
							if((-ii)>=l) {
								break;
							}
						}
					}
					else {
						continue out;
					}
				}
			}
		}
		System.out.println(result);
	}
}
