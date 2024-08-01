import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static final int MOD = 10_007;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] dp = new int[1001];
        dp[0] = 1; // 0
        dp[1] = 1; // 2*1[1]
        dp[2] = 3; // 1*2[2], 2*1[2], 2*2[1]
        dp[3] = 5;// 2*1[2]+1*2[1] *2, 1*2[3], 1*2[1] + 2*2[1] * 2 
        dp[4] = 11;// 2*2[1] + 2*2[1], 2*2[1] + 2*1[2] *3, 2*2[1] + 1*2[2] *2, 1*2[4], 2*1[4], 1*2[2] + 2*1[2] *3
        dp[5] = 21;
        dp[6] = 43;

        for(int i = 5;i<1001;i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % MOD;
        }
        System.out.println(dp[n]);
        
    }
}