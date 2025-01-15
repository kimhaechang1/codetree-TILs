import java.util.*;
import java.io.*;

public class Main {

    static int n, d;
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
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
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
        // n 개의 점이 있다.
        // x 좌표가 특정 범위안에 있는 점들 중 y좌표의 값이 가장 작은점과 가장 큰 점의 y좌표 차가 D이 상이 되도록
        // 이것이 가능하도록 하는 x좌표의 범위가 A <= x <= B라고 했을 때, B - A 가 최소가 되게 만드는 프로그램

        // 다른말로 해서 특정 x범위의 좌표들 중 y 최대 최소의 차가 D이상인 범위중에서 x 범위가 가장 작은 프로그램

        Arrays.sort(info, (a, b) -> {
            return a[0] - b[0];
        });

        int s = 0;
        int e = 0;

        int ans = Integer.MAX_VALUE;

        TreeMap<Integer, Integer> yPosMap = new TreeMap<>();
        while(e < n) {
            yPosMap.put(info[e][1], yPosMap.getOrDefault(info[e][1], 0) + 1);
            boolean isFind = false;
            while(s < e) {
                Map.Entry<Integer, Integer> minEntry = yPosMap.firstEntry();
                Map.Entry<Integer, Integer> maxEntry = yPosMap.lastEntry();
                
                int minY = minEntry.getKey();
                int maxY = maxEntry.getKey();
                
                if (Math.abs(minY - maxY) >= d) {
                    ans = Math.min(info[e][0] - info[s][0], ans);
                    isFind = true;
                    int startCnt = yPosMap.get(info[s][1]);
                    if (startCnt - 1 > 0) {
                        yPosMap.put(info[s][1], startCnt - 1);
                    } else {
                        yPosMap.remove(info[s][1]);
                    }
                    s++;
                } else {
                    break;
                }
            }
            if (isFind) {
                if (s - 1 > -1) s--;
                yPosMap.put(info[s][1], yPosMap.getOrDefault(info[s][1], 0) + 1);
            }
            e++;
        }
        // 3, 5, 4
        // 10 10 10
        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
        

    }

}