import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        while(n-- > 0){
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            if(map.containsKey(x)){
                y = Math.min(map.get(x), y);
            }
            map.put(x, y);
        }
        long ans = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans += entry.getValue();
        }
        System.out.println(ans);
    }
}