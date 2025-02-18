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
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(stk.nextToken());
    }

    void solve() {

        // 크기가 N인 수열에서, 같은 원소가 K개 이하로 들어있는 가장 긴 연속 부분 수열의 길이를 구하는 프로그램
        // 연속 부분 수열이기 때문에 투포인터 접근이 가능하다.

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int s = 0;
        int e = 0;
        int ans = 0;
        while(e < arr.length) {
            countMap.put(arr[e], countMap.getOrDefault(arr[e], 0) + 1);
            while(countMap.get(arr[e]) > k && s < e) {
                if (countMap.get(arr[s]) - 1 == 0) {
                    countMap.remove(arr[s]);
                } else {
                    countMap.put(arr[s], countMap.get(arr[s]) - 1);
                }
                s++;
            }
            ans = Math.max(ans, e - s + 1);
            e++;
        }
        System.out.println(ans);
    }
}