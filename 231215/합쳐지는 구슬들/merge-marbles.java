import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int n;
    static int m;
    static int t;
    static int [][] state;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static boolean [] isDead;
    static ArrayList<Integer>[][] present;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        state = new int[m][5];
        map = new int[n][n];
        present = new ArrayList[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                present[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0;i<m;i++){
            // y, x, d, w, idx
            stk = new StringTokenizer(bf.readLine());
            state[i][0] = Integer.parseInt(stk.nextToken())-1;
            state[i][1] = Integer.parseInt(stk.nextToken())-1;
            state[i][2] = getDir(stk.nextToken());
            state[i][3] = Integer.parseInt(stk.nextToken());
            state[i][4] = i;
        }
        isDead =new boolean[m];
        while(t-- > 0){
            clear();
            move();
            check();
        }
        int cnt = 0;
        for(boolean d : isDead) cnt += !d ? 1 : 0;
        System.out.print(cnt);
        System.out.print(" ");
        int maxW = 0;
        for(int i = 0;i<m;i++){
            if(isDead[i]) continue;
            maxW = Math.max(maxW, state[i][3]);
        }
        System.out.print(maxW);
    }
    static void clear(){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                present[i][j].clear();
            }
        }
    }
    static void move(){
        for(int i = 0;i<m;i++){
            if(isDead[i]) continue;
            int ny = state[i][0] + dy[state[i][2]];
            int nx = state[i][1] + dx[state[i][2]];
            if(ny >= n || ny < 0 || nx >= n || nx < 0){
                state[i][2] = reverseDir(state[i][2]);
                ny = state[i][0];
                nx = state[i][1];
            }
            state[i][0] = ny;
            state[i][1] = nx;
            present[ny][nx].add(i);
        }
    }
    static void check(){
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(present[i][j].size() < 2) continue;
                int messSum = 0;
                for(int k = 0;k<present[i][j].size();k++){
                    messSum += state[present[i][j].get(k)][3];
                }
                Collections.sort(present[i][j], Collections.reverseOrder());
                int king = present[i][j].get(0);
                for(int k = 1;k<present[i][j].size();k++){
                    isDead[present[i][j].get(k)] = true;
                }
                state[king][3] = messSum;
            }
        }
    }
    static int getDir(String dir){
        switch(dir){
            case "U":
                return 0;
            case "D":
                return 1;
            case "L":
                return 2;
            default :
                return 3;
        }
    }
    static int reverseDir(int dir){
        switch(dir){
            case 1 :
                return 0;
            case 0 : 
                return 1;
            case 2 : 
                return 3;
            default : 
                return 2;
        }
    }
}