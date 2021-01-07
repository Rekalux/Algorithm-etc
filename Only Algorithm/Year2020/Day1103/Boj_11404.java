package Day1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = i == j ? 0 : 999999999;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());
			if (a[start][end] > dis) {
				a[start][end] = dis;
			}
		}
		for (int time = 0; time < n; time++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					for (int ii = 0; ii < n; ii++) {
						if (a[i][j] > a[i][ii] + a[ii][j]) {
							a[i][j] = a[i][ii] + a[ii][j];
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print((a[i][j] == 999999999 ? 0 : a[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
