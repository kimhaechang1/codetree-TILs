import java.util.*;
import java.io.*;

public class Main {
    static int[] table;
    static int[] arr;
    static int n;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for(int i = 0;i<n;i+=1){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size() < 3){
                sb.append("-1").append("\n");
                continue;
            }
            long result = pq.peek();
            queue.add(pq.poll());
            
            for(int j= 1;j<3;j++){
                result *= pq.peek();
                queue.add(pq.poll());
            }
            sb.append(result).append("\n");
            while(!queue.isEmpty()){
                pq.add(queue.poll());
            }
            
        }
        System.out.print(sb);
    }
}