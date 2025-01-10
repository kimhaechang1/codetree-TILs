import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int s;
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
        s = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

    }

    int TC() {
       return 0;
    }

    void solve() {
        // 연속적인 구간, 구간합 
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end < n) {
            sum += arr[end];
            while(sum - arr[start] >= s && start < end) {
                sum -= arr[start];
                start++;
            }
            if (sum >= s) {
                ans = Math.min(end - start + 1, ans);
            }
            end++;
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

}