import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int m;
    static int n;
    static StringTokenizer stk;
    static int [] arr;
    static int [] sel;
    static int max = 0;
    public static void main(String[] args)  throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        sel = new int[n];
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth){
        if(depth == n){
            max = Math.max(go(sel),max);
            return;
        }

        for(int i = 1;i<=k;i++){
            sel[depth] = i;
            dfs(depth+1);
        }
    }
    static int go(int [] mal){
        int s= 0;
        int [] play = new int[k+1];
        for(int i = 0;i<mal.length;i++){
            play[mal[i]] = 1;
        }
        for(int i = 0;i<mal.length;i++){
            if(play[mal[i]] >= m) continue;
            if(play[mal[i]] + arr[i] >= m ){
                play[mal[i]] += arr[i];
                s++;
            }else{
                play[mal[i]] += arr[i];
            }
        }
        return s;
    }

}