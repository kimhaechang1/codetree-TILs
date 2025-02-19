import java.util.*;
import java.io.*;


public class Main {

    static String str;
    static BufferedReader bf;
    static StringTokenizer stk;
    static int n, m;
    static int[] arr1;
    static int[] arr2;
    Main() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.input();
        m.solve();

    }

    void input() throws Exception {

        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr1 = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) arr1[i] = Integer.parseInt(stk.nextToken());
        arr2 = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++) arr2[i] = Integer.parseInt(stk.nextToken());
    }

    void solve() {

        // 1차 수직선 상 위에 화재가 발생할 가능성이 있는 서로 다른 N개의 위치와 소방서 M개의 위치가 주어진다.
        // 화재는 정확히 1곳에서만 발생하며 가장 근처에 있는 소방서에서 출동하여 진입한다.
        // 거리 1을 이동하는 데 시간이 1초 소요되는데, 가장 오래걸리는 시간을 구하는 프로그램

       int ans = 0;
       HashMap<Integer, Integer> fireMap = new HashMap<>();
       HashSet<Integer> ffSet = new HashSet<>();
       ArrayList<Integer> allPos = new ArrayList<>();
       for(int i = 0; i < n; i++) {
            allPos.add(arr1[i]);
            fireMap.put(arr1[i], Integer.MAX_VALUE);
       }
       for(int i = 0; i < m; i++) {
            allPos.add(arr2[i]);
            ffSet.add(arr2[i]);
       }

        Collections.sort(allPos);
        int idx = 0;
        for(; idx < allPos.size();) {
            int pos = allPos.get(idx);
            if (!ffSet.contains(pos)) {
                idx++;
                continue;
            }
            int selectedPos = pos;
            while(idx < allPos.size()) {
                int anyPos = allPos.get(idx);
                if (selectedPos != anyPos && ffSet.contains(anyPos)) {
                    break;
                }
                if (fireMap.containsKey(anyPos)) {
                    int dis = Math.abs(selectedPos - anyPos);
                    fireMap.put(anyPos, Math.min(fireMap.get(anyPos), dis));
                }
                idx++;
            }
        }

        idx = allPos.size() - 1;
        for(; idx > -1;) {
            int pos = allPos.get(idx);
            if (!ffSet.contains(pos)) {
                idx--;
                continue;
            }
            int selectedPos = pos;
            while(idx > -1) {
                int anyPos = allPos.get(idx);
                if (selectedPos != anyPos && ffSet.contains(anyPos)) {
                    break;
                }
                if (fireMap.containsKey(anyPos)) {
                    int dis = Math.abs(selectedPos - anyPos);
                    fireMap.put(anyPos, Math.min(fireMap.get(anyPos), dis));
                }
                idx--;
            }
        }

        for(Map.Entry<Integer, Integer> entry: fireMap.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }
        System.out.print(ans);

    }
}