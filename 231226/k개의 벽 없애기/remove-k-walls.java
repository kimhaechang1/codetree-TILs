import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[][] map;
    static boolean [][][] v;
    static StringTokenizer stk;
    static int sy,sx,ty,tx;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        v = new boolean[n][n][k+1];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());
        sy = Integer.parseInt(stk.nextToken())-1;sx = Integer.parseInt(stk.nextToken())-1;
        stk = new StringTokenizer(bf.readLine());
        ty = Integer.parseInt(stk.nextToken())-1;tx = Integer.parseInt(stk.nextToken())-1;

        System.out.print(bfs());
    }
    static int bfs(){
        Queue<int []> queue = new ArrayDeque<>();
        v[sy][sx][0] = true;
        queue.add(new int[]{sy, sx, 0, 0});
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(now[0] == ty && now[1] == tx){
                return now[3];
            }
            for(int dir = 0;dir<4;dir++){
                int ny = now[0] + dy[dir];
                int nx = now[1] + dx[dir];
                
                if(OOB(ny, nx) || v[ny][nx][now[2]]) continue;
                v[ny][nx][now[2]] = true;
                if(map[ny][nx] == 1 && now[2]+1 <= k){
                    queue.add(new int[]{ny, nx, now[2]+1, now[3]+1});
                }else if(map[ny][nx] == 0){
                    queue.add(new int[]{ny, nx, now[2], now[3]+1});
                }
            }
        }
        return -1;
    }
    static boolean OOB(int y, int x){
        return y >=n || y < 0 || x >= n || x < 0;
    }
}