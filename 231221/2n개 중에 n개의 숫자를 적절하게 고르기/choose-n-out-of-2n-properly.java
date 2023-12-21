import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int [] arr;
    static boolean [] sel;
    static int min = 9999999;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[2*n];
        sel = new boolean[2*n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<2*n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        dfs(0, 0);
        System.out.println(min);
    }
    static void dfs(int depth, int cur){
        if(depth == n){
            int s = 0;
            int s1= 0;
            for(int i = 0;i<2*n;i++){
                if(!sel[i]){
                    s += arr[i];
                }else{
                    s1+=arr[i];
                }
            }
            min = Math.min(min, Math.abs(s1 - s));
            return;
        }

        for(int i = cur;i<2*n;i++){
            sel[i] = true;
            dfs(depth+1, i+1);
            sel[i] = false;
        }
    }
}