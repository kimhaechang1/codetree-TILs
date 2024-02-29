import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int b;
    static StringTokenizer stk;
    static int [] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        int [] seq = new int[n+1];
        Arrays.fill(seq, 1);
        for(int i =0 ;i<b;i++){
            int num = Integer.parseInt(bf.readLine());
            seq[num] = 0;
        }
        int [] s= new int[n+1];
        for(int i=1;i<n+1;i++){
            s[i] = s[i-1] + seq[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i= k;i<n+1;i++){
            min = Math.min(min, k - (s[i] - s[i-k]) );
        }
        System.out.print(min);
    }
}