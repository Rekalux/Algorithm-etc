package vin_algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map map = new HashMap<Integer,Integer>();

        for(int i = 0; i < n ; i++){
            Integer getNum = sc.nextInt();
            Integer count;
            count = countCount(map, getNum);
            map.put(getNum, count + 1);
        }
        Integer question = sc.nextInt();
        System.out.println(countCount(map, question));

    }

    private static Integer countCount(Map map, Integer getNum) {
        Integer count;
        if(!map.containsKey(getNum)){
            count = 0;
        }else{
            count = (Integer)map.get(getNum);
        }
        return count;
    }
}
