package Day0919;

import java.util.Scanner;

public class Boj_2605 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int man[] = new int[num];
	for(int i=1;i<num+1;i++) {
		int I = i-1; // i번 째 사람이 들어오는 인덱스
		man[I]=i; // 현재 위치에 i번째 사람이 들어온다.
		int temp = sc.nextInt(); // 앞으로 몇 칸 갈 지 받아와서
		for(int j=0;j<temp;j++) { //  temp번 만큼 반복한다.
			man[I-1] = man[I-1] ^ man[I] ^ (man[I] = man[I-1]); // 앞의 수와 자리를 바꾼다.
			I -= 1; // 들어온 수의 위치의 인덱스를 앞으로 이동한다.
		}
	}
	for(int i=0;i<num;i++) {
		System.out.print(man[i]+" "); // 출력
	}
	
}
}
