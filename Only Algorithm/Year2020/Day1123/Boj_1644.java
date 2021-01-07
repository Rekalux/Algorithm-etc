package Day1123;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean hap[] = new boolean[N + 1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < N + 1; i++) {
			if (!hap[i]) {
				list.add(i); // 소수리스트
				for (int j = 2; j * i <= N; j++) {
					hap[i * j]  = true;
				}
			}
		}
		int result = 0;
		int i = 0;
		int total = 0;
		for(int j=0;j<list.size();j++) {
			total += list.get(j);
			while(total >= N) {
				if( total == N) {
					result++;
				}
				total -= list.get(i);
				i++;
			}
		}
		System.out.println(result);
	}
}