import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static StringTokenizer stk;
    static int n;
    static int[][] info;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int c;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        info = new int[n][2];
        for(int i = 0;i<n;i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken());
            info[i][1] = Integer.parseInt(stk.nextToken());
        }
        c = 0;
        boolean[] v = new boolean[n];
        dfs(0, 0, v, -1, 0);
        System.out.println(c);
    }
    static void dfs(int y, int x, boolean[] v, int pDir, int cnt) {
        if (cnt == n) {
            if (y == 0 && x < 0 && pDir != 3) {
                c++;
            } else if (y == 0 && x > 0 && pDir != 2) {
                c++;
            } else if (y < 0 && x == 0 && pDir != 1) {
                c++;
            } else if (y > 0 && x  == 0 && pDir != 0){
                c++;
            }
            return;
        }

        for(int i = 0;i<n;i++) {
            if (v[i]) continue;
            int ny = info[i][0];
            int nx = info[i][1];
            if (y == ny && x < nx && pDir != 3) {
                v[i] = true;
                dfs(ny, nx, v, 3, cnt + 1);
                v[i] = false;
            } else if (y == ny && x > nx && pDir != 2) {
                v[i] = true;
                dfs(ny, nx, v, 2, cnt + 1);
                v[i] = false;
            } else if (y < ny && x == nx && pDir != 1) {
                v[i] = true;
                dfs(ny, nx, v, 1, cnt + 1);
                v[i] = false;
            } else if (y > ny && x  == nx && pDir != 0){
                v[i] = true;
                dfs(ny, nx, v, 0, cnt + 1);
                v[i] = false;
            }
        }
    }
}