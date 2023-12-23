import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int [][] map;
    static StringTokenizer stk;
    static boolean [][] v;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = new boolean[n][m];
        map = new int[n][m];
        int maxHeight = 1;
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j =0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        //System.out.println(maxHeight);
        int k = 0;
        int max = 0;
        int res = 1;
        while(++k <= maxHeight){
            v = new boolean[n][m];
            int cnt = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(map[i][j] > k && !v[i][j]){
                        cnt++;
                        v[i][j] = true;
                        dfs(i, j, k);
                    }
                }
            }
            if(max < cnt){
                max = cnt;
                res = k;
            }
        }
        System.out.print(res+" "+max);
    }
    static void dfs(int y , int x, int limit){
        for(int k = 0;k<4;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny >= n || ny < 0 || nx >=m || nx < 0 || v[ny][nx] || map[ny][nx] <= limit) continue;
            v[ny][nx] = true;
            dfs(ny, nx,  limit);
        }
    }
}