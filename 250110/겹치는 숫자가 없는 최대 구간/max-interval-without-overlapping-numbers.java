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
        n = Integer.parseInt(bf.readLine());
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
        // 중복된 숫자가 없는 연속된 최장 길이
        
        // 연속된 구간을 찾는것은 투포인터, 누적합 등으로 해결가능
        // 투포인터로 cnt 배열을 채워나가다가, 깨지는 순간 ? start포인터를 올린다.
        int[] cnt = new int[100_001];
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < n) {
            cnt[arr[end]]++;
            if (cnt[arr[end]] == 1) {
                ans = Math.max(ans, end - start + 1);
            } else if (cnt[arr[end]] >= 2) {
                cnt[arr[start]]--;
                start++;
            }
            end++;
        }

        System.out.print(ans);
    }

}