import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static int [] dy = {-1,-1,1,1};
    static int [] dx = {1,-1,-1,1};
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // 왼쪽 아래로 기우는 대각선 길이 1부터 시작 -> a
        // 오른쪽 아래로 기우는 대각선 길이 1부터 시작 -> b
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int a = 1;a<=n-1;a++){
                    for(int b = 1;b<=n-1;b++){
                        int res = go(i,j,a,b);
                        if(res != -1) max = Math.max(max, res);
                    }
                }
            }
        }
        System.out.print(max);
    }
    static int go(int sy, int sx, int a, int b){
        int ny = sy;
        int nx = sx;
        int sum = 0;
        for(int dir = 0;dir<4;dir++){
            int c = 0;
            int limit = (dir+1) % 2 != 0 ? a : b;
            while(c++ < limit){
                ny += dy[dir];
                nx += dx[dir];
                if(ny >= n || ny < 0 || nx >= n || nx < 0) return -1;
                sum += map[ny][nx];
            } 
            
        }
        if(ny == sy && nx == sx){
            return sum;
        }
        return -1;
    }
}