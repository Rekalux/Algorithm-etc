package Day0919;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nanjang = new int[9];
		for(int i=0;i<9;i++) {
			nanjang[i] = sc.nextInt(); 
		}
		
		//입력받기
		
		visit = new int[7]; // 비짓배열 만들기
		
		choice(0,0); //7개를 골랐을 때, 합이 100인 경우르 찾아서 리턴
			
		for(int i=0;i<7;i++) {
				System.out.println(visit2[i]); // 저장되어 있는 배열을 차례대로 출력
		}
	}
	static int visit[]; // 찾기위한 배열
	static int visit2[]; //찾은 것을 저장해두는 배열
	static int nanjang[]; //받아온 난쟁이의 키 배열
	
	public static void choice(int S,int L) { // S개 선택, L번째 수 보고 있는 중
		if(S==7) { //선택을 7개 했다면
			int sum = 0;
			for(int i=0;i<7;i++)
			{	
					sum += nanjang[visit[i]];
			}
			if(sum==100) { //선택한 7개의 수의 합을 계산하여 100인지 확인
				visit2 = new int[7];
				for(int j=0;j<7;j++) {
					visit2[j]=nanjang[visit[j]]; //맞다면 그 배열을 저장해두고
				}
				Arrays.sort(visit2); // 그 배열을 오름차순으로 정렬
				return;
			}
		}
		if(S>=7) return; // 선택을 7개 이상 하면 더이상 선택할 필요 없음
		if(L>8) return; // 현재 보고 있는 값이 8보다 큰 수 이면 선택할 수 없음
		
		visit[S] = L; // 현재 보고 있는 위치에 값을 넣음
		
		choice(S+1,L+1); // 지금 값을 선택하는 경우
		choice(S,L+1); // 지금 값을 선택하지 않는 경우
		
	}
}
