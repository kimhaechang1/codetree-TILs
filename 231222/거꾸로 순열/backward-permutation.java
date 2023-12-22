import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean [] v;
    static int [] res;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        v = new boolean[n+1];
        res = new int[n];
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

        for(int i = n;i>0;i--){
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