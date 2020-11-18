package Day1118;

import java.util.Scanner;

public class Boj_1016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean sosu[] = new boolean[1000001];
		int hap[] = new int[1000001];
		int max = 0;
		for(int i=2;i<=1000000;i++) { // 에라토스테네스의 체로 100만 까지의 소수를 찾아낸다.
			if(hap[i]>0) { // 합성수면 보지않는다.
				continue;
			}
			sosu[i] = true; // 합성수가 아니면 소수라고 생각하고
			for(int j = 2; j * i < 1000001;j++) { // 그 소수의 배수를 합성수로 정한다.
				hap[i*j]++;
				if(max < hap[i*j]) {
					max = hap[i*j];
				}
			}
		}
		System.out.println(max);
		//System.out.println(sosu[1000000]);
		long a = sc.nextLong(), b = sc.nextLong(); // 첫 수와 끝 수를 받는다.
		//System.out.println(f+" "+l);
		long result = b - a + 1;
		for(long i = 2;i * i <= b;i++) {
			long start = a % (i * i) == 0 ? a / (i * i)-1 : a / (i * i); // 첫 수는 나누어 떨어지는 경우를 제외한다. 4 > 4는 1로 포함 / 5 > 5는 2로 포함
			long end = b / (i * i); // 끝 수는 항상 범위를 포함한다.
			long cnt = end - start;
			result += ( sosu[(int)i] ? -1 : (hap[(int)i] % 2 == 0 ? 1 : 0)) * cnt;
			System.out.println((i*i)+" "+result);
		}
		System.out.println(hap[900]);
		System.out.println(result);
	}
}
