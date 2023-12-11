import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    static int m;
    static int sy;
    static int sx;
    static String [] crr;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    // 3차원 도형을 2차평면에 굴릴때에는 전개도를 상상한다.
    // 단, 2차평면에 굴릴때의 바닥면 혹은 기준면을 제외한 전개도를 2차원 배열에 저장
    // 지금 정육면체 이므로 굴릴때 방향에따라 변화하는 면이 달라짐
    // 주사위 특징이므로 마주보는 두 변의 합이 7인점을 특징으로 잡음
    // 굴리면 내려와서 아랫면으로 대체되는 면이 있고 원래 아랫면은 뒤로 밀린다.
    static int [][] dice = {
        {0, 5, 0},
        {4, 6, 3},
        {0, 2, 0}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        sy = Integer.parseInt(stk.nextToken())-1;
        sx = Integer.parseInt(stk.nextToken())-1;
        map = new int[n][n];
        stk = new StringTokenizer(bf.readLine());
        map[sy][sx] = dice[1][1];
        for(int i = 0;i<m;i++){
            int ny;
            int nx;
            String dir = stk.nextToken();
            if("L".equals(dir)){
                ny = sy + dy[2];
                nx = sx + dx[2];
                if(!OOB(ny, nx)) continue;
                dice[1] = new int[]{7- dice[1][1], dice[1][0], dice[1][1]};
                map[ny][nx] = dice[1][1];
                sy = ny;
                sx = nx;
                
            }else if("R".equals(dir)){
                ny = sy + dy[3];
                nx = sx + dx[3];
                if(!OOB(ny, nx)) continue;
                dice[1] = new int[]{dice[1][1], dice[1][2], 7-dice[1][1]};
                map[ny][nx] = dice[1][1];
                sy = ny;
                sx = nx;
            }else if("U".equals(dir)){
                ny = sy + dy[0];
                nx = sx + dx[0];
                if(!OOB(ny, nx)) continue;
                int temp = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[2][1] = temp;
                dice[0][1] = 7 - temp;
                map[ny][nx] = dice[1][1];
                sy = ny;
                sx = nx; 
            }else{
                ny = sy + dy[1];
                nx = sx + dx[1];
                if(!OOB(ny, nx)) continue;
                int temp = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = 7 - temp;
                dice[0][1] = temp;
                map[ny][nx] = dice[1][1];
                sy = ny;
                sx = nx;
            }
        }
        int sum =0;
        for(int i = 0;i<n;i++){
            for(int j = 0 ;j<n;j++){
                sum += map[i][j];
            }
        }
        System.out.print(sum);
        
    }
    static boolean OOB(int y, int x){
        if(y >= n || y < 0 || x >= n || x < 0) return false;
        return true;
    }
}