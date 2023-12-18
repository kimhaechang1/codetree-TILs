import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int m;
    static int c;
    static int [][] map;
    static int max;
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
            int suma = 0;
            int sumb = 0;
            int total = 0;
            //System.out.println("도둑 a 가 고른 : "+Arrays.toString(s1));
            //System.out.println("도둑 b 가 고른 : "+Arrays.toString(s2));
            for(int i = 0;i<m;i++){
            	if(suma + s1[i] <= c) {
            		suma  += s1[i];
            		total += (s1[i]*s1[i]);
            	}
            	if(sumb + s2[i] <= c) {
            		sumb += s2[i];
            		total += (s2[i]*s2[i]);
            	}
            }
            max = Math.max(max, total);
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
}