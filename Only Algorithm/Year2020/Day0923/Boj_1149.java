package Day0923;

import java.util.Scanner;

public class Boj_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int h[][] = new int [num][6];
		for(int i=0;i<num;i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			if(i==0) {
				h[i][0] = r;
				h[i][1] = g;
				h[i][2] = b;
			}
			else if(i%2==1) {
				h[i][0]=h[i-1][0]+g;
				h[i][1]=h[i-1][0]+b;
				h[i][2]=h[i-1][1]+r;
				h[i][3]=h[i-1][1]+b;
				h[i][4]=h[i-1][2]+r;
				h[i][5]=h[i-1][2]+g;
			}
			else{
				h[i][0] = Math.min(h[i-1][0], Math.min(h[i-1][1], Math.min(h[i-1][3], h[i-1][5])))+r;
				h[i][1] = Math.min(h[i-1][1], Math.min(h[i-1][2], Math.min(h[i-1][3], h[i-1][4])))+g;
				h[i][2] = Math.min(h[i-1][0], Math.min(h[i-1][2], Math.min(h[i-1][4], h[i-1][5])))+b;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<6;i++) {
			if(h[num-1][i] < min && 0 < h[num-1][i]) {
				min = h[num-1][i];
			}
		}
		System.out.println(min);
	}
}
