import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int m;
    static int k;
    static int [][] map;
    static ArrayDeque<int []> deque = new ArrayDeque<>();
    static int time = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for(int i = 0;i<m;i++){
            stk =new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(stk.nextToken())-1;
            int x = Integer.parseInt(stk.nextToken())-1;
            map[y][x] = 2;
        }
        map[0][0] = 1;
        deque.addLast(new int[]{0,0});
        String [] command = new String[k];
        for(int i = 0;i<k;i++){
            command[i] = bf.readLine();
        }
        
        for(int i = 0;i<k;i++){
            stk = new StringTokenizer(command[i]);
            String d = stk.nextToken();
            int p = Integer.parseInt(stk.nextToken());
            int dir;
            if("U".equals(d)){
                dir = 0;
            }else if("D".equals(d)){
                dir = 1;
            }else if("L".equals(d)){
                dir = 2;
            }else{
                dir = 3;
            }
            if(!go(dir, p)){
                break;
            }
        }
        /*
        0 0 0
        0 0 0
        0 0 1

        1 0
        0 0
        */
        System.out.println(time);
    }
    static boolean go(int d, int p){
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        while(p-- > 0){
            time++;
            int [] data = deque.peekFirst();
            int ny = data[0] + dy[d];
            int nx = data[1] + dx[d];
            if(ny >= n|| ny < 0 || nx >= n || nx < 0) return false;
            if(map[ny][nx] == 2){
                map[ny][nx] = 1;
                deque.addFirst(new int[]{ny, nx});
            }else{
                int [] tail = deque.pollLast();
                map[tail[0]][tail[1]] = 0;
                if(map[ny][nx] == 1) return false;
                map[ny][nx] = 1;
                deque.addFirst(new int[]{ny, nx});
            }
            
        }
        return true;
    }
}