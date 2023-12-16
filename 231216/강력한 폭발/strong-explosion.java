import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static StringTokenizer stk;
    static int [] arr;
    static ArrayList<int []> pos;
    static int max = 0;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        cnt = 0;
        pos = new ArrayList<>();
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] > 0){
                    pos.add(new int[]{i, j});
                    cnt++;
                }
            }
        }
        arr = new int[cnt];
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth){
        if(depth == cnt){
            int [][] cp = copy();
            for(int i = 0;i<cnt;i++){
                int [] p = pos.get(i);
                cp[p[0]][p[1]] = arr[i];
            }
            int p = go(cp);
            max = Math.max(max, p);
            return;
        }
        for(int i = 1;i<=3;i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
    static int[][] copy(){
        int [][] cp = new int[n][n];
        for(int i =0;i<n;i++){
            cp[i] = map[i].clone();
        }
        return cp;
    }
    static int go(int [][] m){
        int res = cnt;
        int [][][] d = {
            {{},{},{},{}},
            { 
                {-2, 0},
                {-1, 0},
                {1, 0},
                {2, 0}
            },{
                {-1,0},
                {1,0},
                {0,1},
                {0,-1}
            },{
                {-1,1},
                {-1,-1},
                {1,1},
                {1,-1}
            }
        };
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(m[i][j] <= 0){
                    continue;
                }
                int val = m[i][j];
                int [][]dydx = d[val];
                for(int k =0;k<4;k++){
                    int ny = i+dydx[k][0];
                    int nx = j+dydx[k][1];
                    if(ny >= n || ny < 0 || nx >= n || nx < 0 || m[ny][nx] !=0) continue;
                    res++;
                    m[ny][nx] = -1; 
                }
            }
        }
        return res;
    }
}