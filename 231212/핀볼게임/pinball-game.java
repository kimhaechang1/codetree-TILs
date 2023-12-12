import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n;
    static StringTokenizer stk;
    static boolean [][][] v;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map =new int[n+2][n+2];
        for(int i = 1;i<=n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 1;j<=n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int sy = 0;
        int sx = 0;
        int max = 0;
        int sd = 3;
        int dir = 1;
        while(true){
            sy += dy[sd];
            sx += dx[sd];
            if(sy == 0 && sx == 0) break;
            if(sy == 0 && sx == n+1){
                sy++;
                sd = 1;
                dir = 2;
            }else if(sy == n+1 && sx == n+1){
                sx--;
                sd = 2;
                dir = 0;
            }else if(sy == n+1 && sx == 0){
                sy--;
                sd = 0;
                dir = 3;
            }
            //System.out.println()
            v = new boolean[n+2][n+2][4];
            v[sy+dy[dir]][sx+dx[dir]][dir] = true;
            printvisit();
            max = Math.max(max, go(sy+dy[dir], sx+dx[dir], 1, dir));
        }
        System.out.print(max+1);
    }
    static int go(int sy, int sx, int time, int dir){
        int res = 0;
        while(true){
            dir = chk(sy, sx, dir);
            int ny = sy + dy[dir];
            int nx = sx + dx[dir];
            if(ny >= n || ny < 0 || nx >= n || nx < 0){
                res = time+1;
                break;
            }
            if(v[ny][nx][dir]){
                res = 0;
                break;
            }
            v[ny][nx][dir] = true;
            sy = ny;
            sx = nx;
            time+=1;
        }
        return res;
    }
    static int chk(int y, int x, int preDir){
        if(map[y][x] == 1){
            if(preDir == 0){
                return 3;
            }else if(preDir == 1){
                return 2;
            }else if(preDir == 2){
                return 1;
            }else{
                return 0;
            }
        }else if(map[y][x] == 2){
            if(preDir == 0){
                return 2;
            }else if(preDir == 1){
                return 3;
            }else if(preDir == 2){
                return 0;
            }else{ 
                return 1;
            }
        }else{
            return preDir;
        }
        
    }
    static void printvisit(){

    }
}