import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        // 동전의 개수가 무한대이면서, 중요한것은 동전끼리의 값어치가 배수라는것 -> 그리디하게 접근가능
        
        arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int t = k;
        int idx = n-1;
        int ans = 0;
        while(t != 0) {
            while(idx > -1 && arr[idx] > t) {
                idx--;
            }
            ans += (t / arr[idx]);
            t %= arr[idx];
        }
        System.out.print(ans);
    }
}