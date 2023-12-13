import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int[][] map;
    static int n;
    static int m;
    static int t;
    static int [][] ncount;
    static Queue<int []> queue;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j =0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        queue = new ArrayDeque<>();
        for(int i =0;i<m;i++){
            stk =new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(stk.nextToken())-1;
            int x = Integer.parseInt(stk.nextToken())-1;
            queue.add(new int[]{y, x});
        }

        while(t-- >0){
            ncount = new int[n][n];
            bfs();
            collapsAndPushQueue();
        }
        System.out.println(m);
    }
    static void bfs(){
        int size = queue.size();
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        for(int i = 0;i<size;i++){
            int [] now = queue.poll();
            int cany = now[0];
            int canx = now[1];
            int maxVal = -1;
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                if(maxVal < map[ny][nx]){
                    maxVal = map[ny][nx];
                    cany = ny;
                    canx = nx;
                }
            }
            ncount[cany][canx]++;
        }
    }
    static void collapsAndPushQueue(){
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(ncount[i][j] > 1){
                    m -= ncount[i][j];
                }else if(ncount[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }
    }
    

}