import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n;
    static StringTokenizer stk;
    static boolean [] v;
    static int [] res;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        v =new boolean[n];
        res = new int[n];
        max = -1;
        dfs(0);
        System.out.print(max);
    }
    static void dfs(int depth){
        if(depth == n){
            int sum = 0;
            for(int a : res) sum += a;
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0;i<n;i++){
            if(v[i]) continue;
            v[i] = true;
            int temp = res[depth];
            res[depth] = map[depth][i];
            dfs(depth+1);
            res[depth]= temp;
            v[i] = false;
        }
    }
}