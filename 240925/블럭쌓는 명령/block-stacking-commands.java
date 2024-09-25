import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int k;
    static int[][] info;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        info = new int[k][2];
        for(int i = 0;i<k;i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken());
            info[i][1] = Integer.parseInt(stk.nextToken());
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0;i<k;i++) {
            int s= info[i][0];
            int e= info[i][1];
            treeMap.put(s, treeMap.get(s) == null ? 1: treeMap.get(s) + 1);
            treeMap.put(e + 1, treeMap.get(e + 1) == null ? -1 : treeMap.get(e + 1) - 1);
        }

        int cnt = 0;
        TreeMap<Integer, Integer> lineMap = new TreeMap<>();
        for(int key: treeMap.keySet()) {
            cnt += treeMap.get(key);
            lineMap.put(key, cnt);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            if (lineMap.get(i) == null) {
                list.add(0);
            } else {
                list.add(lineMap.get(i));
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size() / 2));
        
    }
}