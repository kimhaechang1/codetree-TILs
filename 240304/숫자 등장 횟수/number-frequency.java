import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> cnt = new HashMap<>();
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(stk.nextToken());
            if(cnt.containsKey(num)){
                cnt.put(num, cnt.get(num)+1);
            }else{
                cnt.put(num, 1);
            }
        }
        StringBuilder sb= new StringBuilder();
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<m;i++){
            int p = Integer.parseInt(stk.nextToken());
            if(cnt.containsKey(p)){
                sb.append(cnt.get(p)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.print(sb);
    }
}