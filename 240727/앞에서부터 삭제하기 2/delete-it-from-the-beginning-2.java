import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(arr[a] == arr[b]){
                return a - b;
            }
            return arr[a] - arr[b];
        });
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            pq.add(i);
        }
        long[] sum = new long[n+1];
        for(int i = 0;i<n;i++){
            sum[i+1] = sum[i] + arr[i];
        }

        // 그냥 큐를 사용하자니,, 가장 작은숫자 뽑기가 힘들고
        // PQ를 사용하자니,, 가장 작은숫자는 쉽게 뽑지만 K개를 삭제하는것이 쉽지않다.
        // 그렇다고 매순간 큐와 pq를 왔다갔다 하는건 좀 아닌듯
        // 그러면 버리는 카드에 대해서 구분을 지을수 있으면 pq에서 많이 거를수 있지 않을까
        int k = 0;
        boolean[] used = new boolean[n];
        double ans = 0;
        int currentMin = 9999;
        while(k < n-2){
            used[k] = true;
            while(!pq.isEmpty()){
                int mIdx = pq.peek();
                if(used[mIdx]) {
                    pq.poll();
                    continue;
                }
                break;
            }
            int mIdx = pq.peek();
            ans = Math.max(((double)(sum[n] - sum[k+1] - arr[mIdx]) / (n - k - 1 - 1)), ans);
            k++;
        }


        System.out.print(String.format("%.2f", ans));

        
    }
}