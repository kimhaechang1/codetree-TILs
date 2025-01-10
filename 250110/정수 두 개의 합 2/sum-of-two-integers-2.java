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
        // s + e의 합인건데, k이하라는 조건이 깨지기 전까지 e를 늘려놓고, 
        // 이게 무슨말인가? e를 고정시켜놓고 s를 늘려도 어짜피 k이하일 수 밖에 없다.
        // 굳이 고정된 e안에서 모든 s의 경우를 확인 할 필요가 없음

        // 그런다음 s를 늘렸을 때, 만약 s + e의 합이 여전히 k이하라면, e - s + 1 만큼 또 더하면됨
        // 그렇게 하다가, 깨지는 순간이 오면 e를 하나 줄이면됨
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
            }
            start++;
        }
        System.out.print(cnt);
    }

}