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
        // 수하나를 고정시켜놓고
        // 나머지 수 하나에따라 나올수 있는 경우의수를 더한다.
        // 이때, 중복을 최대한 제거하기 위해서는 끝범위 하나를 고정시켜놓고
        // 그 사이에 올 수 있는 숫자 하나 뽑았을 때, 나머지 숫자에 대한 경우의 수를 선택한다.
        Arrays.sort(arr);
        for(int i= 0;i<n-2;i++){
            long sum = arr[i];
            int s = i+1;
            int e = n-1;
            while(s < e){
                if(sum + arr[s] + arr[e] < k){
                    s++;
                }else if(sum + arr[s] + arr[e] == k){
                    s++;
                    cnt++;
                }else{
                    e--;
                }
            }
        }
        System.out.println(cnt);
    }
    
}