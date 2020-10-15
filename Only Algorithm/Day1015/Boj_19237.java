package Day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_19237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// System.out.println(n+" "+m+" "+k);
		smell smap[][] = new smell[n+1][n+1];
		ArrayList<shark> sharkmap = new ArrayList<shark>();
		int temp = 0;
		for (int i = 0; i < m+1; i++) {
			sharkmap.add(null);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp > 0) {
					sharkmap.set(temp - 1, new shark(j, i, temp));
				}
			}
		}
//	for(int i=0;i<m;i++) {
//		System.out.println(sharkmap.get(i).loc_x+" "+sharkmap.get(i).loc_y+" "+sharkmap.get(i).num);
//	}
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };
		int nx, ny;
		int nnx, nny;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			sharkmap.get(i).dir = Integer.parseInt(st.nextToken()) - 1;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int jj = 0; jj < 4; jj++) {
					sharkmap.get(i).move[j][jj] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
//	for(int i=0;i<m;i++) {
//		System.out.print(sharkmap.get(i).move[sharkmap.get(i).dir][0]+" ");
//	
//	}
//	System.out.println();

		int time = 0;
		int saveidx;
		int count;
		while (time < 1000) {
			time++;
			// 시간이 지난 냄새를 없앤다.
			for (int ii = 0; ii < n; ii++) {
				for (int jj = 0; jj < n; jj++) {
					if (smap[ii][jj] != null) {
						smap[ii][jj].timer = smap[ii][jj].timer - 1;
						if (smap[ii][jj].timer == 0) {
							smap[ii][jj] = null;
						}
					}
				}
			}
			
			for (int i = 0; i < m; i++) {// 현재 자리에 냄새를 뿌린다.
				if (!sharkmap.get(i).live) {
					continue;
				}
				ny = sharkmap.get(i).loc_y;
				nx = sharkmap.get(i).loc_x;
				smap[ny][nx] = new smell(sharkmap.get(i).num, k);
			}
			
			for (int i = 0; i < m; i++) {
				if (!sharkmap.get(i).live) {
					continue;
				}
				ny = sharkmap.get(i).loc_y;
				nx = sharkmap.get(i).loc_x;
				
				// 상어를 차례대로 이동시킨다.
				saveidx = -1;
				for (int ii = 0; ii < 4; ii++) {
					nnx = nx + dx[sharkmap.get(i).move[sharkmap.get(i).dir][ii]];
					nny = ny + dy[sharkmap.get(i).move[sharkmap.get(i).dir][ii]];
					if (nnx < 0 || nny < 0 || nnx >= n || nny >= n) {
						continue;
					}
					if (smap[nny][nnx] == null) {
						sharkmap.get(i).loc_y = nny;
						sharkmap.get(i).loc_x = nnx;
						sharkmap.get(i).dir = sharkmap.get(i).move[sharkmap.get(i).dir][ii];
						saveidx = -1;
						break;
					} else if (smap[nny][nnx].num == sharkmap.get(i).num && saveidx == -1) {// 자기 냄새 방향을 저장해둔다.
						saveidx = ii;
					}
				}
				if (saveidx == -1) { // 찾았으면 다른상어 이동
					continue;
				} else { // 못찾았으면 자기 방향 가고 다른 상어 이동
					sharkmap.get(i).loc_x = nx + dx[sharkmap.get(i).move[sharkmap.get(i).dir][saveidx]];
					sharkmap.get(i).loc_y = ny + dy[sharkmap.get(i).move[sharkmap.get(i).dir][saveidx]];
					sharkmap.get(i).dir = sharkmap.get(i).move[sharkmap.get(i).dir][saveidx];
				}
			}
			// 상어가 겹치면 숫자가 높은 상어를 없앤다.
			for (int i = 0; i < m; i++) {
				if (!sharkmap.get(i).live) {
					continue;
				}
				for (int j = i + 1; j < m; j++) {
					if (sharkmap.get(j).live && sharkmap.get(i).loc_x == sharkmap.get(j).loc_x
							&& sharkmap.get(i).loc_y == sharkmap.get(j).loc_y) {
						sharkmap.get(j).live = false;
					}
				}
			}
			count = 0;
			for (int i = 0; i < m; i++) {
				if (sharkmap.get(i).live) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println(time);
				return;
			}

//		System.out.println("#"+time);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				count=0;
//				for(int ii=0;ii<m;ii++) {
//					if(sharkmap.get(ii).live && sharkmap.get(ii).loc_y == i && sharkmap.get(ii).loc_x == j) {
//						System.out.print(sharkmap.get(ii).num+" ");
//						count++;
//					}
//				}
//				if(count==0){
//					System.out.print(0+" ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();

			

		}
		System.out.println(-1);
		return;
	}
}

class shark {
	int loc_x;
	int loc_y;
	int dir;
	int num;
	boolean live = true;
	int move[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }; // 방향에 따른 움직이는 위치 위/아래/왼쪽/오른쪽

	public shark(int loc_x, int loc_y, int num) {
		super();
		this.loc_x = loc_x;
		this.loc_y = loc_y;
		this.num = num;
	}
}

class smell {
	int num;
	int timer;

	public smell(int num, int timer) {
		super();
		this.num = num;
		this.timer = timer;
	}
}