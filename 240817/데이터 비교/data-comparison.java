import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int[] arr;
    static int[] brr;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            set.add(arr[i]);
        }
        m = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<m;i++){
            int select = Integer.parseInt(stk.nextToken());
            if(set.contains(select)) {
                sb.append("1").append(" ");
            }else { 
                sb.append("0").append(" ");
            }
        }
        System.out.print(sb);
    }

}