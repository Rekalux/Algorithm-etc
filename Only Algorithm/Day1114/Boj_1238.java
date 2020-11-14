package Day1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1238 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int x = Integer.parseInt(st.nextToken())-1;
	int[][] board = new int[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			board[i][j] = Integer.MAX_VALUE;
		}
	}
	for(int i=0;i<m;i++) {
		st = new StringTokenizer(br.readLine());
		int front = Integer.parseInt(st.nextToken())-1;
		int back = Integer.parseInt(st.nextToken())-1;
		int dis = Integer.parseInt(st.nextToken());
		if(board[front][back] > dis) {
			board[front][back] = dis;
		}
	}
	for(int mid=0;mid<n;mid++) {
		for(int start = 0; start<n;start++) {
			for(int end = 0; end<n;end++) {
				if(board[start][mid] != Integer.MAX_VALUE && board[mid][end] != Integer.MAX_VALUE) {
					int newroad = board[start][mid] + board[mid][end];
					if(board[start][end] > newroad) {
						board[start][end] = newroad;
					}
				}
			}
		}
	}
	int result = 0;
	int temp = 0;
	for(int i=0;i<n;i++) {
		if(i==x) {
			continue;
		}
		temp = board[i][x] + board[x][i];
		if(result < temp) {
			result = temp;
		}
	}
	System.out.println(result);
}
}
