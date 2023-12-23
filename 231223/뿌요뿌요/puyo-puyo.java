import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static int cnt;
    static int max;
    static int c;
    static boolean [][] v;
    static StringTokenizer stk;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        max = 0;
        cnt = 0;
        v= new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(v[i][j]) continue;
                c = 1;
                v[i][j] = true;
                dfs(i, j, map[i][j]);
                if(c >= 4){
                    cnt++;  
                }
                max = Math.max(c, max);
                
            }
        }
        System.out.println(cnt+" "+max);
    }
    static void dfs(int y, int x, int block){
        for(int k = 0;k<4;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny >= n || ny < 0 || nx >= n || nx < 0 || v[ny][nx] || map[ny][nx] != block) continue;
            v[ny][nx] = true;
            c++;
            dfs(ny, nx, block);           
        }
    }
}