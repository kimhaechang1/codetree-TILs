import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int [] res;
    static boolean [] v;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        sb =new StringBuilder();
        res = new int[n];
        v = new boolean[n+1];
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int depth){
        if(depth == n){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1;i<=n;i++){
            if(v[i]) continue;
            v[i] = true;
            int temp = res[depth];
            res[depth] = i;
            dfs(depth+1);
            res[depth] = temp;
            v[i] = false;
        }
    }
}