import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static StringTokenizer stk;
    static int [] dy = {-1,1,0,0,-1,1,-1,1};
    static int [] dx = {0,0,-1,1,-1,1,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        int cnt = 0;
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1) cnt++;
            } 
        }
        // 마름모의 정의는 어떤 점으로부터 거리가 K이하인 모든 정점
        // 이때 거리를 구하는 방법은 두 정점의 각 좌표의 차이의 합
        // 채굴에 드는 비용은 K * K + (K+1) * (K+1)
        // 하나의 칸에는 최대 하나의 금만 존재하며, 손해를 보지 않으면서 채굴할 수 있는 가장 많은 금의 개수
        // 금 하나의 가격은 m
        int K = 0;
        // k의 최대값 구하기
        while(K * K + (K+1)*(K+1) <= (cnt * m)) K++;
        int max = 0;
        for(int k = 0;k<K;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    int c = map[i][j];
                    for(int y= 0; y < n;y++){
                        for(int x = 0;x<n;x++){
                            if(y == i && x == j) continue;
                            int dis = Math.abs(i-y) + Math.abs(j - x);
                            if(dis <= k && map[y][x] == 1) c++;
                        }
                    }
                    if( (c * m) - ((k*k)+(k+1)*(k+1)) >= 0){
                        max = Math.max(max, c);
                    } 
                }
            }
        }
        System.out.print(max);

    }
}