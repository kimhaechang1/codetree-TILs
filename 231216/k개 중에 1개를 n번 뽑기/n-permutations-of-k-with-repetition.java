import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int n;
    static int [] arr;
    static int [] res;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        arr = new int[k+1];
        res = new int[n];
        
        for(int i = 1;i<=k;i++){
            arr[i] = i;
        }
        dfs(0, n);
        System.out.println(sb);
    }
    static void dfs(int depth, int n){
        if(depth == n){
            for(int i = 0;i<n;i++){
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1;i<=k;i++){
            res[depth] = i;
            dfs(depth+1, n);
        }
    }
}