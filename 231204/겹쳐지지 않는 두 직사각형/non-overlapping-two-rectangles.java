import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int [][] map;
    static boolean [][] v;
    static StringTokenizer stk;
    static int max = -99999999;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int a = 1;a<=n;a++){
                    for(int b = 1;b<=m;b++){
                        go(i, j, a, b);
                    }
                }
            }
        }
        System.out.print(max);
    }
    static void go(int sy, int sx, int h, int w){
        int maxh = sy + h;
        int maxw = sx + w;
        if(maxh > n || maxh < -1 || maxw > m || maxw < -1) return;
        int sum = 0;
        v = new boolean[n][m];
        for(int i = sy;i<maxh;i++){
            for(int j = sx;j<maxw;j++){
                sum += map[i][j];
                v[i][j] = true;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(v[i][j]) continue;
                for(int a = 1;a<=n;a++){
                    for(int b = 1;b<=m;b++){
                        int res = another(i, j, a, b, sum);
                        if(res != -1){
                            max = Math.max(res, max);
                        }
                    }
                }
            }
        }
    }
    static int another(int sy, int sx, int h, int w, int presentSum){
        int maxh = sy + h;
        int maxw = sx + w;
        if(maxh > n || maxh < -1 || maxw > m || maxw < -1) return -1;
        boolean flg = false;
        for(int i = sy;i<maxh;i++){
            for(int j = sx;j<maxw;j++){
                presentSum += map[i][j];
                if(v[i][j]) return -1;    
            }
        }
        return presentSum;
    }
}