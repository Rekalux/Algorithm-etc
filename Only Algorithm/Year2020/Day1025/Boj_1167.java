package Day1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		node a[] = new node[N];
		int nodenum = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nodenum = Integer.parseInt(st.nextToken())-1;
			a[nodenum] = new node();
			a[nodenum].gansunlist = new ArrayList<gansun>();
			temp  = Integer.parseInt(st.nextToken());
			while(temp != -1) {
				gansun g = new gansun();
				g.obj = temp-1;
				g.len = Integer.parseInt(st.nextToken());
				a[nodenum].gansunlist.add(g);
				temp = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.print(i+" ");
//			for(gansun g : a[i].gansunlist) {
//				System.out.print(g.obj+" "+g.len+" ");
//			}
//			System.out.println();
//		}
		
		Stack<player> s =new Stack<player>();
		player p = new player();
		p.dis = 0;
		p.num = 0;
		s.add(p);
		player save = new player();
		boolean visit[] = new boolean[N];
		while(!s.isEmpty()) {
			p = s.pop();
			visit[p.num] = true;
			if(p.dis > save.dis) {
				save.dis = p.dis;
				save.num = p.num;
			}
			for(gansun g : a[p.num].gansunlist) {
				if(visit[g.obj]) {
					continue;
				}
				player pp = new player();
				pp.num = g.obj;
				pp.dis = p.dis + g.len;
				s.add(pp);
			}
		}
		
		visit = new boolean[N];
		p.num = save.num;
		p.dis = 0;
		s.add(p);
		visit[p.num] = true; 
		while(!s.isEmpty()) {
			p = s.pop();
			visit[p.num] = true;
			if(p.dis > save.dis) {
				save.dis = p.dis;
				save.num = p.num;
			}
			for(gansun g : a[p.num].gansunlist) {
				if(visit[g.obj]) {
					continue;
				}
				player pp = new player();
				pp.num = g.obj;
				pp.dis = p.dis + g.len;
				s.add(pp);
			}
		}
		System.out.println(save.dis);
	}
}
class node{
	List<gansun> gansunlist;
}
class gansun{
	int obj;
	int len;
}
class player{
	int num;
	int dis;
}