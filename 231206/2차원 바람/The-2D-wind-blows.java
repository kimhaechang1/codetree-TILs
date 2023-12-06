import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int Q;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N= Integer.parseInt(stk.nextToken());
        M= Integer.parseInt(stk.nextToken());
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
            // 직사각형 외곽 돌리기
            int y1 = Integer.parseInt(stk.nextToken())-1;
            int x1 = Integer.parseInt(stk.nextToken())-1;
            int y2 = Integer.parseInt(stk.nextToken())-1;
            int x2 = Integer.parseInt(stk.nextToken())-1;
            rotate(y1, x1, y2, x2);
            // 카피 뜨기

            int [][] cp = copy();
            // 평균값으로 바꾸기 
            convert(y1, x1, y2, x2, cp); 

        }
        StringBuilder sb =new StringBuilder();
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
             
    

        
    }
    static void rotate(int y1, int x1, int y2, int x2){
        // y1, x1 temp 로 빼놓기 -> 나중에 y1,x1+1위치로 옮길 예정
        int temp = map[y1][x1];
        // 왼쪽 변
        for(int i = y1; i< y2;i++){
            map[i][x1] = map[i+1][x1];
        }

        // 아랫변
        for(int i = x1;i<x2;i++){
            map[y2][i] = map[y2][i+1];
        }
        // 오른쪽 변
        for(int i = y2;i>y1-1;i--){
            map[i][x2] = map[i-1][x2];
        }
        // 윗변 
        for(int i = x2;i>x1+1;i--){
            map[y1][i] = map[y1][i-1];
        }
        map[y1][x1+1] = temp;
    }
    static int [][] copy(){
        int [][] cp = new int[N][M];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                cp[i][j] = map[i][j];
            }
        }
        return cp;
    }
    static void convert(int y1, int x1, int y2, int x2, int [][] copy){
        int [] dy= {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        for(int i = y1;i<=y2;i++){
            for(int j = x1;j<=x2;j++){
                int sum = map[i][j];
                int c = 1;
                for(int k = 0;k<4;k++){
                    int ny = i+ dy[k];
                    int nx = j + dx[k];
                    if(ny >= N || ny < 0 || nx >= M ||nx < 0 ) continue;
                    c++;
                    sum += copy[ny][nx];
                }   
                map[i][j] = sum/c;
            }
        }
    }
}