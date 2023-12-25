import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static StringTokenizer stk;
    static int [][] map;
    static boolean [][] v;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
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
        v = new boolean[n][n];
        int sum = 0;
        while(m-- > 0){
            stk = new StringTokenizer(bf.readLine());
            int sy = Integer.parseInt(stk.nextToken())-1;
            int sx = Integer.parseInt(stk.nextToken())-1;
            if(v[sy][sx]) continue;
            sum += bfs(sy, sx);
        }
        System.out.print(sum);
    }
    static int bfs(int y, int x){
        int c = 1;
        Queue<int []> queue = new ArrayDeque<>();
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        v[y][x] = true;
        queue.add(new int[]{y, x});
        while(!queue.isEmpty()){
            int []  now = queue.poll();
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(ny >= n || ny < 0|| nx>= n || nx < 0 || v[ny][nx] || map[ny][nx] == 1) continue;
                c++;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return c;
    }
}