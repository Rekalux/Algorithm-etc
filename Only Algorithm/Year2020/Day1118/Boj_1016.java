package Day1118;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean nonosu[] = new boolean[1000001];
		boolean sosu[] = new boolean[1000001];
		Arrays.fill(nonosu, true);
		boolean hap[] = new boolean[1000001];
		int max = 0;
		long a = sc.nextLong(), b = sc.nextLong(); // 첫 수와 끝 수를 받는다.
		for(long i=2;i<=1000000;i++) { // 에라토스테네스의 체로 100만 까지의 소수를 찾아낸다.
			if(hap[(int)i]) { // 합성수면 보지않는다.
				continue;
			}
			if((long)i*(long)i > b) {
				continue;
			}
			sosu[(int)i] = true; // 합성수가 아니면 소수라고 생각하고
			for(int j = 2; j * i < 1000001;j++) { // 그 소수의 배수를 합성수로 정한다.
				hap[(int)i*(int)j] = true;
			}
			long k = a % (i * i) == 0 ? a / (i * i) : a / (i * i)+1;
			//System.out.println(k +" "+a+" "+i);
			for(long j = k; j * ((long)i * (long)i) -a <= b-a ;j++) {
				nonosu[(int)((long)j*((long)i*(long)i)-a)] = false;
			}
		}
		int cnt = 0;
		for(int i=0;i<=b-a;i++) {
			if(nonosu[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		//System.out.println(max);
		//System.out.println(sosu[1000000]);
		//System.out.println(f+" "+l);
//		long result = b - a + 1;
//		for(long i = 2;i * i <= b;i++) {
//			long start = a % (i * i) == 0 ? a / (i * i)-1 : a / (i * i); // 첫 수는 나누어 떨어지는 경우를 제외한다. 4 > 4는 1로 포함 / 5 > 5는 2로 포함
//			long end = b / (i * i); // 끝 수는 항상 범위를 포함한다.
//			long cnt = end - start;
//			result += ( sosu[(int)i] ? -1 : (hap[(int)i] % 2 == 0 ? 1 : (hap[(int)i]==1 ? 0 : -1))) * cnt;
//			System.out.println((i*i)+" "+result);
//		}
//		System.out.println(hap[400]);
//		System.out.println(result);
	}
}
