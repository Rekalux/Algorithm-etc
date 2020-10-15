package Day1015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_19238 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 맵 크기 n * n
		m = sc.nextInt(); // 승객 수
		k = sc.nextInt(); // 초기 연료
		boolean find =false;
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int ty = sc.nextInt()-1, tx = sc.nextInt()-1;
		man = new int[m][4];
		for(int i=0;i<m;i++) {
			man[i][0] = sc.nextInt()-1;
			man[i][1] = sc.nextInt()-1;
			man[i][2] = sc.nextInt()-1;
			man[i][3] = sc.nextInt()-1;
		}
		boolean visit[][];
		visitman = new boolean[m];
		Queue<Point> q = new LinkedList<Point>();
		Point p = null;
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		int nx=0,ny=0;
		int savedis = 999999;
		int savex=9999,savey=9999;
		int saveidx = 0;
		while(true) {
			for(int i=0;i<m;i++) {
//				System.out.println("dkdk");
				if(!visitman[i]) {
					i=-1;
					// 택시를 큐에 넣고 visitmap[i] false인 가장 가까운 지점을 찾는다.
					visit = new boolean[n][n];
					q = new LinkedList<Point>();
					q.add(new Point(tx,ty,0));
					visit[ty][tx] = true;
					savedis = Integer.MAX_VALUE;
					savex = 999999;
					savey = 999999;
					saveidx = 0;
					find=false;
					boolean ffind = false;
					for(int jj=0;jj<m;jj++) {
						if(man[jj][0]==ty && man[jj][1]==tx && !visitman[jj]) {
							savex = tx;
							savey = ty;
							savedis = 0;
							saveidx = jj;
							ffind = true;
							find=true;
						}
					}
					out : while(!q.isEmpty()) {
						if(ffind) {
							break;
						}
						p = q.poll();
						for(int j=0;j<4;j++) { 
							nx = p.x +dx[j];
							ny = p.y +dy[j];
							//System.out.println(ny+" "+nx);
							if(nx<0 || ny<0 || nx>=n || ny>=n) {
								continue;
							}
							if(map[ny][nx] == 1 || visit[ny][nx]) {
								continue;
							}
							//System.out.println("왜?");
							visit[ny][nx] = true;
							q.add(new Point(nx,ny,p.dis+1));
							for(int ii=0;ii<m;ii++) {
								//System.out.println("아아");
								if(visitman[ii]) {
									continue;
								}
								
								if(man[ii][0] == ny && man[ii][1]== nx) { // 사람이 있는 곳을 찾으면 거리 확인
									if(savedis < p.dis+1) {
										//System.out.println("아"+ii+" "+ny+" "+ny);
										break out;
									}
									find = true;
									if(savey > ny) {
										savex = nx;
										savey = ny;
										savedis = p.dis+1;
										saveidx = ii;
										break;
									}
									if(savey == ny && savex > nx) {
										savex = nx;
										savey = ny;
										savedis = p.dis+1;
										saveidx = ii;
										break;
									}
									else {
										break;
									}
								}
							}
						}
					}
					if(!find) {
						System.out.println(-1);
						return;
					}
					visitman[saveidx] = true;
					tx = savex;
					ty = savey;
					k -= savedis;
					q = new LinkedList<Point>();
					q.add(new Point(tx,ty,0));
					visit = new boolean[n][n];
					visit[ty][tx] = true;
					find = false;
					//System.out.println(ty+" "+tx+" 여기");
					//System.out.println(man[saveidx][2] +" "+man[saveidx][3] +" 도착지점");
					
					out: while(!q.isEmpty()) {
						p = q.poll();
						for(int j=0;j<4;j++) {
							nx = p.x + dx[j];
							ny = p.y + dy[j];
							if(nx<0 || ny<0 || nx>=n || ny>=n) {
								continue;
							}
							if(map[ny][nx] == 1 || visit[ny][nx]) {
								continue;
							}
							visit[ny][nx] = true;
							q.add(new Point(nx,ny,p.dis+1));
							if(ny == man[saveidx][2] && nx == man[saveidx][3]) { //찾으면
								find = true;
								break out;
							}
						}
					}
					if(find) {
						visitman[saveidx] = true;
						//System.out.println("돌아옴:"+ny+" "+nx);
						//System.out.println(k + " "+(p.dis+1));
						k -= (p.dis+1);
					}
					else {
						System.out.println(-1);
						return;
					}
					if(k<0) {
						//System.out.println(saveidx+" "+ny+" "+nx+" "+k);
						System.out.println(-1);
						return;
					}
					else {
						
						k += (2*(p.dis+1));
						tx = nx;
						ty = ny;
					}
				}
			}
			break;
		}
		System.out.println(k);
	}
	static int map[][];
	static int n,m,k;
	static int man[][];
	static boolean visitman[];
}

class Point{
	int x;
	int y;
	int dis;
	public Point(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
