import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        HashMap<Character, Integer> ctoi = new HashMap<>();
        char [] itoc = new char[n+1];
        StringBuilder sb =new StringBuilder();
        for(int i = 1;i<n+1;i++){
            char [] alpa = bf.readLine().toCharArray();
            ctoi.put(alpa[0], i);
            itoc[i] = alpa[0];
        }
        while(m-- > 0){
            char [] target= bf.readLine().toCharArray();
            if(target[0] > 97 && target[0] < 123){
                sb.append(ctoi.get(target[0])).append("\n");
            }else{
                sb.append(itoc[target[0]-'0']).append("\n");
            }
        }
        System.out.print(sb);
    }
}