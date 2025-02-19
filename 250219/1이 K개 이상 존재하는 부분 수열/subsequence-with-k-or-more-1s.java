import java.util.*;
import java.io.*;


public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int n, k;
    static int[] arr;
    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();

    }

    void input() throws Exception {

        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i ++)
            arr[i] = Integer.parseInt(stk.nextToken());
    }

    void solve() {
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        int s = 0;
        for(int e = 0; e < n; e++) {
            cnt += (arr[e] == 2 ? 0 : 1);
            while(s < e) {
                if (arr[s] == 1 && cnt - 1 < k) {
                    break;
                }
                cnt -= (arr[s] == 2 ? 0 : 1);
                s++;
            }
            if (cnt >= k) {
                ans = Math.min(ans, e - s + 1);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }
}