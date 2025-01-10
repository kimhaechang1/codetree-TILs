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
        // 연속하는 원소의 합이 m이되는 경우의 수

        // 어짜피 음수가 없기 때문에 우측으로 갈수록 더욱 커진다.
        // 오버플로 주의
        long sum = 0;
        int start = 0;
        int end = 0;
        int cnt = 0;
        while(end < n) {
            sum += (arr[end]);
            while(sum - arr[start] >= s && start < end) {
                sum -= arr[start];
                start++;
            }
            if (sum == s) {
                cnt++;
            }
            end++;
        }
        System.out.print(cnt);
        
    }

}