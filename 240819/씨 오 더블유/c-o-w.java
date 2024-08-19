import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String str;
    static long[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        str = bf.readLine();
        dp = new long[n];
        Arrays.fill(dp, -1);
        for(int i = 0;i<n;i++){
            if(str.charAt(i) == 'C') {
                dfs(i);
            }
        }
        long ans = 0;
        for(int i = 0;i<n;i++){
            if(str.charAt(i) == 'C'){
                ans += dp[i];
            }
        }
        System.out.print(ans);
        
    }

    static long dfs(int idx){
        
        if(str.charAt(idx) == 'W'){
            return 1;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }

        dp[idx] = 0;
        int cnt = 0;
        for(int i = idx+1;i<n;i++){
            char pres = str.charAt(idx);
            if(pres == 'C' && str.charAt(i) == 'O') {
                cnt += dfs(i);
            } else if(pres == 'O' && str.charAt(i) == 'W') {
                cnt += dfs(i);
            }
            dp[idx] = Math.max(dp[idx], cnt);
        }

        return dp[idx];
        
    }
}