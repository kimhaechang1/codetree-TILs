import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int m;
    static int c;
    static int [][] map;
    static int max;
    static int max1;
    static int max2;
    static boolean [] sel; 
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }   
        max = 0;
        int [] s1 = new int[m];
        int [] s2 = new int[m];
        dfs(0, 0, 0, s1, s2);
        
        System.out.print(max); 
    }
    static void dfs(int depth, int sy, int sx, int [] s1, int [] s2){
        if(depth == 2){
        	max1 = 0;
        	max2 = 0;
            sel = new boolean[m];
            go1(0, 0, s1);
            sel = new boolean[m];
            go2(0, 0, s2);
            max = Math.max(max, (max1 + max2));
            return;
        }
        if(depth == 0){
            for(int i = sy;i<n-1;i++){
                for(int j = 0;j<n-(m-1);j++){
                	for(int k = j;k<j+m;k++) {
                		s1[k-j] = map[i][k];
                	}
                	dfs(depth+1, i, j+m, s1, s2);
                }
            }
        }
        if(depth == 1){
            if(sx+(m-1) < n){
                for(int i = sx;i<n-(m-1);i++){
                	for(int k = i;k<i+m;k++) {
                		s2[k-i] = map[i][k];
                	}
                	dfs(depth+1, sy, i+m, s1, s2);
                }
            }
            for(int i = sy+1;i<n;i++){
                for(int j = 0;j<n-(m-1);j++){
                	for(int k = j;k<j+m;k++) {
                		s2[k-j] = map[i][k];
                	}
                	dfs(depth+1, i, j, s1, s2);
                }
            }
        }
    }
    static void go1(int depth, int sum, int [] arr) {
    	if(sum > c) return;
    	if(depth == m) {
    		int total = 0;
    		for(int i = 0;i<m;i++) {
    			if(!sel[i]) continue;
    			total += (arr[i]*arr[i]);
    		}
    		max1 = Math.max(total, max1);
    		return;
    	}
    	sel[depth] = true;
    	go1(depth+1, sum + arr[depth], arr);
    	sel[depth] = false;
    	go1(depth+1, sum, arr);
    }
    
    static void go2(int depth, int sum, int [] arr) {
    	if(sum > c) return;
    	if(depth == m) {
    		int total = 0;
    		for(int i = 0;i<m;i++) {
    			if(!sel[i]) continue;
    			total += (arr[i]*arr[i]);
    		}
    		max2 = Math.max(total, max2);
    		return;
    	}
    	sel[depth] = true;
    	go2(depth+1, sum + arr[depth], arr);
    	sel[depth] = false;
    	go2(depth+1, sum, arr);
    }
}