import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
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
        k = Integer.parseInt(stk.nextToken());
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
        // N개으 ㅣ바구니가 놓여있고 중심점 C를 잡아서 C-K 와 C + K 구간에 사탕수가 최대가 되도록
        // 슬라이딩 윈도우? 크기가 정해져있으니까

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) {
            cnt.put(info[i][1], cnt.getOrDefault(info[i][1], 0) + info[i][0]);
        }
        int[] points = new int[cnt.size()];
        int idx = 0;
        for(int key: cnt.keySet()) points[idx++] = key;
        
        Arrays.sort(points);

        long sum = 0;
        int start = 0;
        int end = 0;
        long ans = 0;
        while(end < points.length) {
            if (points[end] - points[start] <= 2 * k) {
                sum += cnt.get(points[end]);
                ans = Math.max(ans, sum);
                end++;
            } else {
                sum -= cnt.get(points[start]);
                start++;
            }
        }
        System.out.print(ans);
    }

}