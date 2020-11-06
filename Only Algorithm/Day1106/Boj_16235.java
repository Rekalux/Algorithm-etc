package Day1106;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj_16235 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int k = sc.nextInt();
	int dx[] = {0,1,1,1,0,-1,-1,-1};
	int dy[] = {-1,-1,0,1,1,1,0,-1};
	LinkedList<tree> trees[][] = new LinkedList[n][n];
	LinkedList<tree> newtrees[][] = new LinkedList[n][n];
	int plus[][] = new int[n][n];
	int ground[][] = new int[n][n];
	int result = 0;
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			plus[i][j] = sc.nextInt();
			trees[i][j] = new LinkedList<tree>();
			ground[i][j] = 5;
		}
	}
	for(int i=0;i<m;i++) {
		int y = sc.nextInt()-1;
		int x = sc.nextInt()-1;
		int age = sc.nextInt();
		trees[y][x].add(new tree(age));
	}
	
//	for(int i=0;i<n;i++) {
//		for(int j=0;j<n;j++) {
//			result += trees[i][j].size();
//		}
//	}
//	System.out.println(result);
	
	for(int kk=0;kk<k;kk++) { // 새해가 밝았다.
		for(int i=0;i<n;i++) { // 봄
			for(int j=0;j<n;j++) {
				newtrees[i][j] = new LinkedList<tree>();
				while(!trees[i][j].isEmpty()) {
					tree t = trees[i][j].pollLast(); // 모든 나무가
					if(ground[i][j] - t.age >=0 ) {
						ground[i][j] -= t.age; // 나이만큼 양분을 빤다.
						t.age++; // 그리고 나이를 먹고
						newtrees[i][j].addFirst(t); //올해의 나무로 갱신
					}
					else { // 땅이 충분히 비옥하지 못하면
						trees[i][j].add(t);
						break; //나머지 나무는 비료를 못 먹는다.
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) { // 여름
			for(int j=0;j<n;j++) {
				while(!trees[i][j].isEmpty()) {
					tree t = trees[i][j].pollLast();
					ground[i][j] += (t.age/2); //죽은 나무는 양분이 되고
				}
			}
		}
		
		for(int i=0;i<n;i++) { // 가을
			for(int j=0;j<n;j++) {
				for(tree t : newtrees[i][j]) {
					if(t.age%5 == 0) { // 나무탄신일 5주년마다
						for(int dir=0;dir<8;dir++) {
							int ny = i + dy[dir];
							int nx = j + dx[dir];
							if(ny<0 || nx<0 || ny>=n || nx>=n) {
								continue;
							}
							newtrees[ny][nx].addLast(new tree(1)); // 새생명탄생!
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) { // 겨울
			for(int j=0;j<n;j++) {
				ground[i][j] += plus[i][j]; // 양분추가
				trees[i][j] = newtrees[i][j]; // 올해 끝~
			}
		}
		
	}
	
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			result += trees[i][j].size();
		}
	}
	System.out.println(result);
}
}
class tree{
	int age;
	public tree(int age){
		this.age = age;
	}
}