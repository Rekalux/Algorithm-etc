import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Boj_16943 숫자 재배치
 */
public class Boj_16943 {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a,b;
            a = st.nextToken();
            b = st.nextToken();
            num = new int[10];
            for(int i=0;i<a.length();i++){
                  num[a.charAt(i)-'0']++;
            }
            c = -1;
            if(a.equals("0")){
                  c = -1;
            }
            else if(a.length()==b.length()){
                  Findnum(0,a.length(),b,0);
            }
            else if(a.length()<b.length()){
                  int number = 0;
                  for(int i=9;i>=0;i--){
                        for(int j=0;j<num[i];j++){
                              number = number * 10 + i;
                        }
                  }
                  c = number;
            }
            String dap = String.valueOf(c);
            bw.write(dap);
            bw.flush();
      }
      static long c;
      static int num[];
      public static void Findnum(int nowidx, int length,String b,int number) {
            if(nowidx == length){ // 길이만큼 진행했다면
                  c = number;
                  return;
            }
            if( (num[b.charAt(nowidx)- '0'] ) > 0){ // 숫자가 같은 경우
                  num[b.charAt(nowidx)- '0']--;
                  number = number * 10 + (b.charAt(nowidx) - '0');
                  Findnum(nowidx+1, length, b,number);
                  number = number / 10;
                  num[b.charAt(nowidx)-'0']++;
            }
            if(c == -1){ // 같은 경우로 못 찾았을 경우
                  boolean second_num = false;
                  for(int i = (b.charAt(nowidx)-'0')-1 ; i>=0 ; i-- ){
                        if(nowidx==0 && i == 0){
                              break;
                        }
                        if(num[i] > 0){
                              second_num = true;
                              number = number * 10 + i;
                              num[i]--;
                              break;
                        }
                  }
                  if(second_num){
                        for(int i=9;i>=0;i--){
                              for(int j = 0; j<num[i] ; j++){
                                    number = number * 10 + i;
                              }
                        }
                        c = number;
                  }
            }
      }
}