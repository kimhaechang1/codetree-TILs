import java.util.*;
import java.io.*;

public class Main {

    static String str;
    static BufferedReader bf;
    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();

    }

    void input() throws Exception {

        str = bf.readLine();
    }

    void solve() {

        // 문자열에 포함된 연속한 부분 문자열 중 중복되는 문자가 없는 가장 긴 부분 문자열을 구해야함
        int[] count = new int[26];
        // 연속된 길이가 중요하니까 투포인터? 생각해볼 수 있음
        int s = 0;
        int e = 0;
        int max = 0;
        while(e < str.length()) {

            int c = str.charAt(e) - 'a';
            count[c]++;
            while(count[c] >= 2 && s < e) {
                count[str.charAt(s) - 'a']--;
                s++;
            }
            if (max < (e - s + 1)) {
                max = e - s + 1;
            }
            e++;
        }
        System.out.print(max);
    }
}