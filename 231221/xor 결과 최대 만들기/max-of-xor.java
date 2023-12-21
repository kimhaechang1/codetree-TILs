import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    static int [] res;
    static int n, m;
    static StringTokenizer stk;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        m = Integer.parseInt(stk.nextToken());
        res = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(0, 0);
        System.out.print(max);
    }
    static void dfs(int depth, int cur){
        if(depth == m){
            int sum = res[0];
            for(int i  = 1;i<m;i++){
                sum ^= res[i];
            }
            max = Math.max(sum, max);
            return;
        }

        for(int i = cur;i<n;i++){
            res[depth] = arr[i];
            dfs(depth+1, i+1);
        }
    }
}