import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int k;
    static int [] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        
        stk = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int cnt = 0;
        for(int i= 0;i<n-2;i++){
            // 수 하나 고정시켜놓고
            // 나머지 수들 중에서 2개를 뽑는 조합을 찾는다.
            // 이 때 고정수 기준으로 매번 새로운 조합인것을 연산에서 잊으면 안된다.
            HashMap<Integer, Integer> map = new HashMap<>();
            int find = k - arr[i];
            for(int j= i+1;j<n;j++){
                map.put(arr[j], map.get(arr[j]) == null ? 1 : map.get(arr[j]) + 1);
            }
            for(int j = i+1;j<n;j++){
                map.put(arr[j], map.get(arr[j])-1);
                if(map.containsKey(find - arr[j])){
                    cnt += map.get(find - arr[j]);
                }
            }
        }
        System.out.println(cnt);
    }
    
}