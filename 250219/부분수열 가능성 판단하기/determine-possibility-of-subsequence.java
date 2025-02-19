import java.util.*;
import java.io.*;


public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int n, m;
    static int[] a;
    static int[] b;
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
        a = new int[n];
        b = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }
    }

    void solve() {

        // 두 수열이 주어졌을 때, B의 특정원소를 하나 지웠을 때 A의 부분수열이 되는 가짓수를 구하시오
        // 여기서 말하는 부분수열이라 함은 B의 원소가 차례대로 A의 원소에 존재할 때를 의미한다.

        // 두 수열의 길이가 서로 다를수 있으며 항상 A 수열이 B수열보다 크다는 보장이 없음
        // B수열의 원소를 하나 제거하더라도 A 수열의 부분수열이 될려면, 적어도 A수열의 길이는 B수열의 길이 - 1와 같거나 커야함
        int ans = 0;
        if (a.length < b.length - 1) {
            System.out.print(ans);
            return;
        }
        // 삭제된 원소를 기준으로 왼쪽과 오른쪽으로 나눴을 때, 왼쪽원소들의 묶음은 오른쪽 원소들의 묶음보다 항상 왼쪽에 있어야 한다.

        // 이걸 좀 더 일반화 해보면, 오른쪽에 해당원소묶음이 가장 왼쪽에서 나타나는 시작 인덱스는
        // 왼쪽 원소묶음이 가장 마지막으로 등장하는 마지막인덱스보다 커야 한단 것이다.
        // 즉, B원소가 [9, 4, 10, 5, 7]일 때, 10을 없앴다고 가정했을 때
        // 9, 4 묶음이 가장 마지막으로 등장하는 부분에서 4의 인덱스는 5, 7이 가장 먼저 등장하는 부분에서 5의 인덱스보다 작아야 한단 것이다.

        // 그러면 이들이 가장 먼저 나타나는 묶음은 어떻게 결정할 것인가?
        // 투 포인터를 사용해서 B 원소 순서대로 A원소 내에서 가장 마지막으로 등장하는 배열 L과
        // 같은 방식으로 거꾸로 순회하면서 가장 마지막으로 등장하는 인덱스를 담은 배열 R을 사용하면 된다.
        // 그러면 특정원소를 삭제했을 때, 그 왼쪽 원소들은 L배열을 따져보면 반드시 그 순서가 오름차순이며,
        // 그것에서 가장 오른쪽 원소를 꺼내면 아까 언급한 묶음이 가장 마지막으로 등장할 때 그 끝인덱스 원소가 된다.
        // R배열도 마찬가지로 활용하면 된다.

        int[] arr = new int[n + 1];
        int[] brr = new int[m + 1];
        int[] L = new int[n + 2];
        int[] R = new int[m + 2];
        for(int i = 0; i < n; i ++) {
            arr[i + 1] = a[i];
        }
        for(int i = 0; i < m; i ++) {
            brr[i + 1] = b[i];
        }

        for(int i = 1, j = 1; j <= m; j++) {
            while(i <= n && arr[i] != brr[j]) i++;
            L[j] = i;
            if (i <= n) i++;
        }
        for(int i = n, j = m; j > 0; j--) {
            while(i > 0 && arr[i] != brr[j]) i--;
            R[j] = i;
            if (i > 0) i--;
        }
        L[0] = 0;
        R[m + 1] = n + 1;
        for(int i = 1; i <= m; i++) {
            if (L[i - 1] < R[i + 1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}