import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int cnt;
    static ArrayList<Integer> list;
    static boolean [][] v;
    static int n;
    static StringTokenizer stk;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int c;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        list = new ArrayList<>();
        cnt = 0;
        v = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(v[i][j]) continue;
                if(map[i][j] == 0) continue;
                v[i][j]= true;
                cnt++;
                c = 1;
                dfs(i,j);
                list.add(c);
            }
        }
        

        StringBuilder sb= new StringBuilder();
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for(int a : list) sb.append(a).append("\n");
        System.out.print(sb);
        
    }
    static void dfs(int y, int x){
        for(int k = 0;k<4;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny >= n || ny < 0 || nx >= n || nx < 0 || v[ny][nx] || map[ny][nx] == 0) continue;
            c++;
            v[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}