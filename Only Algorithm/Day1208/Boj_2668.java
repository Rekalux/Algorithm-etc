package Day1208;

import java.util.HashSet;
import java.util.Scanner;

public class Boj_2668 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		result = new boolean[n+1];
		
		for(int i=1;i<n+1;i++) {
			start = i;
			set = new HashSet<Integer>();
			set.add(i);
			dfs(i);
		}
		int count = 0;
		for(int i=1;i<=n;i++) {
			if(result[i]) {
				count++;
			}
		}
		System.out.println(count);
		for(int i=1;i<=n;i++) {
			if(result[i]) {				
				System.out.println(i);
			}
		}
	}
	static int start = 0;
	static HashSet<Integer> set;
	static int a[];
	static boolean result[];
	static void dfs(int idx) {
		// 사이클이면 끝낸다.
		if(a[idx]==start) {
			for(int k : set) {
				result[k] = true;
			}
			return;
		}
		// 돌릴 수 없는 상황이면 풀린다.
		if(set.contains(a[idx])) {
			return;
		}
		// 다음 인덱스 방문처리
		set.add(a[idx]);
		// 다음 인덱스 dfs
		dfs(a[idx]);
	}
}
