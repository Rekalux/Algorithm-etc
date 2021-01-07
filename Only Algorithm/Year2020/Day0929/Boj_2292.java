package Day0929;

import java.util.Scanner;

public class Boj_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Count.execute(N));
	}
}
class Count {
	public static int execute(int N) {
		int i=0;
		int sum = 0;
		for (i = 0; sum < N; i++) {
			sum = 3 * i * (i  + 1) + 1;
		}
		return i;
	}

	

}
