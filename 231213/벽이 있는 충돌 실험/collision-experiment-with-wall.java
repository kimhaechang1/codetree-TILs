import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n;
    static int m;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static Queue<int []> queue;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            map = new int[n][n];
            queue = new ArrayDeque<>();
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
                queue.add(new int[]{y, x, d});
            }
            int time = n*2 - 2;
            while(time-- > 0){
                int [][] ncount = new int[n][n];
                int [][] dirs = new int[n][n];
                int size=queue.size();
                for(int i= 0;i<size;i++){
                    int [] now = queue.poll();
                    int ny = now[0] + dy[now[2]];
                    int nx = now[1] + dx[now[2]];
                    if(ny >= n || ny < 0 || nx >= n || nx < 0){
                        if(now[2] == 0){
                            now[2] = 1;
                        }else if(now[2] == 1){
                            now[2] = 0;
                        }else if(now[2] == 2){
                            now[2] = 3;
                        }else{
                            now[2] = 2;
                        }
                        ny = now[0] + dy[now[2]];
                        nx = now[1] + dx[now[2]];
                        //System.out.println("ny : "+nx +" ny : "+ny+" now[2] :" + now[2]);
                    }
                    dirs[ny][nx] = now[2];
                    ncount[ny][nx]++;
                }
                
                for(int i = 0;i<n;i++){
                    for(int j= 0;j<n;j++){
                        if(ncount[i][j] > 1){
                            m -= ncount[i][j];
                        }else if(ncount[i][j] == 1){
                            queue.add(new int[]{i, j ,dirs[i][j]});
                        }
                    }
                }
            }
            sb.append(m).append("\n");
        }
        System.out.print(sb);
        
    }
}