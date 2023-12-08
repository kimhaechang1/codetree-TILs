import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j =0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());
        int sy = Integer.parseInt(stk.nextToken())-1;
        int sx = Integer.parseInt(stk.nextToken())-1;
        boom(sy, sx);
        go();
        print();
    }
    static void boom(int y, int x){
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        int len = map[y][x];
        map[y][x] = 0;
        if(len == 1) return;
        for(int k = 0;k<4;k++){
            for(int i = 1;i<len;i++){
                int ny = y + dy[k] * i;
                int nx = x + dx[k] * i;
                if(ny >= n || ny < 0 || nx >= n || nx < 0) break;
                map[ny][nx] = 0;
            }
        }
    }

    static void go(){
        for(int i = 0;i<n;i++){
            int [] tmp = new int[n];
            int tempidx = n-1;
            for(int j = n-1;j>-1;j--){
                if(map[j][i] != 0){
                    tmp[tempidx--] = map[j][i];
                }
            }
            for(int j = n-1; j>-1;j--){
                if(tempidx <= j){
                    map[j][i] = tmp[j];
                }else{
                    map[j][i] = 0;
                }
            }
        }
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}