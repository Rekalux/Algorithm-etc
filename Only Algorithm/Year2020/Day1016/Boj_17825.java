package Day1016;

import java.util.Scanner;

public class Boj_17825 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	dice = new int[10];
	for(int i=0;i<10;i++) {
		dice[i] =sc.nextInt();
	}
	dfs(new position(),0);
	System.out.println(max);
}
static int dice[];
static int temp;
static int count;
static int max=0;
static void dfs(position p,int turn) {
	if(turn==10) {
		if(max < p.total) {
			max = p.total;
		}
		return;
	}
	for(int i=0;i<4;i++) { // 어느말이 이동할 지 정하고
		position np = new position();
		for(int j=0;j<4;j++) { // 복새해놓은 다음
			np.mal[j] = p.mal[j];
		}
		np.total = p.total;
		temp = np.mal[i];
		if(np.mal[i]<-1) { // 도착은 -2이므로 도착했는 지 확인
			continue;
		}
		if(np.mal[i]==4) { // 왼쪽지름길인지 확인
			temp = 19 + dice[turn];
			if(temp>22) {
				temp +=2;
			}
		}
		else if(np.mal[i]==9) { // 중앙지름길
			temp = 22+ dice[turn];
		}
		else if(np.mal[i]==14) { //오른쪽지름길
			temp = 27+ dice[turn];
			if(temp>30) {
				temp -= 6;
			}
		}
		else if(19<np.mal[i] && np.mal[i]<23) { //왼쪽지름길 도중
			temp += dice[turn];
			if(temp>22) {
				temp += 2;
			}
			if(temp==28) {
				temp = 19;
			}
			if(temp==29) {
				temp = -2;
			}
		}
		else if(22<np.mal[i] && np.mal[i]<28) { //중앙지름길도중
			temp += dice[turn];
			if(temp==28) {
				temp = 19;
			}
			else if(temp>28) {
				temp = -2;
			}
		}
		else if(27<np.mal[i]&&np.mal[i]<31) { //오른쪽지름길도중
			temp += dice[turn];
			if(temp>30) {
				temp -= 6;
				if(temp==28) {
					temp = 19;
				}
				else if(temp==29) {
					temp = -2;
				}
			}
		}
		else {
			temp += dice[turn];
			if(temp>19) {
				temp = -2;
			}
		}
		count = 0;
		if(temp > -1) {
			for(int j=0;j<4;j++) { // 말 4개 중 겹치는 게 있는 지 확인
				if(i==j) continue;
				if(np.mal[j]==temp) {
					count++;
				}
			}
		}
		if(count>0) { // 존재
			continue;
		}
		if(temp >-1 ) {
			np.total += map_main[temp];
		}
		np.mal[i] = temp;
//		if(turn<3) {
//			System.out.println("#"+turn+" "+i);
//			for(int j=0;j<4;j++) {
//				System.out.println(np.mal[j]);
//			}
//			System.out.println(np.total);
//		}
		dfs(np,turn+1);
		
	}
	
}

static int map_main[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40,13,16,19,22,24,25,30,35,28,27,26}; // 0 - 19
static int map_left[] = {13,16,19}; // 0 - 2 ( 20 - 22 )
static int map_under[] = {22,24,25,30,35}; //0 - 6( 23 - 27 )
static int map_right[] = {28,27,26}; // 0 - 2( 28 - 30 )
}
class position{
	int mal[] = {-1,-1,-1,-1};
	int total=0;
}