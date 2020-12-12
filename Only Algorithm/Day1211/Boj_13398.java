package Day1211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13398 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int sum[] = new int[n];
		int elesum[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				sum[i] = a[i];
				elesum[i] = a[i];
				result = a[i];
				continue;
			}
			sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
			elesum[i] = Math.max(sum[i - 1], elesum[i - 1] + a[i]);
			result = Math.max(result, Math.max(sum[i], elesum[i]));
		}
		System.out.println(result);

	}
}