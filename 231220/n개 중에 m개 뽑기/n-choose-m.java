import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [] arr;
    static int [] sel;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = i+1;
        }
        sel = new int[n];
        Arrays.fill(sel, n-m,n, 1);
        System.out.println(Arrays.toString(sel));
        StringBuilder sb= new StringBuilder();
        do{
            for(int i = 0;i<n;i++){
                System.out.println(Arrays.toString(sel));
                if(sel[i] == 0){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
        }while(np(sel));
        System.out.print(sb);
    }
    static boolean np(int [] prr){
        int i = prr.length-1;
        while(i > 0 && prr[i-1] >= prr[i]) i--;
        if(i == 0) return false;
        int j = prr.length-1;
        while(prr[i-1] >= prr[j]) j--;
        int temp = arr[j];
        prr[j] = prr[i-1];
        prr[i-1] = prr[j];
        int k = arr.length-1;
        while(i<k){
            temp= prr[k];
            prr[k] = prr[i];
            prr[i] = temp;
            k--;
            i++;
        }
        return true;
    }
}