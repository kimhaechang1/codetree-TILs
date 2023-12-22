import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> [] g;
    static boolean [] v;
    static int n, m;
    static StringTokenizer stk;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = new boolean[n+1];
        g = new ArrayList[n+1];
        for(int i = 1;i<n+1;i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            stk = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(stk.nextToken());
            int v2 = Integer.parseInt(stk.nextToken());
            g[v1].add(v2);
            g[v2].add(v1);
        }
        max = 1;
        v[1] = true;
        dfs(0, 1);
        int cnt = 0;
        for(int i = 2;i<n+1;i++){
            cnt = v[i] ? cnt+1 : cnt;
        }
        System.out.println(cnt);
    }
    static void dfs(int depth, int pres){
        for(int vertex : g[pres]){
            if(v[vertex]) continue;
            v[vertex] = true;
            dfs(depth+1, vertex);
        }
    }
}