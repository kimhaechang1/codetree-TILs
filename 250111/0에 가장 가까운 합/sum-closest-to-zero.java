import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static BufferedReader bf;
    static StringTokenizer stk;

    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();
    }

    void testCase() throws Exception {

    }

    void input() throws Exception {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    int TC() {
       return 0;
    }

    void solve() {
        // 서로다른 두 개의 원소를 골라 합이 0에 가장 가까운 프로그램
        // 딱 2개의 수니까, 투포인터? or TreeSet 같은걸로 가능할듯

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for(int num: arr) {
            int cnt = treeMap.get(num);
            if (cnt - 1 == 0) treeMap.remove(num);
            else treeMap.put(num, cnt - 1);
            
            int need = -1 * num;
            
            Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(need);
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(need);
            int fGap = floorEntry == null ? Integer.MAX_VALUE : Math.abs(num + floorEntry.getKey());
            int cGap = ceilingEntry == null ? Integer.MAX_VALUE : Math.abs(num + ceilingEntry.getKey());
            ans = Math.min(fGap, Math.min(cGap, ans));
        }
        System.out.print(ans);
    }

}