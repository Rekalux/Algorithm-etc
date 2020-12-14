package Day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2169_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		boxnum[][] box = new boxnum[y][x];
		for(int i=0;i<y;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				int getnum = Integer.parseInt(st.nextToken());
				box[i][j] = new boxnum(getnum,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
			}
		}
		for(int i=0;i<y;i++) {
			if(i==0) { // 맨 윗줄은 따로 처리
				box[i][0].max = box[i][0].map;
				for(int j=1;j<x;j++) {
					box[i][j].max = box[i][j-1].max + box[i][j].map;
				}
				continue;
			}
			box[i][0].left = box[i-1][0].max+ box[i][0].map;
			for(int j=1;j<x;j++) { //왼쪽부터 확인
				box[i][j].left = Math.max(box[i-1][j].max, box[i][j-1].left)+ box[i][j].map;
			}
			box[i][x-1].right = box[i-1][x-1].max+ box[i][x-1].map;
			for(int j=x-2;j>=0;j--) {
				box[i][j].right = Math.max(box[i][j+1].right, box[i-1][j].max)+ box[i][j].map;
			}
			for(int j=0;j<x;j++) {
				box[i][j].max = Math.max(box[i][j].left, box[i][j].right);
			}
		}
//		for(int i=0;i<y;i++) {
//			for(int j=0;j<x;j++) {
//				System.out.print(box[i][j].right+" ");
//			}
//			System.out.println();
//		}
		System.out.println(box[y-1][x-1].max);
	}
	static class boxnum{
		int map; // 원래 받아온 값
		int left; // 왼쪽에서 오는 경우 최대의 값
		int right; // 오른쪽에서 오는 경우 최대의 값
		int max; // 현재위치까지 오는 최대의 값
		public boxnum() {}
		public boxnum(int map, int left, int right, int max) {
			super();
			this.map = map;
			this.left = left;
			this.right = right;
			this.max = max;
		};
	}
}
