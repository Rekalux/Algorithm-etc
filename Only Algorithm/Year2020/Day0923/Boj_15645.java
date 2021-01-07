package Day0923;

import java.util.Scanner;

public class Boj_15645 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			int maxmap[][] = new int[2][3];
			int minmap[][] = new int[2][3];
			for (int j = 0; j < 3; j++) {
				maxmap[0][j] = sc.nextInt();
				minmap[0][j] = maxmap[0][j];
			}
			for (int i = 1; i < num; i++) {
				maxmap[1][0] = sc.nextInt();
				minmap[1][0] = maxmap[1][0];
				maxmap[1][0] += Math.max(maxmap[0][0], maxmap[0][1]);
				minmap[1][0] += Math.min(minmap[0][0], minmap[0][1]);
			
				maxmap[1][1] = sc.nextInt();
				minmap[1][1] = maxmap[1][1];
				maxmap[1][1] += Math.max(maxmap[0][0], Math.max(maxmap[0][1], maxmap[0][2]));
				minmap[1][1] += Math.min(minmap[0][0], Math.min(minmap[0][1], minmap[0][2]));
				
				maxmap[1][2] = sc.nextInt();
				minmap[1][2] = maxmap[1][2];
				maxmap[1][2] += Math.max(maxmap[0][1], maxmap[0][2]);
				minmap[1][2] += Math.min(minmap[0][1], minmap[0][2]);
				
				maxmap[0][0] = maxmap[1][0];
				minmap[0][0] = minmap[1][0];
				maxmap[0][1] = maxmap[1][1];
				minmap[0][1] = minmap[1][1];
				maxmap[0][2] = maxmap[1][2];
				minmap[0][2] = minmap[1][2];
			}
			System.out.println(Math.max(maxmap[0][0], Math.max(maxmap[0][1], maxmap[0][2])) + " "
					+ Math.min(minmap[0][0], Math.min(minmap[0][1], minmap[0][2])));
		}
}
