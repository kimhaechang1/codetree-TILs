import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static ArrayList<int[]> posList;
    static int [][] map;
    static int m;
    static int k;
    static int [] res;
    static boolean [][] v;
    static int [][] startPos;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        res = new int[m];
        posList = new ArrayList<>();
        startPos = new int[k][2];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1){
                    posList.add(new int[]{i , j});
                }
            }
        }
        for(int i = 0;i<k;i++){
            stk = new StringTokenizer(bf.readLine());
            startPos[i][0] = Integer.parseInt(stk.nextToken())-1;
            startPos[i][1] = Integer.parseInt(stk.nextToken())-1;
        }
        max = 0;
        dfs(0, 0);
        System.out.print(max);
    }
    static void dfs(int depth, int cur){
        if(depth == m){
            for(int r : res){
                int [] pos = posList.get(r);
                map[pos[0]][pos[1]] = 0;
            }
            v = new boolean[n][n];
            int sum = 0;
            for(int [] pos : startPos){
                if(v[pos[0]][pos[1]]) continue;
                sum += bfs(pos[0], pos[1]);
            }
            max = Math.max(sum, max);
            for(int r : res){
                int [] pos = posList.get(r);
                map[pos[0]][pos[1]] = 1;
            }
            return;
        }

        for(int i = cur;i<m;i++){
            res[depth] = i;
            dfs(depth+1, i+1);
        }
    }
    static int bfs(int sy, int sx){
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        Queue<int []> queue = new ArrayDeque<>();
        v[sy][sx] = true;
        queue.add(new int[]{sy, sx});
        int c= 1;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(OOB(ny, nx) || v[ny][nx] || map[ny][nx] == 1) continue;
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
    static void printMap(){
        for(int i = 0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}