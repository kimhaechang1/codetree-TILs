import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    static int k;
    static int u;
    static int d;
    static int max;
    static ArrayList<int []> posList;
    static int [] res;
    static boolean [][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        u = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        posList =new ArrayList<>();
        res = new int[k];
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                posList.add(new int[]{i, j});
            }
        }
        max = 0;
        dfs(0,0);

        System.out.print(max);
        
    }
    static void dfs(int depth, int cur){
        if(depth == k){
            int sum = 0;
            v = new boolean[n][n];
            for(int r : res){
                int [] pos = posList.get(r);
                if(v[pos[0]][pos[1]]) continue;
                sum += bfs(pos[0], pos[1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = cur;i<posList.size();i++){
            res[depth] = i;
            dfs(depth+1, cur+1);
        }
    }
    static int bfs(int sy, int sx){
        Queue<int []> queue =new ArrayDeque<>();
        v[sy][sx] = true;
        int c = 1;
        queue.add(new int[]{sy, sx});
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(OOB(ny, nx) || v[ny][nx]) continue;
                int cha = Math.abs(map[now[0]][now[1]] - map[ny][nx]);
                if(cha < u || cha > d) continue;
                c++;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return c;
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >= n || x < 0;
    }
}