import java.util.*;
import java.io.*;

public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int k;
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
        str = stk.nextToken();
        k = Integer.parseInt(stk.nextToken());
    }

    void solve() {

        // 길이가 N인 ㄴ문자열 한 개가 입력으로 주어졌을 때, 해당 문자열에 포함된 연속 부분 문자열 중 문자열을 다루고 있는 서로 다른 문자의 수가 K를 넘지않으며
        // 그 중 가장 긴 문자열의 길이

        // 연속해야하니까 투포인터로 접근해볼 수 있음
        int[] count = new int[26];
        char[] chars = str.toCharArray();
        int s = 0;
        int e = 0;
        int ans = 0;
        int kind = 0;
        while(e < chars.length) {
            count[chars[e] - 'a']++;
            if (count[chars[e] - 'a'] == 1) {
                kind++;
            }
            while(kind > k && s < e) {
                count[chars[s] - 'a']--;
                if (count[chars[s] - 'a'] == 0) {
                    kind--;
                }
                s++;
            }
            ans = Math.max(ans, e - s + 1);
            e++;
        }
        System.out.println(ans);
    }
}