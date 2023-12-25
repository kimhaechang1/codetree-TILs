import java.util.*;
import java.io.*;


public class Main {
    static int n,m;
    static int [][] map;
    static int sy = 0;
    static int sx = 0;
    static int ty;
    static int tx;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        ty = n-1;
        tx = m-1;
        System.out.print(bfs() ? 1 : 0);
    }
    static boolean bfs(){
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{sy, sx});
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        boolean [][] v = new boolean[n][m];
        v[sy][sx] = true;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(now[0] == ty && now[1] == tx) return true;
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(ny >= n || ny < 0 || nx >= m || nx < 0 || v[ny][nx] || map[ny][nx] == 0) continue;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return false;
    }
}