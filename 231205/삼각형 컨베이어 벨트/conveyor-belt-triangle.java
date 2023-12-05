import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int t;
    static int [] arr; // 왼쪽 위
    static int [] brr; // 오른쪽 위
    static int [] crr; // 밑 변
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        brr = new int[n];
        crr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            brr[i] = Integer.parseInt(stk.nextToken());
        }
        
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            crr[i] = Integer.parseInt(stk.nextToken());
        }

        while(t-- > 0){
            int arrT = arr[n-1];
            int brrT = brr[n-1];
            int crrT = crr[n-1];
            
            for(int i = n-1;i>0;i--){
                arr[i] = arr[i-1];
                brr[i] = brr[i-1];
                crr[i] = crr[i-1];
            }

            arr[0] = crrT;
            brr[0] = arrT;
            crr[0] = brrT;
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a).append(" ");
        }
        sb.append("\n");
        for(int a : brr){
            sb.append(a).append(" ");
        }
        sb.append("\n");
        for(int a : crr){
            sb.append(a).append(" ");
        }
        System.out.print(sb);


    }
}