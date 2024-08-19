import java.util.*;
import java.io.*;

public class Main {
    static char[] brr;
    static char[] arr;
    static int n;
    static int[][] scores;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        brr = new char[n+1];
        arr = new char[n+1];
        for(int i = 1;i<n+1;i++){
            brr[i] = bf.readLine().charAt(0);
        }

        char[] cl = new char[]{'H','S','P'};
        // 어느지점에서 바꾸냐가 중요함
        // 두개의 낼 요소를 정하고 그 요소대로 LR 
        scores = new int[3][n+1];
        for(int i = 0;i<3;i++){
            for(int j = 1;j<n+1;j++) {
                scores[i][j] = scores[i][j-1] + (cl[(i+1) % 3] == brr[j] ? 1 : 0);
            }
        }
        /*for(int i = 0;i<3;i++){
            System.out.println(Arrays.toString(scores[i]));
        }*/
        int ans = 0;
        for(int i= 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(i == j) continue;
                ans = Math.max(ans, go(i, j));
            }
        }
        System.out.println(ans);

    }
    static int go(int l, int r){
        int max = scores[l][n];
        for(int i= 2;i<n+1;i++){
            max = Math.max(scores[l][i-1] + (scores[r][n] - scores[r][i-1]), max);
        }
        return max;
    }
}