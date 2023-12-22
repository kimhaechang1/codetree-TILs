import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static boolean [] v;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        v = new boolean[n];
        v[0] = true;
        dfs(0, 0, 0);   
        System.out.print(min);
    }
    static void dfs(int depth, int pres, int sum){
        if(min < sum) return;
        if(depth == n-1){
            if(map[pres][0] == 0) return;
            sum += map[pres][0];
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0;i<n;i++){
            if(v[i]) continue;
            if(map[pres][i] == 0) continue;
            v[i] = true;
            dfs(depth+1, i, sum+map[pres][i]);
            v[i] = false;
        }
    }
}