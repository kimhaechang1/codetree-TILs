import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    static int[] dy = {0,1};
    static int[] dx = {1,0};
    static int[][] dp;
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
        dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        dfs(0,0);

        System.out.println(dp[0][0]);
    }
    static int dfs(int y, int x){
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        if(y == n-1 && x == n-1){
            return map[n-1][n-1];
        }
        dp[y][x] = map[y][x];
        int value = 0;
        for(int dir = 0;dir<2;dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(OOB(ny, nx)) continue;
            value = Math.max(value, Math.min(dfs(ny, nx), dp[y][x]));
        }

        return dp[y][x] = value;
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >=n || x < 0;
    }
}