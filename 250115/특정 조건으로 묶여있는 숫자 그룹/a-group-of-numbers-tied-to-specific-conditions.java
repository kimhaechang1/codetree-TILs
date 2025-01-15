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

        Arrays.sort(arr);
        int ans = 0;
        int s1 = 0;
        int e1 = 1;
        int mxLen1 = 1;
        PriorityQueue<Integer> answerPQ = new PriorityQueue<>(Collections.reverseOrder());
        while(e1 < n) {
            while(s1 < e1) {

                // 만약 해당 그룹내에 최대값이 현재 e를 받아들일 수 없다면?
                if (Math.abs(arr[s1] - arr[e1]) > k || Math.abs(arr[e1 - 1] - arr[e1]) > k) {
                    s1++;
                }  
                
                // 최솟값이 k를 넘어갈 수 없다면 최솟값을 줄이는 방법도 있음
                if (Math.abs(arr[s1] - arr[e1]) <= k && Math.abs(arr[e1 - 1] - arr[e1]) <= k) {
                    mxLen1 = Math.max(e1 - s1 + 1, mxLen1);
                    break;
                }
            }
            answerPQ.add(mxLen1);
            mxLen1 = 0;
            e1++;
        }
        System.out.print(answerPQ.poll() + answerPQ.poll());

    }

}