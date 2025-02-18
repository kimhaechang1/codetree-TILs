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

        // 다시 생각해보자. 처음엔 모든 숫자가 아웃구간일 것이다.
        // 그리고나서 투포인터로 점점 인 구간의 숫자종류를 늘려갈 것이고, 그러한 서로다른 숫자가 m개가 된다면 그때부터 줄여볼 수 있을 것이다.

        int[] countIn = new int[m + 1];
        int[] countOut = new int[m + 1];
        int distinctIn = 0;
        int distinctOut = 0;
        for(int elem: arr) {
            countOut[elem]++;
            if (countOut[elem] == 1) distinctOut++;
        }

        int e = 0;
        int ans = Integer.MAX_VALUE;
        for(int s = 0; s < n; s++) {
            // 처음엔 0, 0에서부터
            while(e < n && distinctIn < m) {
                // e를 점점 늘리면서 in 구간의 원소 잡기
                countIn[arr[e]]++;
                if (countIn[arr[e]] == 1) {
                    distinctIn++;
                }
                countOut[arr[e]]--;
                if (countOut[arr[e]] == 0) {
                    distinctOut--;
                }
                e++;
                if (distinctIn == m) {
                    // 서로다른 m개가 잡혔을 경우 스탑
                    break;
                }
                // in에 넣은건 반대로 out에서 빠진단 얘기


            }
            if (distinctIn < m) {
                // 암만 영끌해도 m개의 서로다른 수를 못먹은 경우
                break;
            }
            if (distinctOut == m) {
                // 위에서 In은 적절히 되었고 out또한 m개가 달성되었다면 정답 갱신 대상임
                // 중요한점은 여기서 잡히는 e는 이미 다음에 in으로 편성될 e라는 것, 아직 e는 이번 반복에서 추가된원소는 아님
                ans = Math.min(ans, e - s);
            }
            countIn[arr[s]]--;
            if (countIn[arr[s]] == 0) {
                distinctIn--;
            }

            countOut[arr[s]]++;
            if (countOut[arr[s]] == 1) {
                distinctOut++;
            }

        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}