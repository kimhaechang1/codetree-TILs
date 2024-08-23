import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0;i<n;i++) {
            stk = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());

            treeMap.put(x1, treeMap.get(x1) == null ? 1 : treeMap.get(x1) + 1);
            treeMap.put(x2, treeMap.get(x2) == null ? -1 : treeMap.get(x2) - 1);
        }

        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        int sum = 0;
        for(int x: treeMap.keySet()) {
            sum += treeMap.get(x);
            resultMap.put(x, sum);
        }

        int max = -1;
        for(int x: resultMap.keySet()) {
            max = Math.max(max, resultMap.get(x));
        }
        System.out.print(max);
    }
}