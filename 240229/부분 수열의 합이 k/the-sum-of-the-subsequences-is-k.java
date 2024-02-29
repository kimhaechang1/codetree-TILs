import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static StringTokenizer stk;
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n+1];
        long [] s = new long[n+1];
        stk = new StringTokenizer(bf.readLine());
        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i =1;i<n+1;i++){
            s[i] = s[i-1] + arr[i];
        }
        int cnt = 0;
        for(int off=1;off<n+1;off++){
            for(int j = off;j<n+1;j++){
                if(k == (s[j] - s[j-off])){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}