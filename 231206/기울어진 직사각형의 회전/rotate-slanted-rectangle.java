import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [][] map;
    static StringTokenizer stk;
    // 반시계
    static int [] dy1= {-1,-1,1,1};
    static int [] dx1= {1,-1,-1,1};
    // 시계
    static int [] dy2= {-1,-1,1,1};
    static int [] dx2= {-1,1,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());
        int sy = Integer.parseInt(stk.nextToken())-1;
        int sx = Integer.parseInt(stk.nextToken())-1;
        int [] arr = new int[4];
        for(int i = 0;i<4;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int dir = Integer.parseInt(stk.nextToken());
        if(dir == 0){
            int temp = map[sy][sx];
            int ty = sy;
            int tx = sx;
            for(int i = 3;i>0;i--){
                ty = sy - dy1[i] * arr[i];
                tx = sx - dx1[i] * arr[i];
                int ny = sy;
                int nx = sx;
                while(true){
                    if(sy == ty && sx == tx) break;
                    ny = sy - dy1[i];
                    nx = sx - dx1[i];
                    map[sy][sx] = map[ny][nx];
                    sy = ny;
                    sx = nx;
                }
            }
            // 마지막 대각선의 경우 직접 조정
            ty = sy - dy1[0] * (arr[0]-1);
            tx = sx - dx1[0] * (arr[0]-1);
            int ny = sy;
            int nx = sx;
            while(true){
                if(sy == ty && sx == tx) break;
                ny = sy - dy1[0];
                nx = sx - dx1[0];
                map[sy][sx] = map[ny][nx];
                sy = ny;
                sx = nx;
            }
            map[sy][sx] = temp;
        }else{
            int temp = map[sy][sx];
            int ty = sy;
            int tx = sx;
            for(int i = 0;i<3;i++){
                ty = sy - dy2[3 - i] * arr[i];
                tx = sx - dx2[3 - i] * arr[i];
                int ny = sy;
                int nx = sx;
                while(true){
                    if(sy == ty && sx == tx) break;
                    ny = sy - dy2[3 - i];
                    nx = sx - dx2[3 - i];
                    map[sy][sx] = map[ny][nx];
                    sy = ny;
                    sx = nx;
                }
            }
            // 마지막 대각선의 경우 직접 조정
            ty = sy - dy2[0] * (arr[3]-1);
            tx = sx - dx2[0] * (arr[3]-1);
            int ny = sy;
            int nx = sx;
            while(true){
                if(sy == ty && sx == tx) break;
                ny = sy - dy2[0];
                nx = sx - dx2[0];
                map[sy][sx] = map[ny][nx];
                sy = ny;
                sx = nx;
            }
            map[sy][sx] = temp;
        }
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb1.append(map[i][j]).append(" ");
            }
            sb1.append("\n");
        }
        System.out.print(sb1);
        
    }
}