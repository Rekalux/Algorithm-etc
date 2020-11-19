package Day1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		boxnum[][] box = new boxnum[y][x];
		for(int i=0;i<y;i++) {
			st = new StringTokenizer(br.readLine());
			int nusukhap = 0;
			for(int j=0;j<x;j++) {
				int getnum = Integer.parseInt(st.nextToken());
				nusukhap += getnum;
				box[i][j] = new boxnum(getnum,nusukhap,Integer.MIN_VALUE);
			}
		}
		for(int i=0;i<x;i++) { // 맨위의 경로최대값 채워넣기
			box[0][i].max = box[0][i].line; // 첫 줄은 누적합이 곧 경로최대값
		}
		for(int i=1;i<y;i++) {
			for(int j=0;j<x;j++) {
				for(int k=0;k<x;k++) {
					
					// 윗 라인에서 각각의 최대경로 + 그 위치에서 현재 위치까지의 합
					// 현재위치까지의 합 = j와 k중 작은 값을 선택해 작은 값-1 는 빼고 큰 값의 인덱스는 더해주고
					// 원래 있던 값과 비교해서 더 크면 바꿔주기
					
					int temp = box[i-1][k].max; //윗 라인 최대경로
					int minnum = Math.min(j, k)-1; // 더 작은 인덱스
					int maxnum = Math.max(j, k); // 더 큰 인덱스
					int linemax = minnum < 0 ? box[i][maxnum].line : (box[i][maxnum].line - box[i][minnum].line);
					// minnum이 음수이면 단지 line이 현재위치까지의 합
					// 그 외에는 더 큰 인덱스에서 작은 인덱스 - 1까지의 합을 빼줌
					box[i][j].max = Math.max( box[i][j].max , temp + linemax); // 계산값과 이전값을 비교해서 큰 값을 저장
				}
			}
		}
//		for(int i=0;i<y;i++) {
//			for(int j=0;j<x;j++) {
//				System.out.print(box[i][j].max+" ");
//			}
//			System.out.println();
//		}
		System.out.println(box[y-1][x-1].max);
	}
	static class boxnum{
		int map; // 원래 받아온 값
		int line; // 가로 누적합
		int max; // 현재위치까지 오는 최대의 값
		public boxnum() {};
		public boxnum(int map,int line,int max) {
			this.map = map;
			this.line = line;
			this.max = max;
		}
	}
}
