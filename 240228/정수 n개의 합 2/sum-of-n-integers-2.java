import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    static int n;
    static int k;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        int [] s = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int max = Integer.MIN_VALUE;
        s[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            s[i] = s[i-1]+arr[i];
        }
        for(int i = 0;i<n-k;i++){
            max = Math.max(max, s[i+k] - s[i]);
        }
        System.out.print(max);
    }
}