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
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // 두 원소를 골라 그 합이 k 이하
        // 두 포인터에 대해서 양쪽 끝에서 시작하는가, 아니면 양쪽이 같은지점에서 출발하는가 둘 중 하나다.
        // 만약 둘다 한쪽 끝에서 출발한다면, 
        Arrays.sort(arr);
        int start = 0;
        int cnt = 0;
        int end = 1;
        while(start < end) {
            while(end < n && arr[start] + arr[end] <= s) {
                end++;
            }

            if (end == n || arr[start] + arr[end] > s) end--;
            if (arr[start] + arr[end] <= s) {
                cnt += (end - start);
                start++;
            }
        }
        System.out.print(cnt);
    }

}