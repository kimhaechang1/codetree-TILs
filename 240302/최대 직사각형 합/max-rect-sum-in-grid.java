import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static StringTokenizer stk;
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
        /*for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }*/
        int [][] s = new int[n+1][n+1];
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + map[i][j];
            }
        }
        /*for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                System.out.print(s[i][j] +" ");
            }
            System.out.println();
        }*/
        int max = Integer.MIN_VALUE;
        for(int h = 0;h<n;h++){
            for(int w = 0;w<n;w++){
                for(int i = 1;i<n+1-h;i++){
                    for(int j = 1;j<n+1-w;j++){
                        int result = s[i+h][j+w] - s[i+h][j-1] - s[i-1][j+w] + s[i-1][j-1];
                        max = Math.max(max, result);
                    }
                }
            }
        }
        System.out.print(max);
    }
}