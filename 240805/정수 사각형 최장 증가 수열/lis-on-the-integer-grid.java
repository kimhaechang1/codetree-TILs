import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i= 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            } 
        }
        dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(dp[i][j] == -1){
                    dfs(i,j);
                }
            }
        }
        int ans = 0;
        for(int i= 0;i<n;i++){
            for(int j = 0;j<n;j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.print(ans);
    }
    static boolean OOB(int y, int x){
        return y>=n || y < 0 || x >= n || x < 0;
    }
    static int dfs(int y, int x){
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        dp[y][x] = 1;
        for(int dir= 0;dir<4;dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(OOB(ny, nx) || map[ny][nx] <= map[y][x]) continue;
            int sum = 1;
            sum += dfs(ny,nx);
            dp[y][x] = Math.max(sum, dp[y][x]);
        }
        return dp[y][x];
    }
    static void printMap(){
        for(int i= 0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}