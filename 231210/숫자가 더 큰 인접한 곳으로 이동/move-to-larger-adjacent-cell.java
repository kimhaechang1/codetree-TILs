import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int [][] map;
    static int sy;
    static int sx;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        sy = Integer.parseInt(stk.nextToken())-1;
        sx = Integer.parseInt(stk.nextToken())-1;
        map = new int[n][n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int cy = sy;
        int cx = sx;
        list.add(map[cy][cx]);
        while(true){
            boolean canGo = false;
            for(int k = 0;k<4;k++){
                int ny = cy + dy[k];
                int nx = cx + dx[k];
                if(ny >= n || ny < 0 || nx >= n || nx < 0 || map[ny][nx] <= map[cy][cx]) continue;
                canGo = true;
                cy=ny;
                cx=nx;
                list.add(map[cy][cx]);
                break;
            }
            if(!canGo) break;
        }
        StringBuilder sb =new StringBuilder();
        for(int a : list) sb.append(a).append(" ");
        System.out.print(sb);       
    }
}