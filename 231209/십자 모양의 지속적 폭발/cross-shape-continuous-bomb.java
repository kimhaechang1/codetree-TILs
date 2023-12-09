import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0;i<m;i++){
            int q = Integer.parseInt(bf.readLine());
            if(boom(q-1)){
                go();
            }
        }
        print();
    }
    static boolean boom(int sx){
        int sy = 0;
        while(true){
            if(sy >= n) return false;
            if(map[sy][sx] > 0) break;
            sy++;
        }
        int len = map[sy][sx];
        map[sy][sx] = 0;
        
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        if(len <= 1) return false;
        for(int k = 0;k<4;k++){
            for(int i = 1;i<len;i++){
                int ny = sy + dy[k] *i;
                int nx = sx + dx[k] *i;
                if(ny >= n || ny < 0 || nx >=n || nx < 0) break;
                map[ny][nx] = 0;
            }
        } 
        return true;
        
    }
    static void go(){
        for(int i = 0;i<n;i++){
            int tempidx = n-1;
            int [] temp = new int[n];
            for(int j= n-1;j>-1;j--){
                if(map[j][i] != 0){
                    temp[tempidx--] = map[j][i];
                }
            }
            for(int j = n-1;j>-1;j--){
                if(tempidx < j){
                    map[j][i] = temp[j];
                }else{
                    map[j][i] = 0;
                }
            }
        }       
    }
    static void print(){
        StringBuilder sb= new StringBuilder();
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j+=1){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}