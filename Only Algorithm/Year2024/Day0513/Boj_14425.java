package vin_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            set.add(word);
        }
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            if(set.contains(word)){
                count++;
            }
        }
        System.out.println(count);
    }
}
