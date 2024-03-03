import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n+1][n+1];
        for(int i= 1;i<n+1;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 1;j<n+1;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [][] s = new int[n+1][n+1];
        for(int i= 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                // 일단 높이로 누적합 구하기
                s[i][j] = s[i-1][j] + map[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<n+1;i++){
            for(int j= 1;j<n+1;j++){
                int sum = 0;
                // 왼쪽 영역
                for(int off = 0; off<=k;off++){
                    int sy = i - (k-off);
                    int sx = j - off;
                    int ny = i + (k - off);
                    int nx = j - off;
                    
                    if(sy < 1){
                        sy = 1;
                    }
                    if(ny >= n +1 ) {
                    	ny = n;
                    }
                    if(sx >= n+1 || sx < 1){
                        continue;
                    }
                    sum += (s[ny][nx] - s[sy-1][sx]);
                }
                // 오른쪽 영역
                for(int off = 0; off<=k;off++){
                    int sy = i - (k-off);
                    int sx = j + off;
                    int ny = i + (k - off);
                    int nx = j + off;
                    if(sy < 1){
                        sy = 1;
                    }
                    if(ny >= n+1){
                        ny = n;
                    }
                    if(sx >= n+1 || sx < 1) continue;
                    sum += (s[ny][nx] - s[sy-1][sx]);
                }
                // 중복되는 부분 빼주기
                int msy = i - k;
                int msx = j;
                int mny = i + k;
                int mnx = j;
                if(msy < 1){
                    msy = 1;
                }
                if(mny >= n+1){
                    mny = n;
                }
                sum -= (s[mny][mnx] - s[msy-1][msx]);
                max = Math.max(max, sum);
            }
        }
        System.out.print(max);

    }
}