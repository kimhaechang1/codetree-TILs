import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int [] count;
    static int [] res;
    static StringBuilder sb;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        res = new int[n];
        sb = new StringBuilder();
        dfs(0,0,0);
        System.out.print(sb);
    }
    static void dfs(int depth, int prev, int cnt){
        if(depth == n){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1;i<=k;i++){
            if(prev == i && cnt < 2){
                res[depth] = i;
                dfs(depth+1, prev, cnt+1);
            }else if(prev != i){
                res[depth]= i;
                dfs(depth+1, i, 1);
            }
        }
    }
}