import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int [][] res;
    static Queue<int []> queue;
    static boolean [][][] v;
    static int n,h,m;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());h = Integer.parseInt(stk.nextToken());m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        res = new int[n][n];
        v = new boolean[n][n][h];
        int idx = 0;
        queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2){
                    queue.add(new int[]{i, j, i, j, idx, 0});
                    v[i][j][idx++] = true;
                    res[i][j] = -1;
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void bfs(){
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        while(!queue.isEmpty()){
                int [] now = queue.poll();
                if(map[now[2]][now[3]] == 3){
                    if(res[now[0]][now[1]] == -1) res[now[0]][now[1]] = now[5];
                    res[now[0]][now[1]] = Math.min(now[5], res[now[0]][now[1]]);
                    continue;
                }
                for(int k = 0;k<4;k++){
                    int ny = now[2] + dy[k];
                    int nx = now[3] + dx[k];
                    if(OOB(ny, nx) || v[ny][nx][now[4]] || map[ny][nx] == 1 ) continue;
                    v[ny][nx][now[4]] = true;
                    queue.add(new int[]{now[0],now[1], ny, nx,now[4], now[5]+1});
                }
            }
        }
    
    static boolean OOB(int y, int x){
        return y>=n || y < 0 || x>=n || x < 0;
    }
}