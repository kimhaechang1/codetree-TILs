import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] map;
    static int[] dy = {0,1};
    static int[] dx = {1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 오른쪽 혹은 아래로만 이동하여 우하 끝점에 도달할동안 최솟값의 최대
        // 최솟값의 최대는 즉, 하한경계를 하나 정하고 도달가능한지 검사

        int s = 0;
        int e = 1_000_000;
        int ans = e;
        while(s <= e){
            int mid = (s + e) / 2;
            if(go(mid)){
                s = mid + 1;
            }else{
                e = mid - 1;
                ans = Math.min(e, ans);
            }
        }
        System.out.println(ans);
    }
    static boolean go(int value){
        Queue<int[]> queue =new ArrayDeque<>();
        if(map[0][0] < value) return false;
        boolean[][] v = new boolean[n][n];
        v[0][0] = true;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == n-1 && now[1] == n-1){
                return true;
            }
            for(int dir = 0;dir<2;dir++){
                int ny = now[0] + dy[dir];
                int nx = now[1] + dx[dir];
                if(OOB(ny, nx) || v[ny][nx] || map[ny][nx] < value) continue;
                v[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return false;
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >=n || x < 0;
    }
}