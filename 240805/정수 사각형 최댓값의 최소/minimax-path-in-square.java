import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        // 최대이자 최소라는것은, 최대로 선정한것들 중에 현재값과 비교해서 최소로 유지하면 최대이자 최소가 된다.
        // 즉 어떤 칸까지 오는데에 최대이자 최소들 중에서 최대를 뽑아서 현재 넣어야하는 값과 비교하여 최소로 갱신될 여지가 있다면 최소를 뽑는다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i= 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];
        // 맨 윗줄은 왼쪽에서만 값을 얻을 수 있다.
        for(int i= 1;i<n;i++){
            dp[0][i] = Math.max(dp[0][i-1], map[0][i]);
        }
        // 맨 왼쪽 세로줄은 위에서만 값을 얻을 수 있다.
        for(int i= 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], map[i][0]);
        }

        // 모든 칸 i > 0, j > 0 에 대하여 dp[i-1][j], dp[i][j-1]들 중 최소를뽑고, map[i][j]와 갱신될 여지가 있는지 검사한다.

        for(int i = 1;i<n;i++){
            for(int j= 1;j<n;j++){
                dp[i][j] = map[i][j];
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), dp[i][j]);
            }
        }
        System.out.print(dp[n-1][n-1]);
    }
}