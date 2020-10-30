package algo;

import java.util.Scanner;

public class Swea_6109 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int dx[] = {0,0,-1,1};
		int dy[] = {-1,1,0,0};
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#"+tc);
			int n =  sc.nextInt();
			String s = sc.next();
			int a[][] = new int[n][n];
			int ii,jj;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int dir = 0;
			if(s.equals("up")) {
				dir = 0;
			}
			else if (s.equals("down")) {
				
				dir = 1;
			}
			else if(s.equals("left")) {
				dir = 2;
			}
			else{
				dir = 3;
			}
			boolean visit[][] = new boolean[n][n];
			int saveii,savejj;
			int temp;
			
			if(dir == 0) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(a[i][j] !=0) {
							ii = i + dy[dir];
							jj = j + dx[dir];
							saveii = i;
							savejj = j;
							while(true) { // 범위안에 있는 동안
								if(ii<0 || ii>=n || jj<0 || jj>=n) {
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj] = temp;
								}
								else if(a[ii][jj]==0) { // 0이 아닌 수를 찾음
									saveii = ii;
									savejj = jj;
									ii = ii + dy[dir];
									jj = jj + dx[dir];
									continue;
								}
								else if(visit[ii][jj]){ // 그 수는 합쳐진 곳?
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								else if(a[ii][jj] == a[i][j]){ // 합칠 수 있는 곳?
									a[i][j] = 0;
									visit[ii][jj] = true;
									a[ii][jj] *= 2;
								}
								else { // 그 외의 경우
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								break;
							}
						}
					}
				}
			}
			else if(dir==1){
				for(int i=n-1;i>=0;i--) {
					for(int j=0;j<n;j++) {
						if(a[i][j] !=0) {
							ii = i + dy[dir];
							jj = j + dx[dir];
							saveii = i;
							savejj = j;
							while(true) { // 범위안에 있는 동안
								if(ii<0 || ii>=n || jj<0 || jj>=n) {
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj] = temp;
								}
								else if(a[ii][jj]==0) { // 0이 아닌 수를 찾음
									saveii = ii;
									savejj = jj;
									ii = ii + dy[dir];
									jj = jj + dx[dir];
									continue;
								}
								else if(visit[ii][jj]){ // 그 수는 합쳐진 곳?
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								else if(a[ii][jj] == a[i][j]){ // 합칠 수 있는 곳?
									a[i][j] = 0;
									visit[ii][jj] = true;
									a[ii][jj] *= 2;
								}
								else { // 그 외의 경우
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								break;
							}
						}
					}
				}
			}
			else if(dir==2) {
				for(int j=0;j<n;j++) {
					for(int i=0;i<n;i++) {
						if(a[i][j] !=0) {
							ii = i + dy[dir];
							jj = j + dx[dir];
							saveii = i;
							savejj = j;
							while(true) { // 범위안에 있는 동안
								if(ii<0 || ii>=n || jj<0 || jj>=n) {
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj] = temp;
								}
								else if(a[ii][jj]==0) { // 0이 아닌 수를 찾음
									saveii = ii;
									savejj = jj;
									ii = ii + dy[dir];
									jj = jj + dx[dir];
									continue;
								}
								else if(visit[ii][jj]){ // 그 수는 합쳐진 곳?
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								else if(a[ii][jj] == a[i][j]){ // 합칠 수 있는 곳?
									a[i][j] = 0;
									visit[ii][jj] = true;
									a[ii][jj] *= 2;
								}
								else { // 그 외의 경우
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								break;
							}
						}
					}
				}
			}
			else{
				for(int j=n-1;j>=0;j--) {
					for(int i=0;i<n;i++) {
						if(a[i][j] !=0) {
							ii = i + dy[dir];
							jj = j + dx[dir];
							saveii = i;
							savejj = j;
							while(true) { // 범위안에 있는 동안
								if(ii<0 || ii>=n || jj<0 || jj>=n) {
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj] = temp;
								}
								else if(a[ii][jj]==0) { // 0이 아닌 수를 찾음
									saveii = ii;
									savejj = jj;
									ii = ii + dy[dir];
									jj = jj + dx[dir];
									continue;
								}
								else if(visit[ii][jj]){ // 그 수는 합쳐진 곳?
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								else if(a[ii][jj] == a[i][j]){ // 합칠 수 있는 곳?
									a[i][j] = 0;
									visit[ii][jj] = true;
									a[ii][jj] *= 2;
								}
								else { // 그 외의 경우
									temp = a[i][j];
									a[i][j] = 0;
									a[saveii][savejj]=temp;
								}
								break;
							}
						}
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
