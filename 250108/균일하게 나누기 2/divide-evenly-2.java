import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] info;
    static BufferedReader bf;
    static StringTokenizer stk;

    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();
    }

    void testCase() throws Exception {

    }

    void input() throws Exception {

        n = Integer.parseInt(bf.readLine());
        info = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken());
            info[i][1] = Integer.parseInt(stk.nextToken());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        boolean[] isPointedX = new boolean[1001];
        boolean[] isPointedY = new boolean[1001];
        int[][] coordi = new int[1001][1001];
        int[][] S = new int[1024][1024];
        for(int i = 0; i < n; i++) {
            int x = info[i][0];
            int y = info[i][1];
            coordi[y][x] = 1;
            isPointedX[x] = true;
            isPointedY[y] = true;
        }
        /*for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 13; j++) {
                System.out.print(coordi[i][j]+" ");
            }
            System.out.println();
        }*/

        for(int i = 1; i < 1001; i++) {
            for(int j = 1;j < 1001; j++) {
                S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + coordi[i][j];
            }
        }
        /*System.out.println("##################");
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 13; j++) {
                System.out.print(S[i][j]+" ");
            }
            System.out.println();
        }*/

        // 2차원 평면 누적합인데
        // 2중 for문을 돌면서 각 사분면의 누적합을 구하고 그러한 최대이자 최소를 구해야함\
        int ans = Integer.MAX_VALUE;
        // System.out.println(S[1][1000]);
        for(int i = 1; i < 1001; i++) {
            for(int j = 1; j < 1001; j++) {
                if (isPointedY[i] || isPointedX[i]) continue;
                int max = 0;
                //System.out.println("y: "+i +" x: "+j);
                //System.out.println("1: "+S[i][j]);
                max = Math.max(max, S[i][j]);
                //System.out.println("2: "+(S[i][1000] - S[i][j]));
                max = Math.max(max, S[i][1000] - S[i][j]);
                //System.out.println("3: "+(S[1000][j] - S[i][j]));
                max = Math.max(max, S[1000][j] - S[i][j]);
                //System.out.println("4: "+(S[1000][1000] - (S[i][1000] + S[1000][j]) + S[i][j]));
                max = Math.max(max, S[1000][1000] - (S[i][1000] + S[1000][j]) + S[i][j]);
                //System.out.println("##########################");
                if (max == 0) continue;
                ans = Math.min(ans, max);
            }
        }

        System.out.print(ans);

    }

}