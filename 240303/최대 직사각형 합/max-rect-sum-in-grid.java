import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static StringTokenizer stk;
    static int [] dp;
    static int [][] s;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n+1][n+1];
        for(int i= 1;i<n+1;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 1;j<n+1;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        s = new int[n+1][n+1];
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + map[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        dp = new int[n+1];
        for(int i = 1;i<n+1;i++){
            for(int j = i;j<n+1;j++){
                max = Math.max(max, getMaxArea(i, j));
            }
        }
        System.out.print(max);
    }
    static int getMaxArea(int y1, int y2){
        for(int x = 1;x<n+1;x++){
            int value = getSum(y1, x,y2, x);
            dp[x] = Math.max(value, dp[x-1] + value);
        }        
        int maxArea = Integer.MIN_VALUE;
        for(int x =1;x<=n;x++){
            maxArea = Math.max(maxArea, dp[x]);
        }
        return maxArea;
    }
    static int getSum(int y1, int x1, int y2, int x2){
        return s[y2][x2] - s[y1-1][x2] - s[y2][x1-1] + s[y1-1][x1-1];
    }
}