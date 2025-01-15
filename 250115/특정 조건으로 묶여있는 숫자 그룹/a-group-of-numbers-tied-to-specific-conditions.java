import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] arr;
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
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // n 개의 숫자들을 2 그룹으로 묶는다.
        //  각 그룹내의 숫자들끼리는 차가 k를 넘지 않아야 한다.
        // 한 숫자는 최대 한 개의 그룹에만 속할 수 있고, 어느 그룹에도 속하지 않는 숫자가 있을 수 있다.

        // 정확하게 겹치지않는 구간으로 나눌려면
        // 특정 0 ~ i번째까지의 그룹과 i ~ n 까지의 만들 수 있는 최대 원소 그룹을 기록하면 된다.
        // 이는 곧 LR 테크닉에 해당된다.

        Arrays.sort(arr);

        int[] origin = new int[n + 1];
        for(int i = 1; i < n + 1; i++) origin[i] = arr[i - 1];

        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        
        int s = 1;
        int e = 1;
        int mx = 0;
        int ans = 0;
        while(e < n + 1) {
            
            while(s < e && origin[e] - origin[s] > k) {
                // 만약 최대 최소차가 k 보다 이미 크다면 최소를 높여야 한다.
                s++;
            }
            mx = Math.max(mx, e - s + 1);
            L[e] = mx;
            e++;
        } 

        e = n;
        s = n;
        mx = 0;
        while(e > 0) {
            
            while(s > e && origin[s] - origin[e] > k) {
                // 만약 최대 최소차가 k 보다 이미 크다면 최소를 높여야 한다.
                s--;
            }
            mx = Math.max(mx, s - e + 1);
            R[e] = mx;
            e--;
        } 

        // 원소가 하나일때는 ? 
        ans = L[1];
        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, L[i] + R[i + 1]);
        }
        System.out.print(ans);
    }

}