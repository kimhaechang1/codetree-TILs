import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int Q;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        while(Q-- > 0){
            stk = new StringTokenizer(bf.readLine());
            // 해당하는 행 해당하는 방향으로 밀기
            int y = Integer.parseInt(stk.nextToken())-1;
            String dir = stk.nextToken();
            int temp;
            if("R".equals(dir)){
                temp = map[y][0];
                for(int i = 0;i<M-1;i++){
                    map[y][i] = map[y][i+1];
                }
                map[y][M-1] = temp;
            }else{
                temp = map[y][M-1];
                for(int i = M-1;i>0;i--){
                    map[y][i] = map[y][i-1];
                }
                map[y][0] = temp-1;
            }   
            // 위로 전파 하기
            up(y, dir);
            // 아래로 전파하기
            down(y, dir);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void up(int sy, String dir){
        boolean flg = false;
        if(sy-1 == -1) return;
        for(int i = 0;i<M;i++){
            if(map[sy][i] == map[sy-1][i]) {
                flg = true;
                break;
            }
        }
        if(flg){
            int temp;
            if("L".equals(dir)){
                // 바뀌었던 줄이 L로 밀렸다면 R로 밀기
                temp = map[sy-1][0];
                for(int i = 0;i<M-1;i++){
                    map[sy-1][i] = map[sy-1][i+1];
                }
                map[sy-1][M-1] = temp;
                up(sy-1, "R");
            }else{
               // 바뀌었던 줄이 R로 밀렸다면 L로 밀기 
               temp = map[sy-1][M-1];
                for(int i = M-1;i>0;i--){
                    map[sy-1][i] = map[sy-1][i-1];
                }
                map[sy-1][0] = temp;
                up(sy-1, "L");
            }
        }
    }


    static void down(int sy, String dir){
        boolean flg = false;
        if(sy+1 == N) return;
        for(int i = 0;i<M;i++){
            if(map[sy][i] == map[sy+1][i]) {
                flg = true;
                break;
            }
        }
        if(flg){
            int temp;
            if("L".equals(dir)){
                // 바뀌었던 줄이 L로 밀렸다면 R로 밀기
                temp = map[sy+1][0];
                for(int i = 0;i<M-1;i++){
                    map[sy+1][i] = map[sy+1][i+1];
                }
                map[sy+1][M-1] = temp;
                down(sy+1, "R");
            }else{
               // 바뀌었던 줄이 R로 밀렸다면 L로 밀기 
               temp = map[sy+1][M-1];
                for(int i = M-1;i>0;i--){
                    map[sy+1][i] = map[sy+1][i-1];
                }
                map[sy+1][0] = temp;
                down(sy+1, "L");
            }
        }
    }
}