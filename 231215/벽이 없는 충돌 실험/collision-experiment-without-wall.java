import java.util.*;
import java.io.*;

public class Main {
    static double [][] state;
    static double [] dy = {0.5,-0.5,0,0};
    static double [] dx = {0,0,-0.5,0.5};
    static StringTokenizer stk;
    static int n;
    static boolean [] isDead;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int t= 1;t<=T;t++){
            n = Integer.parseInt(bf.readLine());
            state = new double[n][5];
            isDead = new boolean[n];
            for(int i =0;i<n;i++){
                stk =new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int w = Integer.parseInt(stk.nextToken());
                int dir = getDir(stk.nextToken());
                state[i][0] = x;
                state[i][1] = y;
                state[i][2] = w;
                state[i][3] = dir;
                state[i][4] = i;
            }
            // 2 초에 한칸씩 이동
            // 무게가 크면 큰쪽이 살아남고
            // 무게가 같은구슬이 여러개라면 구슬의 번호가 가장 큰놈이 살아남음
            // 홀추 초의 시간에는 좌우 위치가 바뀌는 
            int maxT = 0;
            int k = 0;
            while(maxT++ < 2000){
                move();
                if(chk()){
                    k = Math.max(k, maxT);
                }
            }
            System.out.println((k == 0 ? -1 : k));
        }
    }
    static void move(){
        for(int i = 0;i<n;i++){
        	if(isDead[(int)state[i][4]]) continue;
            state[i][0] += dx[(int)state[i][3]];
            state[i][1] += dy[(int)state[i][3]];
        }
    }
    static boolean chk(){
        Arrays.sort(state, (o1, o2)->{
        	if(o1[0] == o2[0]) {
        		if(o1[1] == o2[1]) {
        			if(o1[2] == o2[2]) {
        				return Double.compare(o2[4], o1[4]);
        			}else {
        				return Double.compare(o2[2], o1[2]);
        			}
        		}else {
        			return Double.compare(o1[1], o2[1]);
        		}
        	}
            return Double.compare(o1[0], o2[0]);
        });
        double prevY = -1;
        double prevX = -1;
        boolean flg = false;
        for(int i = 0;i<n;i++) {
        	if(isDead[(int)state[i][4]]) continue;
        	if(prevY == state[i][0] && prevX == state[i][1]) {
        		flg = true;
        		isDead[(int)state[i][4]] = true;
        	}else {
        		prevY = state[i][0];
        		prevX = state[i][1];
        	}
        }
        return flg;
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
}