package Day1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15787 {
// 부분집합을 모두 출력하라!
// {A,B,C,D,E} => n = 5

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int train[] = new int[100000];
		int obj, idx, x;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			obj = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken())-1;
			if (obj == 1) {
				x = 20 - Integer.parseInt(st.nextToken());
				if((train[idx] & (1<<x)) == 0 ) {
					train[idx] += (1<<x);
				}
			} else if (obj == 2) {
				x = 20 - Integer.parseInt(st.nextToken());
				if((train[idx] & (1<<x)) > 0 ) {
					train[idx] -= (1<<x);
				}
			} else if (obj == 3) {
				train[idx] = train[idx]>>1;
			} else {
				if( ( train[idx] & ( 1 << 19) ) > 0){
					train[idx] -= (1<<19);
				}
				train[idx] = train[idx]<<1;
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			set.add(train[i]);
		}
		System.out.println(set.size());
	}
}
