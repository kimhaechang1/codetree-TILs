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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        stk = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int cnt = 0;
        // 특정 기준점 이후를 기준으로 계산하려고 하면 중복계산이 많다.
        // 그래서 i까지의 계산만 유도한다면, 중복연산에 대한 복잡성이 줄어든다.

        // 1 2 1 4 -1
        for(int i= 0;i<n;i++){
            // 지금 사용할 점에 대해서 사용했다고 표시를 남긴다.
            // 그리고 세 수가 j < i < diff 인 값을 찾는다. 
            // 자연스럽게 중복이 제거되는 이유는 기준점 i를 기준으로 그 앞에 원소들은 전부 제거되기 때문
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])-1);
            }
            for(int j= 0;j<i;j++){
                int diff = k - arr[i] - arr[j];
                if(map.containsKey(diff)){
                    cnt += map.get(diff);
                }
            }
            
        }
        System.out.println(cnt);
    }
    
}