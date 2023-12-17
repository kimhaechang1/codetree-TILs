import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int [][] bridge;
    static boolean[] selected;
    static int n;
    static int m;
    static int [] res;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        selected = new boolean[m];
        map = new int[15][n];
        bridge = new int[m][2];
        for(int i = 0;i<m;i++){
            stk = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(stk.nextToken())-1;
            int r = Integer.parseInt(stk.nextToken())-1;
            bridge[i][0] = c;
            bridge[i][1] = r;
        }
        res = new int[n];
        min = m;
        init();
        dfs(0);
        
        System.out.print(min);
    }
    static void init(){
        int [][] cp = initMap();
        for(int i =0;i<m;i++){
            selected[i] = true;
        }
        cp = make(selected, cp);
        go(cp);
        for(int i =0;i<m;i++){
            selected[i] = false;
        }
        
    }
    static void dfs(int depth){
        if(depth == m){
            int cnt = 0;
            int [][] cp = initMap();
            for(int i = 0;i<m;i++){
                if(!selected[i]) continue;
                int c = bridge[i][0];
                int r = bridge[i][1];
                cp[r][c] = c+1;
                cp[r][c+1] = c;
                cnt++;
            }
            if(cnt >= min) return;
            if(chk(cp)){
                min = Math.min(cnt, min);
            }
            return;
        }
        selected[depth] = true;
        dfs(depth+1);
        selected[depth] = false;
        dfs(depth+1);
    }
    static int [][] initMap(){
        int [][] cp = new int[15][n];
        for(int i =0;i<15;i++){
            for(int j = 0;j<n;j++) {
            	cp[i][j] = -1;
            }
        }
        return cp;
    }
    static int [][] make(boolean [] sel, int [][] cp){
        for(int i = 0;i<m;i++){
            if(!sel[i]) continue;
            int c = bridge[i][0];
            int r = bridge[i][1];
            cp[r][c] = c+1;
            cp[r][c+1] = c;
        }
        return cp;
    }
    static void go(int [][] cp) {
        int [] r= new int[n];
        
        for(int i = 0;i<n;i++){
        	boolean [][] v = new boolean[15][n];
            int sy = 0;
            int sx = i;
            while(true){
                if(sy == 15){
                    r[i] = sx;
                    break;
                }
                v[sy][sx] = true;
                if(cp[sy][sx] > -1 && !v[sy][cp[sy][sx]]){
                    sx = cp[sy][sx];
                }else{
                    sy +=1;
                }
            }
        }
        res = r.clone();
    }
    static boolean chk(int [][] cp){
        for(int i = 0;i<n;i++){
            int sy = 0;
            int sx = i;
            boolean [][] v = new boolean[15][n];
            while(true){
                if(sy == 15){
                    break;
                }
                v[sy][sx] = true;
                if(cp[sy][sx] > -1 && !v[sy][cp[sy][sx]]){
                    sx = cp[sy][sx];
                }else{
                    sy +=1;
                }
            }
            if(res[i] != sx){
                return false;
            }
        }
        return true;
    }
}