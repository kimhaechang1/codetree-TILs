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

        // 거리는 고정값이나, 그 거리를 이동하는데 총 필요한 비용은 다를 수 있음
        // 그러면 오른쪽에서 부터 볼때, 맨끝칸은 더이상 이동 할 필요가 없음
        
        // 위의 예시를 볼때, 결국 최소 비용이 들어야 하니까 n - 2번째 칸에서 1의 에너지를 채우기 위해서는 4의 코스트가 든다.
        // 그것말고 다른 대체안이 없다.
        // 그리고 n - 3을 보면 n - 2 ~ n - 1은 4의 비용을 내어 도달하고 n - 3 ~ n - 2를 6의 비용을 낸다고 하면
        // 총 10의 비용이 발생하는 것 이지만
        // n - 3에서 애초에 끝까지 가는 비용을 얻는다고 생각하면 총 cost는 4이고 에너지비용은 8이 들기 때문에 더 싸다.

        int[] minCost = new int[n];
        minCost[n - 2] = cost[n - 2] * arr[n - 2];
        
        int[] ws = new int[n - 1];
        ws[n - 2] = cost[n - 2];
        for(int i = n - 3; i > -1 ; i--) ws[i] = ws[i + 1] + cost[i];
        
        for(int i = n - 3; i > -1 ; i--) {
            minCost[i] = Math.min(minCost[i + 1] + (cost[i] * arr[i]), arr[i] * ws[i]);
        }
        System.out.print(minCost[0]);
        
    }

}