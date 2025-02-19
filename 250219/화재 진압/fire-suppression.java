import java.util.*;
import java.io.*;


public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int n, m;
    static int[] arr1;
    static int[] arr2;
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
        arr1 = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) arr1[i] = Integer.parseInt(stk.nextToken());
        arr2 = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++) arr2[i] = Integer.parseInt(stk.nextToken());
    }

    void solve() {

        // 1차 수직선 상 위에 화재가 발생할 가능성이 있는 서로 다른 N개의 위치와 소방서 M개의 위치가 주어진다.
        // 화재는 정확히 1곳에서만 발생하며 가장 근처에 있는 소방서에서 출동하여 진입한다.
        // 거리 1을 이동하는 데 시간이 1초 소요되는데, 가장 오래걸리는 시간을 구하는 프로그램

        // -1 0 2 4 6
        TreeSet<Integer> mSet = new TreeSet<>();
        for(int pos: arr2) mSet.add(pos);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            Integer lower = mSet.ceiling(arr1[i]);
            Integer upper = mSet.floor(arr1[i]);
            int ld = lower == null ? Integer.MIN_VALUE : Math.abs(lower - arr1[i]);
            int ud = upper == null ? Integer.MIN_VALUE : Math.abs(upper - arr1[i]);
            ans = Math.max(ans, Math.max(ld, ud));
        }
        System.out.println(ans);

    }
}