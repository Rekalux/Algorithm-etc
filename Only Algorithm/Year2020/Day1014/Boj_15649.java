package Day1014;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_15649 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	a = sc.nextInt();
	b = sc.nextInt();
	n = new int[b];
	visit = new boolean[a];
	find(0);
	bw.flush();
	bw.close();
}
static BufferedWriter bw;
static int n[];
static int a,b;
static boolean visit[];
static void find(int x) throws IOException {
	if(x>=b) {
		for(int i=0;i<b;i++) {
			bw.write((n[i]+1)+" ");
		}
		bw.write("\n");
		return;
	}
	
	for(int i=0;i<a;i++) {
		if(visit[i]) {
			continue;
		}
		visit[i] = true;
		n[x] = i;
		find(x+1);
		visit[i] = false;
	}
}
}
