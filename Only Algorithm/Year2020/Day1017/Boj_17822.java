package Day1017;

import java.util.Scanner;

public class Boj_17822 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int t = sc.nextInt();
	int[][] a = new int[n+1][m];
	for(int i = 1;i<n+1;i++) {
		for(int j=0;j<m;j++) {
			a[i][j] = sc.nextInt();
		}
	}
	int x,d,k;
	int move;
	int count;
	boolean check[][];
	int[] save = new int[m];
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	int nx,ny;
	int sum = 0;
	int avg=0;
	double avg_d=0;
	for(int i=0;i<t;i++) {
		x = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		if(d==0) { // 시계방향
			for(int j=x;j<n+1;j+=x) {
				for(int ii=0;ii<m;ii++) { // 이동시켜서 다른 배열에 옮겨놓기
					move = (ii + k) % m;
					save[move] = a[j][ii];
				}
				for(int ii=0;ii<m;ii++) { //저장된 배열 가져오기
					a[j][ii] = save[ii];
				}
			}
		}else if(d==1) { //반시계방향
			for(int j=x;j<n+1;j+=x) {
				for(int ii=0;ii<m;ii++) { // 이동시켜서 다른 배열에 옮겨놓기
					move = (ii - k); // 이동시켰는데 음수면
					if(move<0) {
						move += m; // 양수화 ( k<m 이므로)
					}
					save[move] = a[j][ii];
				}
				for(int ii=0;ii<m;ii++) { //저장된 배열 가져오기
					a[j][ii] = save[ii];
				}
			}
		}
		count =0; //
		check = new boolean[n+1][m];
		for(int ii=1;ii<n+1;ii++) { // 각 원판을 돌며 인접한 같은 수가 있는  지 확인
			for(int jj=0;jj<m;jj++) { // 각 수를 확인
				for(int dir=0;dir<4;dir++) { // 4방향 확인
					if(a[ii][jj] == 0) {
						continue;
					}
					nx = jj+dx[dir];
					ny = ii+dy[dir];
					if(nx<0 || ny<1 || ny>n) {
						continue;
					}
					nx = nx % m;
					if(a[ii][jj] == a[ny][nx]) {
						count++;
						check[ii][jj] = true;
						check[ny][nx] = true;
					}
				}
			}
		}
		if(count>0) { // 같은게 있다.
			for(int ii=1;ii<n+1;ii++) {
				for(int jj=0;jj<m;jj++) {
					if(check[ii][jj]) {
						a[ii][jj] = 0; // 0으로 제거!
					}
				}
			}
		}
		else {
			count = 0;
			sum = 0;
			for(int ii=1;ii<n+1;ii++) {
				for(int jj=0;jj<m;jj++) {
					if(a[ii][jj]==0) {
						continue;
					}
					count++;
					sum += a[ii][jj];
				}
			}
			if(count==0) {
				count++;
			}
			if(sum % count == 0) { // 나누어 지는 지 확인 나누어 지면
				avg = sum/count;
				avg_d = avg;
			}
			else {
				avg_d = ((double)(sum))/((double)count);
			}
			for(int ii=1;ii<n+1;ii++) {
				for(int jj=0;jj<m;jj++) {
					if(a[ii][jj]==0) {
						continue;
					}
					if(a[ii][jj]>avg_d) {
						a[ii][jj]--;
					}
					else if(a[ii][jj]<avg_d){
						a[ii][jj]++;
					}
				}
			}
			
			
			
		}
		
		
	}
	sum = 0;
	for(int ii=1;ii<n+1;ii++) {
		for(int jj=0;jj<m;jj++) {
			sum += a[ii][jj];
		}
	}
	System.out.println(sum);
}
}
