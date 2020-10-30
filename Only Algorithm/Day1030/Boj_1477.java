package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1477 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int highway = sc.nextInt();
	int dis[] = new int[n+1];
	int div_dis[] = new int[n+1];
	int div_num[] = new int[n+1];
	int station[] = new int[n];
	
	if(n==0) {
		System.out.println(highway);
		return;
	}
	dis[0] = highway; // 첫값은 가장 최대값
	for(int i=0;i<n;i++) {
		station[i] = sc.nextInt();
	}
	Arrays.sort(station);
	for(int i=0;i<n+1;i++) {
		if(i==0) {
			dis[i] = station[i];
			continue;
		}
		if(i==n) {
			dis[i] = highway - station[i-1];
			continue;
		}
		dis[i] = station[i]-station[i-1];
	}
	Arrays.fill(div_num,1);
	for(int i=0;i<n+1;i++) {
		div_dis[i] = dis[i] % div_num[i] == 0 ? dis[i] / div_num[i] : (dis[i] / div_num[i]) + 1;
	}
	for(int t=0;t<m;t++) {
		int max = 0;
		int idx = 0;
		for(int i=0;i<n+1;i++) {
			if(max < div_dis[i]) {
				max = div_dis[i];
				idx = i;
			}
		}
		div_num[idx]++;
		for(int i=0;i<n+1;i++) {
			div_dis[i] = dis[i] % div_num[i] == 0 ? dis[i] / div_num[i] : (dis[i] / div_num[i]) + 1;
		}
	}
	int max = 0;
	for(int i=0;i<n+1;i++) {
		if(max < div_dis[i]) {
			max = div_dis[i];
		}
	}
	System.out.println(max);
}
}
