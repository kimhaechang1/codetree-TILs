import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int [] dy = {0,1};
    static int [] dx = {1,0};
    static StringTokenizer stk;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j]= Integer.parseInt(stk.nextToken());
            }
        }
        // 차를 하나 정해놓고 시작하여서
        // 그 차의 경우에 도달 가능한지 검사한다.
        int s = 0;
        int e = 100;
        int ans = 100;
        while(s <= e){
            int mid = (s + e) /2;
            boolean can = false;
            for(int i= 0;i + mid <= 100;i++){
                int min = i;
                int max = i + mid;
                if(bfs(min, max)){
                    can = true;
                    break;
                }
            }
            if(can){
                e = mid -1;
                ans = Math.min(mid, ans);
            }else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static boolean bfs(int min, int max){
        Queue<int []> queue = new ArrayDeque<>();
        boolean [][] v = new boolean[n][n];
        if(map[0][0] < min || map[0][0] > max) return false;
        v[0][0] = true;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == n-1 && now[1] == n-1){
                return true;
            }
            for(int dir = 0;dir<2;dir++){
                int ny= now[0] + dy[dir];
                int nx = now[1] + dx[dir];
                if(OOB(ny, nx) || v[ny][nx]) continue;
                if(min <= map[ny][nx] && max >= map[ny][nx]){
                    v[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return false;
    }
    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >= n || x <0;
    }
    
}