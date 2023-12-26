import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n,m;
    static StringTokenizer stk;
    static int total;
    static int res;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];        
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                total += map[i][j];
            }
        }
        int t = 0;
        
        while(true){
            t++;
            if(!bfs()) break;
        }
        System.out.print(t+" "+res);
    }
    static boolean bfs(){
        boolean [][] v = new boolean[n][m];
        Queue<int []> fq = new ArrayDeque<>();
        Queue<int []> mq = new ArrayDeque<>();
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        fq.add(new int[]{0,0});
        v[0][0] = true;
        while(!fq.isEmpty()){
            int [] now = fq.poll();
            for(int k = 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(OOB(ny, nx) || v[ny][nx]) continue;
                v[ny][nx] = true;
                if(map[ny][nx] == 0){
                    fq.add(new int[]{ny, nx});
                }else if(map[ny][nx] == 1){
                    mq.add(new int[]{ny, nx});
                }   
            }
        }
        if(total - mq.size() == 0){
            res = mq.size();
            return false;
        }
        total -= mq.size();
        while(!mq.isEmpty()){
            int [] pos = mq.poll();
            map[pos[0]][pos[1]] = 0;
        }
        return true;
    }
    static boolean OOB(int y, int x){
        return y >=n || y < 0 || x >= m || x < 0;
    }
    static void printMap(){
        for(int i = 0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}