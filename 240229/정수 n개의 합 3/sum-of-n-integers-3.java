import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n+1][n+1];
        for(int i = 1;i<=n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 1;j<=n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [][] s = new int[n+1][n+1];
        for(int i= 1;i<n+1;i++){
            for(int j =1;j<n+1;j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + map[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<n+1-(k-1);i++){
            for(int j = 1;j<n+1-(k-1);j++){
                int result = s[i+(k-1)][j+(k-1)] - s[i+(k-1)][j-1] - s[i-1][j+(k-1)] + s[i-1][j-1];
                max = Math.max(result, max);
            }
        }
        System.out.print(max);
    }
}