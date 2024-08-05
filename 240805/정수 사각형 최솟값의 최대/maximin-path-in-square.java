import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    static int[] dy = {0,1};
    static int[] dx = {1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // DP로 어떻게 해결할 수 있는가?
        // 최소들 중 최대값은 즉, 경로상에 최소값들 끼리 경쟁해서 최대를 구하란 이야기가 된다.
        // 결국 어떤 지점 i, j로 올 수있는 방법은 현재 문제에서 i-1,j 혹은 i, j-1이 되는데
        // 이 때 각각의 최솟값들 중 최대를 선택하는것이 중요하다. 왜냐하면 그래야 "경로상의 최대" 가 되니까
        // 추가적으로 그럼 map[i][j]는 어떻게 비교 할 것인가? 해당 땅을 밟기 위한 조건만 갖추면된다. 즉, 지금까지의 최소이자 최대보다도 더 작다면 갱신인 셈

        int[][] dp =  new int[n][n];
        dp[0][0] = map[0][0];
        for(int i = 1;i<n;i++)
            dp[0][i] = Math.min(map[0][i], dp[0][i-1]);

        for(int i = 1;i<n;i++)
            dp[i][0] = Math.min(map[i][0], dp[i-1][0]);
        
        for(int i = 1;i<n;i++){
            for(int j= 1;j<n;j++){
                dp[i][j] = map[i][j];
                dp[i][j] = Math.min(Math.max(dp[i-1][j], dp[i][j-1]), dp[i][j]);
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
}