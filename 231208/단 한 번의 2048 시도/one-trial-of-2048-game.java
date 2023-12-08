import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        for(int i = 0;i<4;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<4;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        String dir = bf.readLine();
        if("L".equals(dir)){
            go(2);
        }else if("R".equals(dir)){
            go(3);
        }else if("U".equals(dir)){
            go(0);
        }else{
            go(1);
        }
        print();
    }
    static void go(int dir){
        boolean [][] isChanged = new boolean[4][4];
        if(dir == 0){
            for(int i = 1;i<4;i++){
                for(int j= 0;j<4;j++){
                    int sy = i;
                    int sx = j;
                    if(map[sy][sx] == 0) continue;
                    while(true){
                        int ny= sy + dy[dir];
                        int nx = sx + dx[dir];
                        if(ny >= 4 || ny < 0 || nx >= 4 || nx < 0){
                            map[sy][sx] = map[i][j];
                            map[i][j] = 0;
                            break;
                        } 
                        if(map[ny][nx] == map[i][j] && !isChanged[ny][nx]){
                            map[ny][nx] = map[i][j] * 2;
                            isChanged[ny][nx] = true;
                            map[i][j] = 0;

                            break;
                        }else if(map[ny][nx] == map[i][j] && isChanged[ny][nx]){
                            map[sy][sx] = map[i][j];
                            if(sy == i && sx == j) break;
                            map[i][j] = 0;
                            break;
                        }else if(map[ny][nx] != map[i][j]){
                            if(map[ny][nx] == 0){
                                sy = ny;
                                sx = nx;
                            }else{
                                map[sy][sx] = map[i][j];
                                if(sy == i && sx == j) break;
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }else if(dir == 1){
            
            for(int i = 2;i>-1;i--){
                for(int j= 0;j<4;j++){
                    int sy = i;
                    int sx = j;
                    if(map[sy][sx] == 0) continue;
                    while(true){
                        int ny= sy + dy[dir];
                        int nx = sx + dx[dir];
                        if(ny >= 4 || ny < 0 || nx >= 4 || nx < 0){
                            map[sy][sx] = map[i][j];
                            map[i][j] = 0;
                            break;
                        } 
                        if(map[ny][nx] == map[i][j] && !isChanged[ny][nx]){
                            map[ny][nx] = map[i][j] * 2;
                            isChanged[ny][nx] = true;
                            map[i][j] = 0;

                            break;
                        }else if(map[ny][nx] == map[i][j] && isChanged[ny][nx]){
                            map[sy][sx] = map[i][j];
                            if(sy == i && sx == j) break;
                            map[i][j] = 0;
                            break;
                        }else if(map[ny][nx] != map[i][j]){
                            if(map[ny][nx] == 0){
                                sy = ny;
                                sx = nx;
                            }else{
                                map[sy][sx] = map[i][j];
                                if(sy == i && sx == j) break;
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }else if(dir == 2){
            
            for(int i = 0;i<4;i++){
                for(int j= 1;j<4;j++){
                    int sy = i;
                    int sx = j;
                    if(map[sy][sx] == 0) continue;
                    while(true){
                        int ny= sy + dy[dir];
                        int nx = sx + dx[dir];
                        if(ny >= 4 || ny < 0 || nx >= 4 || nx < 0){
                            map[sy][sx] = map[i][j];
                            map[i][j] = 0;
                            break;
                        } 
                        if(map[ny][nx] == map[i][j] && !isChanged[ny][nx]){
                            map[ny][nx] = map[i][j] * 2;
                            isChanged[ny][nx] = true;
                            map[i][j] = 0;

                            break;
                        }else if(map[ny][nx] == map[i][j] && isChanged[ny][nx]){
                            map[sy][sx] = map[i][j];
                            if(sy == i && sx == j) break;
                            map[i][j] = 0;
                            break;
                        }else if(map[ny][nx] != map[i][j]){
                            if(map[ny][nx] == 0){
                                sy = ny;
                                sx = nx;
                            }else{
                                map[sy][sx] = map[i][j];
                                if(sy == i && sx == j) break;
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }else{
            
            for(int i = 0;i<4;i++){
                for(int j= 2;j>-1;j--){
                    int sy = i;
                    int sx = j;
                    if(map[sy][sx] == 0) continue;
                    while(true){
                        int ny= sy + dy[dir];
                        int nx = sx + dx[dir];
                        if(ny >= 4 || ny < 0 || nx >= 4 || nx < 0){
                            map[sy][sx] = map[i][j];
                            map[i][j] = 0;
                            break;
                        } 
                        if(map[ny][nx] == map[i][j] && !isChanged[ny][nx]){
                            map[ny][nx] = map[i][j] * 2;
                            isChanged[ny][nx] = true;
                            map[i][j] = 0;

                            break;
                        }else if(map[ny][nx] == map[i][j] && isChanged[ny][nx]){
                            map[sy][sx] = map[i][j];
                            if(sy == i && sx == j) break;
                            map[i][j] = 0;
                            break;
                        }else if(map[ny][nx] != map[i][j]){
                            if(map[ny][nx] == 0){
                                sy = ny;
                                sx = nx;
                            }else{
                                map[sy][sx] = map[i][j];
                                if(sy == i && sx == j) break;
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    static void print(){
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }
}