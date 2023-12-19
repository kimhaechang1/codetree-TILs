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
        count = new int[k+1];
        for(int i = 1;i<=k;i++){
            count[i] = 2;
        }
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);
    }
    static void dfs(int depth){
        if(depth == n){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1;i<=k;i++){
            if(count[i] > 0){
                res[depth] = i;
                count[i]--;
                dfs(depth+1);
                count[i]++;
            }
        }
    }
}