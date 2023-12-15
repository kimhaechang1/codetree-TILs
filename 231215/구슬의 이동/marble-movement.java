import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int t;
    static int k;
    static int [][] status;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static PriorityQueue<int []> [][] pq;
    static StringTokenizer stk;
    static boolean [] dead;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        pq = new PriorityQueue[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                pq[i][j] = new PriorityQueue<>((o1, o2)->{
                    // idx, d, v
                    if(o1[1] == o2[1]){
                        return o2[0] - o1[0];
                    }
                    return o2[1] - o1[1];
                });
            }
        }
        dead = new boolean[m];
        status = new int[m][4];
        for(int i = 0;i<m;i++){
            stk = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(stk.nextToken())-1;
            int x = Integer.parseInt(stk.nextToken())-1;
            int d = getDir(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            status[i][0] = y;
            status[i][1] = x;
            status[i][2] = d;
            status[i][3] = v;
        }

        while(t-- > 0){
            init();
            move();
            kchk();
        }
        System.out.println(m);
    }
    static void init(){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                pq[i][j].clear();
            }
        }
    }
    static void move(){
        for(int i = 0;i<m;i++){
            if(dead[i]) continue;
            int y = status[i][0];
            int x = status[i][1];
            int dir = status[i][2];
            int v = status[i][3];
            while(v-- > 0){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny >= n || ny < 0 || nx >= n || nx < 0){
                    if(dir == 3){
                        dir = 2;
                    }else if(dir == 2){
                        dir = 3;
                    }else if(dir == 0){
                        dir = 1;
                    }else{
                        dir = 0;
                    }
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }
                y = ny;
                x = nx;
            }
            pq[y][x].add(new int[]{i, v});
            status[i][0] = y;
            status[i][1] = x;
            status[i][2] = dir;
        }
    }
    static void kchk(){
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(pq[i][j].size() > k){
                    int cnt = k;
                    while(cnt-- > 0) pq[i][j].poll();
                    while(!pq[i][j].isEmpty()){
                        int [] now = pq[i][j].poll();
                        dead[now[0]] = true;
                        --m;
                    }
                }
            }
        }
    }
    static int getDir(String dir){
        if("U".equals(dir)){
            return 0;
        }else if("D".equals(dir)){
            return 1;
        }else if("L".equals(dir)){
            return 2;
        }else{
            return 3;
        }
    }
}