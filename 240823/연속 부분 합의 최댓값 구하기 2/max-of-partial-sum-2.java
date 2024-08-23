import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        long sum = 0;
        long max = 0;
        int idx = 0;
        while(idx < n) {
            if(sum + arr[idx] < 0) {
                sum = arr[idx];
            } else {
                sum += arr[idx];
            }
            max = Math.max(max, sum);
            idx++;
        }

        System.out.print(max);
    }
}