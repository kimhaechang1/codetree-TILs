import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int k;
    static int[][] info;
    static StringTokenizer stk;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        info = new int[k][2];
        map = new int[5][5];
        for(int i = 0;i<k;i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken()) - 1;
            info[i][1] = Integer.parseInt(stk.nextToken()) - 1;
            map[info[i][0]][info[i][1]] = 1;
        }
        cnt = 0;
        boolean[][] v = new boolean[5][5];
        v[0][0] = true;
        v[4][4] = true;
        dfs(0, 0, 4, 4, 1, 1, v);
        System.out.print(cnt);
    }
    static void dfs(int y1, int x1, int y2, int x2, int aCnt, int bCnt, boolean[][] v) {

        for(int d1 = 0;d1<4;d1++) {
            int n1y = y1 + dy[d1];
            int n1x = x1 + dx[d1];
            if(OOB(n1y, n1x) || v[n1y][n1x] || map[n1y][n1x] == 1) continue;
            for(int d2 = 0;d2<4;d2++) {
                int n2y = y2 + dy[d2];
                int n2x = x2 + dx[d2];
                if(OOB(n2y, n2x) || v[n2y][n2x] || map[n2y][n2x] == 1) continue;
                if(n1y == n2y && n1x == n2x) {
                    if (isDone(aCnt + 1, bCnt)) {
                        cnt = cnt+1;
                        return;
                    }
                    continue;
                }
                v[n1y][n1x] = true;
                v[n2y][n2x] = true;
                aCnt = aCnt + 1;
                bCnt = bCnt + 1;
                dfs(n1y, n1x, n2y, n2x, aCnt, bCnt, v);
                v[n1y][n1x] = false;
                v[n2y][n2x] = false;
                aCnt = aCnt - 1;
                bCnt = bCnt - 1;
            }
        }
    }

    static boolean isDone(int aCnt, int bCnt) {
        return (25 - k) == (aCnt + bCnt);
    }

    static boolean OOB(int y, int x) {
        return y >= 5 || y < 0 || x >= 5 || x < 0;
    }


}