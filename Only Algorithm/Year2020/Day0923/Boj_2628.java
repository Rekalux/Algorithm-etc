package Day0923;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2628 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); // 가로값 받아옴
	int M = sc.nextInt(); // 세로값 받아옴
	int num = sc.nextInt(); // 자르는 횟수
	int p[][] = new int[2][num+2]; 
	p[0][1] = M; // 0은 가로자르기
	p[1][1] = N; // 1은 세로자르기
	int idx[] = new int[2];
	idx[0] = 2; //가로 자르기의 인덱스길이
	idx[1] = 2; //세로 자르기의 인덱스 길이
	for(int i =0;i<num ;i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		p[a][idx[a]] = b;
		idx[a]++;
	}
	Arrays.sort(p[0]); // 가로자르기 정렬
	Arrays.sort(p[1]); // 세로자르기 정렬
	int max[] = new int[2];
	for(int t=0;t<2;t++) { // 가로와 세로의 최대값을 각각 구한다.
		for(int i=0;i<idx[t]-1;i++) { // 각각의 인덱스만큼 돌면서
			if(max[t] < p[t][i+1]-p[t][i]) { // 차이를 구하고 최대값을 구한다.
				max[t] = p[t][i+1]-p[t][i];
			}
		}
	}
	System.out.println(max[0] * max[1]);
}
}
