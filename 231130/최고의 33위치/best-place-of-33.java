import java.util.*;
import java.io.*;

public class Main {
    static int max;
    static int N;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i = 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        max = 0;
        for(int i = 0;i<N-3+1;i++){
            for(int j = 0;j<N-3+1;j++){
                int  c= 0;
                for(int k = i;k<i+3;k++){
                    for(int m = j;m<j+3;m++){
                        if(map[k][m] == 1) c++;
                    }
                }
                max = Math.max(max, c);
            }
        }
        System.out.print(max);
    }
}