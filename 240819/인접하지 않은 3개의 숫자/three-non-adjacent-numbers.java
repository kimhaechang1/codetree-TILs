import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static StringTokenizer stk;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 1;i<n+1;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        // 왼쪽에서 특정 번째수까지의 최대값과

        // 오른쪽에서 특정 번째수까지의 최대값을 미리 구한다.

        // 그렇게 해야 i 번째를 기준으로 i+2, i-2번째까지의 최대값을 알고서 합을 갱신할 수 있다.
        int[] L = new int[n+1];
        int[] R = new int[n+1];

        for(int i = 1;i<n+1;i++)
            L[i] = Math.max(L[i-1], arr[i]);

        R[n] = arr[n];
        for(int i = n-1;i>0;i--)
            R[i] = Math.max(R[i+1], arr[i]);

        int ans = 0;
        for(int i = 3;i<=n-2;i++){
            ans = Math.max(ans, L[i-2] + arr[i] + R[i+2]);
        }
        System.out.print(ans);

        
    }
}