import java.util.*;
import java.io.*;

public class Main {
    static int [][][] map;
    static int n;
    static int m;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            map = new int[n][n][2];
            for(int i = 0;i<m;i++){
                stk = new StringTokenizer(bf.readLine());
                int y = Integer.parseInt(stk.nextToken())-1;
                int x = Integer.parseInt(stk.nextToken())-1;
                int d;
                String dir = stk.nextToken();
                if("U".equals(dir)){
                    d = 0;
                }else if("D".equals(dir)){
                    d = 1;
                }else if("L".equals(dir)){
                    d = 2;
                }else{
                    d = 3;
                }
                map[y][x][0] = 1;
                map[y][x][1] = d;
            }
            int time = n*2;
            while(time-- > 0){
                int [][][] ncount = new int[n][n][2];
                for(int i= 0;i<n;i++){
                    for(int j = 0;j<n;j++){
                       if(map[i][j][0] == 0) continue;
                        int ny = i + dy[map[i][j][1]];
                        int nx = j + dx[map[i][j][1]];
                        if(ny >= n || ny < 0 || nx >= n || nx < 0){
                            if(map[i][j][1] == 0){
                                map[i][j][1] = 1;
                            }else if(map[i][j][1] == 1){
                                map[i][j][1] = 0;
                            }else if(map[i][j][1] == 2){
                                map[i][j][1] = 3;
                            }else{
                                map[i][j][1] = 2;
                            }
                            ny = i;
                            nx = j;
                        }
                        ncount[ny][nx][0]++;
                        ncount[ny][nx][1] = map[i][j][1];
                    }
                }
                for(int i = 0;i<n;i++){
                    for(int j = 0;j<n;j++){
                        if(ncount[i][j][0] > 1){
                            m -= ncount[i][j][0];
                        }else if(ncount[i][j][0] == 1){
                            map[i][j][0] = ncount[i][j][0];
                            map[i][j][1] = ncount[i][j][1];
                        }else{
                            map[i][j][0] = 0;
                            map[i][j][1] = 0;
                        }
                    }
                }
            }
            sb.append(m).append("\n");
        }
        System.out.print(sb);
    }
}