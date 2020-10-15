package Day1015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_19236 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	fish inp[][] = new fish[4][4];
	int num;
	int dir;
	for(int i=0;i<4;i++) {
		for(int j=0;j<4;j++) {
			num = sc.nextInt();
			dir = sc.nextInt()-1;
			inp[i][j] = new fish(dir,num);
		}
	}
	map m = new map(inp,0,0,inp[0][0].dir,inp[0][0].num);
	m.fish[0][0].num = -1; // 빈공간
	Queue<map> q = new LinkedList<map>();
	
	int dx[] = {0,-1,-1,-1,0,1,1,1};
	int dy[] = {-1,-1,0,1,1,1,0,-1};
	int nx,ny;
	int ndir;
	int eating;
	int max=0;
	fish[][] newfish;
	fish temp = new fish(-1,-1);
	q.add(m);
	while(!q.isEmpty()) { // 상황 변환
		m = q.poll();
		out : for(int f=1;f<17;f++) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(f==m.fish[i][j].num) { // 낮은 숫자의 물고기를 찾아서
						for(int k=0;k<8;k++) { // 8방향 체크 후
							ndir = m.fish[i][j].dir;
							nx = j+dx[ndir];
							ny = i+dy[ndir];
							if(nx<0 || ny<0 || nx>=4 || ny>=4) { // 칸을 넘어가면 방향 바꾸기
								m.fish[i][j].dir = (m.fish[i][j].dir+1)%8;
								continue;
							}
							if(nx == m.sharkx && ny == m.sharky) { // 상어라면 방향 바꾸기
								m.fish[i][j].dir =( m.fish[i][j].dir+1)%8;
								continue;
							}
							if(m.fish[ny][nx].num == -1) { // 빈공간이면 들어간다.
								m.fish[ny][nx].num = m.fish[i][j].num;
								m.fish[ny][nx].dir = m.fish[i][j].dir;
								m.fish[i][j].num = -1;
								break;
							}// 나머지는 물고기가 있는 경우 (자리바꾸기)
							temp.num = m.fish[i][j].num;
							m.fish[i][j].num = m.fish[ny][nx].num;
							m.fish[ny][nx].num = temp.num;
							temp.dir = m.fish[i][j].dir;
							m.fish[i][j].dir = m.fish[ny][nx].dir;
							m.fish[ny][nx].dir = temp.dir;
							break;
						}
//						if(max==0) {
//							System.out.println();
//							System.out.println("#"+f);
//							for(int ii=0;ii<4;ii++) {
//								for(int jj=0;jj<4;jj++) {
//									System.out.print(m.fish[ii][jj].num+" ");
//								}
//								System.out.println();
//							}
//							System.out.println();
//						}
						continue out;
					}
				}
			}
		}
		for(int i=1;i<4;i++) {
			
			nx = m.sharkx + (dx[m.sharkdir]*i);
			ny = m.sharky + (dy[m.sharkdir]*i);
			if(nx<0 || ny<0 || nx>=4 || ny>=4) {
				continue;
			}
			if(m.fish[ny][nx].num == -1){ //물고기가 없으면 못 감
				continue;
			}
			eating = m.fish[ny][nx].num;
			newfish = new fish[4][4];
			for(int ii=0;ii<4;ii++) {
				for(int jj=0;jj<4;jj++) {
					newfish[ii][jj] = new fish(0,0);
					newfish[ii][jj].num = m.fish[ii][jj].num;
					newfish[ii][jj].dir = m.fish[ii][jj].dir;
				}
			}
			newfish[ny][nx].num = -1;
			
			q.add(new map(newfish,nx,ny,newfish[ny][nx].dir,m.eat+eating));
			if(max < m.eat+eating) {
				max = m.eat+eating;
			}
//			System.out.println("#"+max);
//			for(int ii=0;ii<4;ii++) {
//				for(int jj=0;jj<4;jj++) {
//					System.out.print(newfish[ii][jj].num+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(nx+" "+ny+" "+newfish[ny][nx].dir+" "+(m.eat+eating));
//			System.out.println();
		}
//		for(int ii=0;ii<4;ii++) {
//			for(int jj=0;jj<4;jj++) {
//				System.out.print(m.fish[ii][jj].num+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(m.sharkx+" "+m.sharky+" "+m.sharkdir);
//		System.out.println();
		if(max < m.eat) {
			max = m.eat;
		}
	}
	System.out.println(max);
}
}
class map{
	fish fish[][];
	int sharkx;
	int sharky;
	int eat;
	int sharkdir;
	public map(fish [][]fish, int sharkx, int sharky,int dir, int eat) {
		super();
		this.fish = fish;
		this.sharkx = sharkx;
		this.sharky = sharky;
		this.sharkdir = dir;
		this.eat = eat;
	}
}
class fish{
	int dir;
	int num;
	public fish(int dir, int num) {
		super();
		this.dir = dir;
		this.num = num;
	}
}