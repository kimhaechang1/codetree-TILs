import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());
        // 10만 * 10만을 전부 전처리할 수 없음
        // 결국 특정 범위내의 숫자가 몇번째로 오는지를 알수있는가?
        // 혹은 판별식이 가능한가?
        // 예를들어 6번째 숫자를 원하는데 
        // 1 2 3 
        // 2 4 6 
        // 3 6 9 
        // 
        // M 값보다 같거나 작은 수의 개수는 min(n, M/i)임을 사용한다.
        // 그게 무슨말이냐면 세로칸의 개수를 생각하면 편하다. 예를들어 n이 3일때, 4는 몇번째 숫자인가를 생각해볼 수 있다.
        // 그거는 1일때의 4를 넘지않을 세로칸의 개수, 2일때의 4를 넘지않는 세로칸의 개수, 3일때의 4를 넘지않은 세로칸의 개수를 합하는 것이다.
        // 즉, 특정 수 mid / (1 ~ n) 의 누적합이 해당 숫자 mid까지의 번째수가 된다.
        // 추가적으로 mid가 9라고 해서 i가 1일때 나눈 숫자를 그대로 더하면 안된다.
        // 왜냐하면 주어진 조건이 2차원 배열이고 i * j 가 수열의 수로 제한되어있기 때문이다.

        long s = 1;
        long e = n * n;
        long ans = n * n;

        while(s <= e) {
            long mid = (s + e) /2 ;
            long cnt = 0;

            for(int i = 1;i<=n;i++) {
                cnt += Math.min(n, mid / i);
            }

            if(cnt >= k) {
                e = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                s = mid + 1;
            }
        }
        System.out.print(ans);
    }
}