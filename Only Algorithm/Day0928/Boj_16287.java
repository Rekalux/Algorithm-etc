package Day0928;

import java.util.Scanner;

public class Boj_16287 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int num = sc.nextInt();
		int[] n = new int[num];
		for(int i=0;i<num;i++) {
			n[i] = sc.nextInt();
		}
		boolean[] sum = new boolean[800001];
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(w<n[i]+n[j]) continue;
				if(sum[n[i]+n[j]]) {
					System.out.println("YES");
					return;
				}
			}
			for(int j=0;j<i;j++) {
				if(n[i]+n[j]>=w) continue;
				sum[w-(n[i]+n[j])] = true;
			}
		}
		System.out.println("NO");
	}
}
