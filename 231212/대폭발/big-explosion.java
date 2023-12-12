import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int[][] map;
    static int n, m, sy, sx;
    static Queue<int []> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        sy = Integer.parseInt(stk.nextToken())-1;
        sx = Integer.parseInt(stk.nextToken())-1;
        map = new int[n][n];
        int time = 0;
        map[sy][sx] = 1;
        int cnt = 1;
        queue = new ArrayDeque<>();
        queue.add(new int[]{sy, sx});
        while(++time <= m){
            cnt +=bfs(time);
        }
        System.out.print(cnt);
    }
    static int bfs(int t){
        int cnt = 0;
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        int size = queue.size();
        for(int i = 0;i<size;i++){
            int [] now = queue.poll();
            queue.add(new int[]{now[0],now[1]});
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k] * (int)Math.pow((double)2, (double)t-1);
                int nx = now[1] + dx[k] * (int)Math.pow((double)2, (double)t-1);
                if(ny >= n || ny < 0 || nx >= n || nx < 0|| map[ny][nx] != 0) continue;
                map[ny][nx] = 1;
                cnt++; 
                queue.add(new int[]{ny, nx});
            }
        }
        return cnt;
    }
}