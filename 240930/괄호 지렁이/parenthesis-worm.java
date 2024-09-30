import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static char[][] map;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map =new char[n][n];
        for(int i =0;i<n;i++){ 
            String maps = bf.readLine();
            for(int j = 0;j<n;j++) {
                map[i][j] = maps.charAt(j);
            }
        }
        boolean[][] v = new boolean[n][n];
        v[0][0] = true;
        ArrayList<Character> list = new ArrayList<>();
        list.add(map[0][0]);
        max = 0;
        dfs(0, 0, list, v);
        System.out.print(max);
    }
    static void dfs(int y, int x, ArrayList<Character> set, boolean[][] v) {
        int sz = set.size();
        for(int dir = 0;dir<4;dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (OOB(ny, nx)) continue;
            if (v[ny][nx]) continue;
            if (set.get(sz - 1) == ')' && map[ny][nx] != ')' ) continue;
            set.add(map[ny][nx]);
            v[ny][nx] = true;
            dfs(ny, nx, set, v);
            v[ny][nx] = false;
            set.remove(set.size() - 1);
        } 
        if (check(set)) {
            max= Math.max(max, set.size());
        }
    }
    static boolean OOB(int y, int x) {
        return y>= n || y < 0 || x>=n || x < 0;
    }
    static boolean check(ArrayList<Character> chs) {
        int oCnt = 0;
        int cCnt = 0;
        for(int i = 0;i< chs.size();i++) {
            if (chs.get(i) == '(') oCnt++;
            else cCnt++;
        }
        if(oCnt != cCnt) return false;
        int idx = 0;
        for(;idx<oCnt;idx++) {
            if(chs.get(idx) == ')') return false;
        }
        for(;idx<chs.size();idx++) {
            if(chs.get(idx) == '(') return false;
        }
        return true;
    }
}