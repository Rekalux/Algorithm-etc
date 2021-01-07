package Day1010;

import java.util.Scanner;

public class Boj_12100 {
	static int N;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int max = 0;
	static int nx, ny;
	static int sx, sy;
	static int temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		move(board, 0);

		System.out.println(max);
	}

	static void move(int[][] board, int count) {
		int new_board[][] = new int[N][N];
		count++;
		if (count > 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] > max) {
						max = board[i][j];
					}
				}
			}
			return;
		}
		for (int dir = 0; dir < 4; dir++) {
			boolean visit[][] = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					new_board[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < N * N; i++) {
				if (dir == 0) {
					ny = i / N;
					nx = i % N;
				} else if (dir == 1) {
					ny = i % N;
					nx = i / N;
				} else if (dir == 2) {
					ny = ((N * N - 1) - i) / N;
					nx = ((N * N - 1) - i) % N;
				} else {
					ny = ((N * N - 1) - i) % N;
					nx = ((N * N - 1) - i) / N;
				}
				if (new_board[ny][nx] == 0) {
					continue;
				}
				sx = nx;
				sy = ny;
				while (true) {
//					if(count==1 && dir==0 && i==14) {
//						for(int ii=0;ii<N;ii++) {
//							for(int jj=0;jj<N;jj++) {
//								System.out.print(new_board[ii][jj]+" ");
//							}
//							System.out.println();
//						}
//						System.out.println(sy+" "+sx+" "+ny+" "+nx);
//						System.out.println();
//					}
					sx += dx[dir];
					sy += dy[dir];
					if (sx < 0 || sy < 0 || sx >= N || sy >= N) {
						
						if(sx != nx+dx[dir] || sy != ny+dy[dir]) {
							temp = new_board[ny][nx];
							new_board[ny][nx] = 0;
							new_board[sy - dy[dir]][sx - dx[dir]] = temp;
						}
						break;
					}
					if(visit[sy][sx]) {
						temp = new_board[ny][nx];
						new_board[ny][nx] = 0;
						new_board[sy - dy[dir]][sx - dx[dir]] = temp;
						break;
					}
					if (new_board[sy][sx] == new_board[ny][nx]) {
						new_board[sy][sx] *= 2;
						new_board[ny][nx] = 0;
						visit[sy][sx] = true;
						break;
					}
					if (new_board[sy][sx] != 0) {
						temp = new_board[ny][nx];
						new_board[ny][nx] = 0;
						new_board[sy - dy[dir]][sx - dx[dir]] = temp;
						break;
					}
				}
				
			}
			
			
			move(new_board, count);
		}

	}

}
