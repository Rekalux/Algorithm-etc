package Day1024;

import java.util.Scanner;

public class Boj_15650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ready = new int[n];
		int arr[] = new int[m];
		for(int i=0;i<n;i++) {
			ready[i] = i+1;
		}
		find(0,0,arr);
	}
	static int n,m;
	static int[] ready;
	static void find(int s,int a,int[] arr) {
		if(a==m) {
			for(int i=0;i<m-1;i++) {
				if(arr[i] > arr[i+1]) {
					return;
				}
			}
			for(int i=0;i<m;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		if(s==n) {
			return;
		}
		arr[a] = ready[s];
		find(s+1,a+1,arr);
		find(s+1,a,arr);
	}
}