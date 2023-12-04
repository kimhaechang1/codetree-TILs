import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i= 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int maxw = n*m+1;
        int max = -1;
        for(int w = 1;w<maxw;w++){
            for(int a = 1;a<=w;a++){
                if(w % a != 0) continue;
                t : for(int i = 0;i<n;i++){
                    for(int j = 0;j<m;j++){
                        if(go(i, j, a, w / a)){
                            max = Math.max(max, w);
                            break t;
                        } 
                    }
                }
            }
        }
        System.out.print(max);
    }
    static boolean go(int sy, int sx, int h, int w){
        int maxh = sy + h;
        int maxw = sx + w;
        if(maxh > n || maxh < -1 || maxw > m || maxw < -1) return false;
        for(int i = sy;i<maxh;i++){
            for(int j = sx;j<maxw;j++){
                if(map[i][j] < 1) return false;
            }
        }
        return true;
    }
}