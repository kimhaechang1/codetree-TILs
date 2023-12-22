import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static int [] res;
    static boolean [] v;
    static int max = Integer.MIN_VALUE;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        res = new int[n];
        v = new boolean[n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0);
        System.out.print(max);
    }
    static void dfs(int depth){
        if(depth == n){
            int min = Integer.MAX_VALUE;
            for(int a : res) min = Math.min(min, a);
            max = Math.max(min, max);
            return;
        }

        for(int i = 0;i<n;i++){
            if(v[i]) continue;
            v[i] = true;
            int temp = res[depth];
            res[depth] = map[depth][i];
            dfs(depth+1);
            res[depth] = temp;
            v[i] = false;
        }
    }

}