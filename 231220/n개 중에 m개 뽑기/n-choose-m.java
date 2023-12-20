import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int m;
    static StringBuilder sb;
    static int [] res;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        res = new int[m];
        sb = new StringBuilder();
        dfs(1,0);
        System.out.print(sb);
    }
    static void dfs(int cur, int depth){
        if(depth == m){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = cur;i<=n;i++){
            res[depth] = i;
            dfs(i+1, depth+1);
        }
    }   
}