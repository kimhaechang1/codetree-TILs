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
        
        Arrays.sort(arr);
        int start = 0;
        int cnt = 0;
        for(int end = 1; end < arr.length; end++) {
            start = 0;
            while(start < end) {
                if (arr[start] + arr[end] <= s) {
                    cnt++;
                }
                start++;
            }
        }
        System.out.print(cnt);
    }

}