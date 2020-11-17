package Day1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1725 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<int[]> s= new Stack<int[]>();
		int[] start = {0,0}; // 시작값은 0, 0
		int result = 0; // 최대값 저장할 변수
		s.add(start);
		for(int i=1;i<n+2;i++) { // 왼쪽 오른쪽에 0 삽입 (처음과 마지막 큐 연산 처리 위해서)
			if(n+1 == i) { // 마지막의 경우만
				while(s.peek()[0] > 0) { // 스택의 탑에 있는 숫자와 들어온 숫자 비교 (탑이 더 크면)
					int[] squere = s.pop();
					result = Math.max(result, (i - squere[1]) * squere[0]); // 넓이를 구하고 최대값이면 저장
				}
				continue; // == break
			}
			int get[] = {Integer.parseInt(br.readLine()), i}; // 받은 숫자와 인덱스를 같이 저장
			while(s.peek()[0] > get[0]) { // 스택의 탑에 있는 숫자와 들어온 숫자 비교 (탑이 더 크면)
				int[] squere = s.pop();
				result = Math.max(result, (i - squere[1]) * squere[0]); // 넓이를 구하고 최대값이면 저장
				get[1] = squere[1]; // 만약 바뀌었다면 현재 숫자로 가장 긴 길이를 저장해둔다. 3 4 2 3 -> 2*4가 가장 길다. 즉 (2,0) 저장
			}
			s.add(get);
			
		}
		System.out.println(result);
	}
}
