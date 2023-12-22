import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n,m;
    static int [] dy = {1,0};
    static int [] dx = {0,1};
    static boolean [][] v;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        v[0][0] = true;
        dfs(0,0);
        System.out.print(v[n-1][m-1] ? 1 : 0);
    }
    static void dfs(int y, int x){
        if(y == n-1 && x == m-1){
            return;
        }

        for(int k = 0;k<2;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(OOB(ny, nx)) continue;
            if(v[ny][nx]) continue;
            if(map[ny][nx] == 0) continue;
            v[ny][nx] = true;
            dfs(ny, nx);
        }
    }
    static boolean OOB(int y, int x){
        if(y >= n || y < 0 || x >= n || x < 0) return true;
        return false;
    }
}