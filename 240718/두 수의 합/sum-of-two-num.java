import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int k;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
        }
        int ans = 0;
        for(int i= 0;i<n;i++){
            map.put(arr[i], map.get(arr[i]) - 1);
            // 숫자 하나씩 꺼내어 사용한다.
            
            int diff = k - arr[i];
            // 목표로 하는 숫자로부터 얼마나 값이 모자란지 파악한다.

            if(map.containsKey(diff)){
                ans += map.get(diff);
            }
        }
        System.out.println(ans);
    }
}