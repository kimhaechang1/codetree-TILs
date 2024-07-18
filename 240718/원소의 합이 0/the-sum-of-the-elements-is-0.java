import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[4][n];
        for(int i= 0;i<4;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        HashMap<Integer, Integer> cnt2 = new HashMap<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for(int i= 0;i<n;i++){
            for(int j=0;j<n;j++){
                
                int s = (map[0][i] + map[1][j]);
                cnt.put(s, cnt.get(s) == null ? 1 : cnt.get(s) + 1);
            }
        }
        for(int i= 0;i<n;i++){
            for(int j=0;j<n;j++){
                int s = (map[2][i] + map[3][j]);
                cnt2.put(s, cnt2.get(s) == null ? 1 : cnt2.get(s) + 1);
            }
        }
        
        int ans = 0;
        // 두 수의 합이 find가 되는 경우의수 
        for(Map.Entry<Integer, Integer> entry: cnt.entrySet()){
            int find = 0 + entry.getKey();
            if(cnt2.containsKey(find * -1)){
                ans += (cnt.get(find)) * (cnt2.get(find * -1));
            }   
        }
        System.out.println(ans);
    }
}