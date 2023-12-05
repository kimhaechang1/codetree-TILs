import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int t;
    static StringTokenizer stk;
    static int [] arr;
    static int [] brr;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        brr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<n;i++){
            brr[i] = Integer.parseInt(stk.nextToken());
        }
        while(t-- > 0){
            // arr 의 length -1 번째 원소 임시 저장해놓기
            // brr 의 length -1 번째 원소 임시 저장해놓기
            int arrTemp = arr[n-1];
            int brrTemp = brr[n-1];
            // arr과 brr 둘다 n-1에서부터 1번째까지 앞 원소를 땡겨오기
            for(int i= n-1;i>=1;i--){
                arr[i] = arr[i-1];
                brr[i] = brr[i-1];
            }
            // arrTemp는 brr[0] 로
            // brrTemp는 arr[0] 로 넣기
            brr[0] = arrTemp;
            arr[0] = brrTemp;
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr) sb.append(a).append(" ");
        sb.append("\n");
        for(int a : brr) sb.append(a).append(" ");
        System.out.print(sb);
    }
}