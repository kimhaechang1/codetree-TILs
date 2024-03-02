import java.util.*;
import java.io.*;

public class Main {
    static int [] line;
    static int n, q;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        line = new int[1000001];
        for(int i = 0;i<n;i++){
            int point = Integer.parseInt(stk.nextToken());
            line[point] = 1;
        }
        int [] s = new int[1000000+1];
        for(int i=1;i<1000000+1;i++){
            s[i] = s[i-1] + line[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<q;i++){
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append(s[b] - s[a-1]).append("\n");
        }
        System.out.print(sb);
    }
}