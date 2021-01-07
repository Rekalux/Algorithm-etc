package Day1011;

import java.util.Scanner;

public class Boj_14720 {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int milk = 0;
		int input = 0;
		for(int i=0;i<n;i++){
			input = sc.nextInt();
			if(milk == input) {
				milk = (milk+1)%3;
				count++;
			}
		}
		System.out.println(count);
	}
	
}
