package Day1003;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += a[i]*(n-i);
		}
		System.out.println(sum);
	}
}
