import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] cost;
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
        cost = new int[n - 1];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n - 1; i++) {
            cost[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // 왼쪽에서 가장 오른쪽으로 이동하는데 드는 최소비용
        // 언제나 오른쪽으로 이동함
        // 그리고 바로 인접한 칸으로만 이동해야함
        // 이럴땐 인접차에 대한 누적합으로 풀 수 있음

        // 다시 생각해보자. 연료를 채우는데 필요한 에너지는 해당 스테이션의 가격이라는 점인데
        // 이전의 최솟값이 해당 스테이션의 값으로 설정해도 큰 무리가 없다.
        // 이게 무슨말이냐면, 최솟값인 스테이션이 이전에 나온적 있다면 현재 스테이션을 해당 최솟값으로 두고 다음 필요한 양을 계산하는것이 문제가 없다.
        // 애초에 이전 최솟값인 스테이션에서 총합을 계산하는것과 누적 최솟값은 변화가 없기 때문이다.
        // 이것이 가능한 이유는 반드시 한칸씩만 이동하기 때문이다.

        int[] minStation = new int[n];
        minStation[0] = arr[0];
        for(int i = 1;i < n; i++) minStation[i] = Math.min(minStation[i - 1], arr[i]);
        long answer = 0;
        for(int i = 0;i < n - 1; i++) answer += (minStation[i] * cost[i]);
        System.out.print(answer);
        
    }

}