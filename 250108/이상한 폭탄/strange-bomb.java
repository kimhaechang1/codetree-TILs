import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
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
        // N개의 이상한 폭탄
        // 각 폭탄별로 번호가 있고, 같은 번호가 부착된 폭탄끼리 거리가 K안에 있다면 폭발
        // 그렇다는 것은 특정 인덱스내에 같은 번호가 등장하는지 체크해야 한다.
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = -1;
        for(int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int idx = map.get(arr[i]);
                if (i - idx <= k) {
                    answer = Math.max(answer, arr[i]);
                    map.remove(arr[i]);
                }
            }
            map.put(arr[i], i);
        }
        System.out.print(answer);
    }

}