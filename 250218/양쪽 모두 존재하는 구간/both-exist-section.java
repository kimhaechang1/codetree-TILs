import java.util.*;
import java.io.*;


public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int n, m;
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
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(stk.nextToken());
    }

    void solve() {

        // N개의 숫자가 주어지고, 특정 구간을 잡았을 때 구간 안에도 1이상 M이하의 숫자가 전부 적어도 하나씩 존재하고
        // 구간 밖에서도 1 이상 M이하의 숫자가 전부 적어도 하나씩 존재하는 경우 중 짧은 구간의 길이를 구하시오

        // M은 길이와 동일하며 주어지는 숫자도 M까지만 존재한다.
        // 즉 길이가 곧 원소의 최대값이다.
        // 적어도 하나씩이라는 것은 존재하기만 하면 된단것으로 없으면 안되지만 몇개가 있든 상관없다.

        // 연속된 구간이니까 투포인터를 접근해볼 수 있고, 양쪽 끝에서 시작하는 투포인터를 고려해볼 수 있다.

        // 한쪽만 먼저 좀 줄이고, 다른반대쪽을 줄이고 하면 되지않을까?

        int[] count = new int[m + 1];
        for(int i =  0; i < n; i++) {
            count[arr[i]]++;
        }
        for(int i = 1; i <= m; i++) {
            if (count[i] < 2) {
                System.out.println(-1);
                return;
            }
        }
        int s = 0;
        int e = n - 1;
        int[] count2 = new int[m + 1];
        while(e > s) {
            if (count[arr[e]] == 1) {
                break;
            }
            count[arr[e]]--;
            count2[arr[e]]++;
            e--;
        }

        while(s < e) {
            if (count[arr[s]] == 1) {
                break;
            }
            count[arr[s]]--;
            count2[arr[s]]++;
            s++;
        }
        for(int i = 1; i<= m; i++) {
            if (count2[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(e - s + 1);
    }
}