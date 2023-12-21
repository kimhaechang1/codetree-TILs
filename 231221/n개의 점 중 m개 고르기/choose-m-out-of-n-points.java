import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<int[]> list;
    static int [][] res;
    static StringTokenizer stk;
    static int max;
    static int min;
    static boolean [] sel;
    static int [][] poses;
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            list.add(new int[]{a,b});
        }
        res = new int[m][2];
        min = 987654321;
        dfs(0,0);
        System.out.println(min);
    }
    static void dfs(int depth, int cur){
        if(depth == m){
            max = 0;
            poses = new int[2][2];
            getMax(0, 0);
            min = Math.min(min, max);
            return;
        }
        for(int i = cur;i<n;i++){
            int [] pos = list.get(i);
            res[depth][0] = pos[0];
            res[depth][1] = pos[1];
            dfs(depth+1, i+1);
        }
    }
    static void getMax(int depth, int cur){
        if(depth ==  2){            
            int val = (int)Math.pow(poses[0][0] - poses[1][0], 2) + (int)Math.pow(poses[0][1] - poses[1][1], 2);
            max = Math.max(val, max);
            return;
        }
        for(int i = cur;i<m;i++){
            poses[depth][0] = res[i][0];
            poses[depth][1] = res[i][1];
            getMax(depth+1, i+1);
        }
    }
    
}