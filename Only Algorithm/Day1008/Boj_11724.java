package Day1008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_11724 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a[] = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			a[i] = i;
		}
		int x, y, m, n;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if (a[x] < a[y]) {
				m = a[y];
				n = a[x];
			} else {
				m = a[x];
				n = a[y];
			}
			for (int j = 1; j < N + 1; j++) {
				if (a[j] == m) {
					a[j] = n;
				}
			}
		}
		int b[] = new int[1001];
		for (int i = 1; i < N + 1; i++) {
			b[a[i]] = 1;
		}
		int result = 0;
		for (int i = 0; i < 1001; i++) {
			if (b[i] == 1) {
				result++;
			}
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
