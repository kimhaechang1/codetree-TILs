import java.util.*;
import java.io.*;

public class Main {
    static class Ball{
        int cy;
        int cx;
        int cd;
        int time;
        public Ball(int cy, int cx, int cd, int time){
            this.cy = cy;
            this.cx = cx;
            this.cd = cd;
            this.time = time;
        }
        public String toString(){
            return "cy : "+cy +" cx : "+cx +" cd : "+cd+" time : "+time;
        }
    }
    static StringTokenizer stk;
    static int n;
    static int sy;
    static int sx;
    static int sd;
    static char [][] map;
    static int []dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static boolean [][][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        stk = new StringTokenizer(bf.readLine());
        sy = Integer.parseInt(stk.nextToken())-1;
        sx = Integer.parseInt(stk.nextToken())-1;
        for(int i = 0;i<n;i++){
            char [] crr = bf.readLine().toCharArray();
            map[i] = crr.clone();
        }
        sd = 3;
        Ball ball = new Ball(sy, sx, sd, 0);
        v = new boolean[n][n][4];
        // 처음엔 항상 동쪽으로 이동
        v[0][0][3] = true;
        while(go(ball)){
            //System.out.println(ball.toString());
        }
        
        if(check(ball)){
            System.out.print(ball.time);
        }else{
            System.out.print(-1);
        }
    }
    static boolean check(Ball ball){
        if(ball.cy >= n || ball.cy < 0 || ball.cx < 0 || ball.cx >= n ) return true;
        return false;
    }
    static boolean go(Ball ball){
        int fchk = floorChk(ball);
        
        if(fchk == -1){    
            int ny = ball.cy + dy[ball.cd];
            int nx = ball.cx + dx[ball.cd];
            if(ny >= n || ny < 0 || nx >= n || nx < 0){
                ball.cy = ny;
                ball.cx = nx;
                ball.time = ball.time+1;
                return false;
            }
            if(map[ny][nx] == '#'){
                int nd = ball.cd;
                if(nd == 3){
                    nd = 0;
                }else if(nd == 0){
                    nd = 2;
                }else if(nd == 2){
                    nd = 1;
                }else{
                    nd = 3;
                }
                while(true){
                    if(ball.cd == nd) return false;
                    ny = ball.cy + dy[nd];
                    nx = ball.cx + dx[nd];
                    if(ny >= n || ny < 0 || nx >= n || nx < 0){
                        ball.cy = ny;
                        ball.cx = nx;
                        ball.cd = nd;
                        ball.time = ball.time+1;
                        return false;
                    }
                    if(!v[ny][nx][nd] && map[ny][nx] == '.'){
                        ball.cy = ny;
                        ball.cx = nx;
                        ball.cd = nd;
                        ball.time = ball.time+1;
                        v[ny][nx][nd] = true;
                        return true;
                    }
                    if(nd == 3){
                        nd = 0;
                    }else if(nd == 0){
                        nd = 2;
                    }else if(nd == 2){
                        nd = 1;
                    }else{
                        nd = 3;
                    }
                }
            }else{
                ball.cy = ny;
                ball.cx = nx;
                ball.time = ball.time+1;
                if(ball.cy >= n || ball.cy < 0 || ball.cx >= n || ball.cx < 0) return false;
                if(v[ny][nx][ball.cd]) return false;
                v[ny][nx][ball.cd] = true;
                return true;
            }
        }else{
            int ny = ball.cy+dy[fchk];
            int nx = ball.cx+dx[fchk];
            ball.cy = ny;
            ball.cx = nx;
            ball.cd = fchk;
            ball.time = ball.time+1;
            if(ball.cy >= n || ball.cy < 0 || ball.cx >=n || ball.cx < 0) return false;
            if(v[ny][nx][fchk]) return false;
            v[ny][nx][fchk] = true;
            return true;
        }
        
    }
    static int floorChk(Ball ball){
        // -1 리턴이면 바닥이 아직 있는것, -1보다 크면 돌려야하는 방향 제공
        if(ball.cd == 3){
            if(map[ball.cy+dy[1]][ball.cx+dx[1]] == '#'){
                return -1;
            }else{
                return 1;
            }
        }else if(ball.cd == 1){
            if(map[ball.cy+dy[2]][ball.cx+dx[2]]=='#'){
                return -1;
            }else{
                return 2;
            }
        }else if(ball.cd == 2){
            if(map[ball.cy+dy[0]][ball.cx+dx[0]]=='#'){
                return -1;
            }else{
                return 0;
            }
        }else{
            if(map[ball.cy+dy[3]][ball.cx+dx[3]]=='#'){
                return -1;
            }else{
                return 3;
            }
        }
    }
}