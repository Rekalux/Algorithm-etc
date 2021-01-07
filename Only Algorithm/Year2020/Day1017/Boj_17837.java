package Day1017;

import java.util.Scanner;

public class Boj_17837 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		mal m[] = new mal[k];
		for (int i = 0; i < k; i++) {
			m[i] = new mal();
			m[i].y = sc.nextInt() - 1;
			m[i].x = sc.nextInt() - 1;
			m[i].dir = sc.nextInt() - 1;
		}
		int t = 0;
		int count=0;
		int cnt[][]= new int[n][n];
		int nx, ny, j,jj,jjj;
		int savetemp;
		while (t < 1000) {
			t++;

			for (int i = 0; i < k; i++) { // 0번 부터 차례대로 움직인다.
				nx = m[i].x + dx[m[i].dir];
				ny = m[i].y + dy[m[i].dir];
				if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) { // 벽이거나 파란색
					if (m[i].dir < 2) {
						m[i].dir = 1 - m[i].dir;
					} else if (m[i].dir >= 2) {
						m[i].dir = 5 - m[i].dir;
					}
					nx = m[i].x + dx[m[i].dir];
					ny = m[i].y + dy[m[i].dir];
				}
				if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) { // 벽이거나 파란색 2번째
					continue;
				}
				if (map[ny][nx] == 0) { // 흰색
					m[i].x = nx;
					m[i].y = ny;
					if (m[i].down != -1) {
						m[m[i].down].up = -1;
						m[i].down = -1;
					}
					for (int ii = 0; ii < k; ii++) {
						if (i == ii) {
							continue;
						}
						if (ny == m[ii].y && nx == m[ii].x && m[ii].up == -1) { // 그 위치에 있는 값 중 얹을 수 있는 값을 찾아 위에 얹는다.
							m[ii].up = i;
							m[i].down = ii;
							break;
						}
					}
					j = m[i].up;
					while (j != -1) { // 윗 숫자가 있을 때 동안 위치 이동
						m[j].x = nx;
						m[j].y = ny;
						j = m[j].up;
					}
				} else { // 빨간색
					j = i;
					while (m[j].up != -1) { // 맨 윗 숫자 찾음
						j = m[j].up;
					}
					jjj= -1;
					for (int ii = 0; ii < k; ii++) {
						if (j == ii) {
							continue;
						}
						if (ny == m[ii].y && nx == m[ii].x && m[ii].up == -1) { // 그 위치에 있는 값 중 얹을 수 있는 값을 찾아만 놓는다.
							jjj = ii;
							break;
						}
					}
					savetemp = m[i].down;
					while(j!=savetemp) { // 이 부분이 문제
						//System.out.println(m[i].down+"은 과연??");
						//System.out.println(m[j].y+" "+m[j].x+" "+m[j].dir+" "+m[j].up+" "+m[j].down);
						m[j].x = nx;
						m[j].y = ny;
						m[j].up = -1;
						jj = m[j].down;
						m[j].down = jjj;
						if(jjj!=-1) {
							m[jjj].up = j;
						}
						if(jj == -1) {
							break;
						}
						m[jj].up = -1;
						jjj = j ;
						j = jj;
						//System.out.println(j+"랑 "+m[i].down+"까지는 가야죠");
					}
					
				}
//				System.out.println("#"+t+" "+i);
//				for(int ii=0;ii<k;ii++) {
//					System.out.println(m[ii].y+" "+m[ii].x+" "+m[ii].dir+" "+m[ii].up+" "+m[ii].down);
//				}
//				System.out.println();
				
				for(int ii = 0;ii<n;ii++) {
					for(int j2=0;j2<n;j2++) {
						cnt[ii][j2]=0;
					}
				}
				for (int ii = 0; ii < k; ii++) {
					cnt[m[ii].y][m[ii].x]++;
				}
				for(int ii = 0;ii<n;ii++) {
					for(int j2=0;j2<n;j2++) {
						if(cnt[ii][j2]>=4) {
							System.out.println(t);
							return;
						}
					}
				}
			}

		}
		System.out.println(-1);

	}
}

class mal {
	int x, y;
	int up = -1;
	int down = -1;
	int dir;
}