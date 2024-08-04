import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // 오른쪽 위에서 시작해서 왼쪽 혹은 밑으로만 이동한다.
        // 즉, 특정칸에 도달할때, 올 수 있는 경우의수가 정해져있다.
        long[][] dp = new long[n][n];
        dp[0][n-1] = map[0][n-1];
        // 윗줄 대 체움
        for(int i = n-2;i>-1;i--){
            dp[0][i] = (dp[0][i+1] + map[0][i]);
        }
        // 아랫줄 채움
        for(int i = 1;i<n;i++){
            dp[i][n-1] = (dp[i-1][n-1] + map[i][n-1]);
        }
        for(int i = 1;i<n;i++){
            for(int j= n-2;j>-1;j--){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + map[i][j];
            }
        }
        System.out.println(dp[n-1][0]);

    }
}