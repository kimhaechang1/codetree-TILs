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
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // 연속하게 고른 숫자들의 합이 7의 배수가 되게 그룹으로 묶어야 함
        // 이렇게 만든 그룹중에서 최대 크기를 구하시오
        
        // 어짜피 연속되는 합이면서, 음수가 없기 때문에 무조건 오른쪽으로 더할수록 계속 증가한다.
        // 특정 i번째 까지의 누적 합에 대한 나머지를 저장해두고, 만약
        HashMap<Long, Integer> map = new HashMap<>();
        long answer = 0;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            long m = sum % 7;
            if (m == 0) {
                answer = Math.max(answer, i + 1);
            } else if (map.containsKey(m)) {
                answer = Math.max(answer, i - map.get(m));
            } else {
                map.put(m, i);
            }
        }
        System.out.print(answer);
    }

}