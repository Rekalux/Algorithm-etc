package Day1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int i = 0;
		int j = 0;
		int now = 0;
		int result = 100001;
		int a[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int ii = 0; ii < N; ii++) {
			a[ii] = Integer.parseInt(st.nextToken());
		}
		while (j < N) { // 범위가 지나치면 끝
			now += a[j];
			while(now >= S && j>=i) { // 목적 수를 넘겼다면 왼쪽 인덱스 당겨오기
				if(result > j-i+1) {
					result = j-i+1;
				}
				now -= a[i];
				i++;
			}
			j++;
		}
		System.out.println(result==100001 ? 0 : result);
	}
}
