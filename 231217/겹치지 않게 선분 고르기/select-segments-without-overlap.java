import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int [][] arr;
    static boolean [] used;
    static boolean [] selected;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][2];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            arr[i][0] = x1;
            arr[i][1] = x2;
        }
        
        selected = new boolean[n];
        dfs(0);
        System.out.print(max);
    }
    static void dfs(int depth){
        if(depth == n){
            used = new boolean[1001];
            int cnt = 0;
            for(int i =0;i<n;i++){
                cnt = selected[i] ? cnt+1 : cnt+0;
            }
            if(cnt == 0) return;
            if(max >= cnt) return;
            max = chk(selected) ? Math.max(max, cnt) : max;
            return;
        }
        selected[depth] = true;
        dfs(depth+1);
        selected[depth] = false;
        dfs(depth+1);
    }

    static boolean chk(boolean [] sel){
        for(int i = 0;i<n;i++){
            if(!sel[i]) continue;
            int x1 = arr[i][0];
            int x2 = arr[i][1];
            for(int j = x1;j<=x2;j++){
                if(used[j]) return false;
                used[j] = true;
            }
        }
        return true;
    }
}