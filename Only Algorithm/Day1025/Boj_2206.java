package Day1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
//		for (int i = 0; i < y; i++) {
//			for (int j = 0; j < x; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		if(y==1 && x==1) {
//			System.out.println(1);
//			return;
//		}
		Queue<block> q = new LinkedList<block>();
		block bl = new block();
		bl.x = 0;
		bl.y = 0;
		bl.dis = 1;
		bl.breaked = false;
		q.add(bl);
		boolean visit[][][] = new boolean[y][x][2];
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { 1, -1, 0, 0 };
		int ny, nx, nbreak = 0;
		int result =0;
		while (!q.isEmpty()) {
			bl = q.poll();
			//System.out.println(bl.y+" "+bl.x+" "+bl.breaked);
			if(bl.x == x-1 && bl.y ==y-1) {
				result = bl.dis;
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = dx[i] + bl.x;
				ny = dy[i] + bl.y;
				if (ny < 0 || nx < 0 || ny >= y || nx >= x) {
					continue;
				}
				nbreak = 0;
				if (bl.breaked) {
					nbreak = 1;
				}
				if (visit[ny][nx][nbreak]) {
					continue;
				}
				if(bl.breaked && map[ny][nx] == 1) {
					continue;
				}
				visit[ny][nx][nbreak] = true;
				block newbl = new block();
				newbl.x = nx;
				newbl.y = ny;
				newbl.dis = bl.dis+1;
				newbl.breaked = bl.breaked;
				if(map[ny][nx] == 1) {
					newbl.breaked = true;
				}
				q.add(newbl);
			}
		}
		System.out.println(result == 0 ? -1 : result);
	}

	static int x, y;
	static int map[][];
}

class block {
	int dis;
	int x, y;
	boolean breaked;
}