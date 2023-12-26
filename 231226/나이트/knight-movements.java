import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int [][] map;
    static int [] dy = {-1,-2,-2,-1,1,2,2,1};
    static int [] dx = {-2,-1,1,2,2,1,-1,-2};
    static StringTokenizer stk;
    static int sy,sx,ty,tx;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        stk =new StringTokenizer(bf.readLine());
        sy= Integer.parseInt(stk.nextToken())-1;sx= Integer.parseInt(stk.nextToken())-1;
        ty= Integer.parseInt(stk.nextToken())-1;tx= Integer.parseInt(stk.nextToken())-1;
        System.out.print(bfs());
    }
    static int bfs(){
        Queue<int []> queue = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        v[sy][sx] = true;
        queue.add(new int[]{sy, sx, 0});
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(ty == now[0] && tx == now[1]) return now[2];
            for(int k = 0 ;k<8;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(OOB(ny, nx) || v[ny][nx]) continue;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx, now[2]+1});
            }
        }
        return -1;
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >= n || x < 0;
    }
}