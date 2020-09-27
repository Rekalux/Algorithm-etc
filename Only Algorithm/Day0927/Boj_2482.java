package Day0927;

import java.util.Scanner;

public class Boj_2482 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int num[][] = new int[k][n+1];
		for(int i=0;i<k;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0) {
					num[i][j] = j;
				}
				else if(j-2>=0 && j>=(i+1)*2) {
					num[i][j] = (num[i][j-1] + num[i-1][j-2])%1000000003;
				}
			}
		}
		System.out.println(num[k-1][n]);
	}
}
