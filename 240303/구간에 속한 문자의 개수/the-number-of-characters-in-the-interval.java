import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static char [][] map;
    static int [][][] conv;
    static int [][][] s;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new char[n+1][m+1];
        for(int i= 1;i<n+1;i++){
            char[] frags = bf.readLine().toCharArray();
            for(int j = 1;j<m+1;j++){
                map[i][j] = frags[j-1];
            }
        }
        s = new int[n+1][m+1][3];
        conv = new int[n+1][m+1][3];
        for(int i= 0;i<3;i++){
            for(int j = 1;j<n+1;j++){
                for(int t = 1;t<m+1;t++){
                    if(map[j][t] - ('a'+i) == 0 ){
                        conv[j][t][i] = 1;
                    }
                }
            }
        }
        /*for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                System.out.print(conv[i][j][0] +" ");
            }
            System.out.println();
        }*/
        for(int type = 0;type<3;type++){
            for(int i = 1;i<n+1;i++){
                for(int j = 1;j<m+1;j++){
                    s[i][j][type] = s[i-1][j][type] + s[i][j-1][type] - s[i-1][j-1][type] + conv[i][j][type];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<k ;i++){
            stk = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(stk.nextToken());
            int x1 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            for(int type = 0;type<3;type++){
                int res = s[y2][x2][type] - s[y1-1][x2][type] - s[y2][x1-1][type] + s[y1-1][x1-1][type];
                sb.append(res).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}