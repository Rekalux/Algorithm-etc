package Day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int min = Integer.MAX_VALUE;
		int a[] = new int[100000];
		int hap = 0;
		for (int i = 0; i < n; i += 2) {
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			a[i] = front;
			a[i + 1] = back;
			hap += back;
		}

		result = hap;
		int sum = a[0];
		int temp = 0;
		for (int i = 1; i < n; i++) {
			if (i % 2 == 1) {
				temp = sum + hap - a[n - 1];
				hap -= a[i];
			} else {
				temp = sum + hap;
				sum += a[i];
			}
			if (temp > result) {
				result = temp;
			}
		}
		System.out.println(result);
	}
}
