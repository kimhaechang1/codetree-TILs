import java.util.*;
import java.io.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int [][] map;
    static boolean [][] v;
    static StringTokenizer stk;
    static int n, sy,sx;
    static int k;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());
        sy = Integer.parseInt(stk.nextToken())-1;
        sx = Integer.parseInt(stk.nextToken())-1;
        while(k-- > 0){
            if(!findMax()) break;
        }
        System.out.print(sy+" "+sx);
    }
    static boolean findMax(){
        int l = map[sy][sx];
        int max = 1;
        boolean flg = false;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(l > map[i][j] && max < map[i][j]){
                    //System.out.println("ty : "+i +" tx : "+j);
                    if(bfs(i, j, l)){
                        flg = true;
                        sy = i;
                        sx = j;
                        //System.out.println("sy : "+sy +" sx : "+sx);
                        max = map[i][j];
                    }
                }
            }
        }
        return flg;
    }
    static boolean bfs(int y, int x, int limit){
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{sy, sx, limit});
        v = new boolean[n][n];
        v[sy][sx] = true;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            //System.out.println(Arrays.toString(now));
            if(now[0] == sy && now[1] == sx){
                return true;
            }
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(ny >= n || ny < 0 || nx >= n || nx < 0 || map[ny][nx] >= now[2] || v[ny][nx]) continue;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx, now[2]});
            }
        }   
        return false;
    }
}