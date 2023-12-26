import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int [][] map;
    static int [][] res;
    static Queue<int[]> queue;
    static StringTokenizer stk;
    static boolean [][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        res = new int[n][n];
        v = new boolean[n][n];
        queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2){
                    v[i][j] = true;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == 0 && res[i][j] == 0){
                    sb.append(-1).append(" ");
                }else if(map[i][j] == 2){
                    sb.append(0).append(" ");
                }else if(map[i][j] == 1 && res[i][j] == 0){
                    sb.append(-2).append(" ");
                }else{
                    sb.append(res[i][j]).append(" ");
                }
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
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(OOB(ny, nx) || map[ny][nx] != 1 || v[ny][nx]) continue;
                v[ny][nx] = true;
                res[ny][nx] = now[2]+1;
                queue.add(new int[]{ny, nx, now[2]+1});
            }
        }
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >= n || x < 0;
    }

}