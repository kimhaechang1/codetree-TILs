import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        
        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        int prev = 0;
        for(int i= 0;i<n;i++) {
            stk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stk.nextToken());
            String dir = stk.nextToken();
            switch(dir) {
                case "R":
                    treeMap.put(prev, treeMap.get(prev) == null ? 1 : treeMap.get(prev) + 1);
                    treeMap.put(prev + s, treeMap.get(prev + s) == null ? -1 : treeMap.get(prev+s+1) - 1);
                    prev = prev + s;
                    break;
                case "L":
                    treeMap.put(prev - s, treeMap.get(prev - s) == null ? 1 : treeMap.get(prev - s) + 1);
                    treeMap.put(prev, treeMap.get(prev) == null ? -1 : treeMap.get(prev) - 1);
                    prev = prev - s;
                    break;
            }
        } 
        int sum = 0;
        for(int x: treeMap.keySet()) {
            sum += treeMap.get(x);
            resultMap.put(x, sum);
            
        }
        int ans = 0;
        int p = Integer.MIN_VALUE;
        for(int x: resultMap.keySet()) {
            if(p == Integer.MIN_VALUE && resultMap.get(x) >= m) {
                p = x;
            } else if (p != Integer.MIN_VALUE && resultMap.get(x) < m) {
                ans += (x - p);
                p = Integer.MIN_VALUE;
            }
        }
        
        System.out.print(ans);
    }
}