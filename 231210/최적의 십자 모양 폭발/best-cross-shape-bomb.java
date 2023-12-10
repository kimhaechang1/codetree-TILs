import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    static int [] dy  = {-1,1,0,0};
    static int [] dx  = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int [][] cp = copy();
                boom(i, j, cp);
                go(cp);
                max = Math.max(chk(cp), max);
            }
        }
        System.out.print(max);
    }
    static int [][] copy(){
        int [][] cp = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                cp[i][j] = map[i][j];
            }
        }
        return cp;
    }
    static void boom(int sy, int sx, int [][] cp){
        int len = cp[sy][sx]-1;
        cp[sy][sx] = 0;
        if(len == 0) return;
        for(int k = 0;k<4;k++){
            for(int i = 1;i<=len;i++){
                int ny = sy + dy[k] * i;
                int nx = sx + dx[k] * i;
                if(ny >= n || ny < 0 || nx >=n || nx < 0) break;
                cp[ny][nx] = 0;
            }
        }
    }
    static void go(int [][] cp){
        for(int i = 0;i<n;i++){
            int tempidx = n-1;
            int [] temp = new int[n];
            for(int j= n-1;j>-1;j--){
                if(cp[j][i] != 0){
                    temp[tempidx--] = cp[j][i];
                }
            }
            for(int j= n-1;j>-1;j--){
                if(tempidx < n){
                    cp[j][i] = temp[j];
                }else{
                    cp[j][i] = 0;
                }
            }
        }
    }
    static int chk(int [][] cp){
        int cnt = 0;
        boolean [][] v = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(cp[i][j] == 0)continue;
                if(v[i][j]) continue;
                int val = cp[i][j];
                v[i][j] = true;
                for(int k = 0;k<4;k++){
                    int ny= i+dy[k];
                    int nx= j+dx[k];
                    if(ny >= n || ny < 0 || nx >= n || nx < 0 || cp[ny][nx] != val) continue;
                    v[ny][nx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void print(int [][] cp){
        StringBuilder sb= new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(cp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}