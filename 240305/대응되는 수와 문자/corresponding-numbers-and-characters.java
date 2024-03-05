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
        HashMap<String, String> table = new HashMap<>();
        StringBuilder sb =new StringBuilder();
        for(int i = 1;i<n+1;i++){
            String alpa = bf.readLine();
            table.put(alpa, String.valueOf(i));
            table.put(String.valueOf(i), alpa);
        }
        while(m-- > 0){
            String target= bf.readLine();
            sb.append(table.get(target)).append("\n");
        }
        System.out.print(sb);
    }
}