package Day0919;

import java.util.Scanner;

public class Boj_2578 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num[][] = new int[5][5]; // 빙고판을 만든다.
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			num[i][j] = sc.nextInt(); // 빙고판을 하나씩 채운다.
		}
	}
	int line = 0; // 몇 개의 빙고가 생겼는 지 확인할 수
	int turn = 0; // 몇 번째 수인지 확인할 변수
	while(line < 3) {
		turn++; // 수가 들어올 때마다의 회수를 센다.
		int temp = sc.nextInt(); // 색칠할 수를 가져온다.
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(num[i][j] == temp) { // 받아온 수를 빙고판에서 찾는다.
					num[i][j] = 0; // 0으로 색칠한다.
				}	
			}
		}
		line = test(num);
	}
	System.out.println(turn);
}

public static int test(int num[][]) {
	int line = 0;
	for(int i=0;i<5;i++) {
		int count = 0; // 확인할 라인이 전부 0인지 확인하기 위한 수
		for(int j=0;j<5;j++) { // 가로확인
			if(num[i][j]==0) {
				count++;
			}
		}
		if(count==5) {
			line++;
		}
		count = 0; // 초기화
		for(int j=0;j<5;j++) { //세로확인
			if(num[j][i]==0) {
				count++;
			}
		}
		if(count==5) {
			line++;
		}
	}
	int count = 0;
	for(int i=0;i<5;i++) { // 대각선테스트
		if(num[i][i]==0) {
			count++;
		}
	}
	if(count==5) {
		line++;
	}
	
	count = 0;
	for(int i=0;i<5;i++) {
		if(num[4-i][i]==0) {
			count++;
		}
	}
	if(count==5) {
		line++;
	}
	
	return line;
}
}
