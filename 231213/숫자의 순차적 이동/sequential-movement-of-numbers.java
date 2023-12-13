import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n,m;
    static int [][] positionOfNumber;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        positionOfNumber = new int[n*n+1][2];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                positionOfNumber[map[i][j]][0] = i;
                positionOfNumber[map[i][j]][1] = j;
            }   
        }
        while(m-- > 0){    
            for(int i = 1;i<=n*n;i++){
                int [] nynx = find(positionOfNumber[i][0],positionOfNumber[i][1]);
                swap(nynx[0], nynx[1], positionOfNumber[i][0], positionOfNumber[i][1]);   
            }
        }
        print();
    }
    static int[] find(int y, int x){
        int [] dy = {-1,1,0,0,-1,-1,1,1};
        int [] dx = {0,0,-1,1,1,-1,-1,1};
        int [] res = new int[2];
        int maxVal = -1;
        for(int k = 0;k<8;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if(maxVal < map[ny][nx]){
                maxVal = map[ny][nx];
                res[0] = ny;
                res[1] = nx;
            }
        }
        return res;
    }
    static void swap(int ny, int nx, int y, int x){
        positionOfNumber[map[ny][nx]][0] = y;
        positionOfNumber[map[ny][nx]][1] = x;
        positionOfNumber[map[y][x]][0] = ny;
        positionOfNumber[map[y][x]][1] = nx;
        int temp = map[y][x];
        map[y][x] = map[ny][nx];
        map[ny][nx] = temp;
    }
    static void print(){
        StringBuilder sb =new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}