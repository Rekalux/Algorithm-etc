package Day1013;

import java.util.Scanner;

public class Boj_2965 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a=sc.nextInt();
	int b=sc.nextInt();
	int c=sc.nextInt();
	System.out.println(b-a<c-b ? c-b-1 : b-a-1);
}
}
