import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int a, b;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        bf = new BufferedReader(new InputStreamReader(System.in));
        input();
        solve();
    }
    static void input() throws Exception {
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        a = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }
    static void solve() {
        int min = 987654321;

        int s = 0;
        int e = 0;

        long sum = 0;
        boolean can = false;
        while(s <= e && e < arr.length) {

            sum += arr[e];

            if (sum >= a) {
                while(sum >= a && s <= e) {
                    can = true;
                    min = Math.min(min, e - s + 1);
                    sum -= arr[s];
                    s++;
                }
            }
            e++;
        }
        System.out.print(can ? min : -1);
    }

    static boolean OOB(int y, int x) {
        return y >= n || y < 0 || x >= n || x < 0;
    }

}