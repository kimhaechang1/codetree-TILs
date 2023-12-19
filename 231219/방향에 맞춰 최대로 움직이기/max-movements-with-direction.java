import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int [] dx = {0, 0, 1,1,1,0,-1,-1,-1};
    static int [][][] map;
    static int max;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n][2];
        for(int k = 0;k<2;k++){    
            for(int i = 0;i<n;i++){
                stk = new StringTokenizer(bf.readLine());
                for(int j = 0;j<n;j++){
                    map[i][j][k] = Integer.parseInt(stk.nextToken());
                }
            }
        }
        stk =new StringTokenizer(bf.readLine());
        int sy= Integer.parseInt(stk.nextToken())-1;
        int sx =Integer.parseInt(stk.nextToken())-1;
        max = 0;
        dfs(sy, sx, 0);
        System.out.print(max);
    }
    static void dfs(int y, int x, int cnt){
        int val = map[y][x][0];
        int dir = map[y][x][1];
        max = Math.max(max, cnt);
        for(int i = 1;i<=n-1;i++){
            int ny = y + dy[dir] * i;
            int nx = x + dx[dir] * i;
            if(ny >= n || ny < 0 || nx >= n || nx < 0 || map[ny][nx][0] < val) continue;
            dfs(ny, nx, cnt+1);           
        }
    }
}