import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] brr;
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
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        brr = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // 차례대로 존재하기만 하면됨, 여기서 주의할 점은 연속적일 필요는 없음
        // 각각의 포인터를 배열마다 두고 만들 수 arr로 brr을 만들 수 있는지 여부를 검사하면 됨
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < n && idx2 < m) {
            if (arr[idx1] == brr[idx2]) {
                idx2++;
            }
            idx1++;
        }

        System.out.println(idx2 == m ? "Yes" : "No");
    }

}