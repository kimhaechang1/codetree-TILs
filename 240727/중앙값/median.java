import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int[] arr;
    static StringTokenizer stk;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            m = Integer.parseInt(bf.readLine());
            arr = new int[m];
            stk =new StringTokenizer(bf.readLine());
            for(int i = 0;i<m;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> max = new PriorityQueue<>();
            int cnt = 2;
            StringBuilder sb1 = new StringBuilder();
            sb1.append(arr[0]).append(" ");
            max.add(arr[0]);
            while(cnt - 1 < m){
                // max를 기준으로 하나 사이즈 더 많게 유지하는것이 목표
                // 그렇게 하여 max의 peek값이 중앙값으로 항상 꺼낼거임
                if(max.size() > min.size()){
                    // 이미 사이즈가 하나 더 큰데
                    if(max.peek() <= arr[cnt-1]){
                        // 현재 중앙값보다 크거나 작을때
                        // 중앙값 후보가 하나 더 생기는것으로 새로운값은 max pq에 넣고 기존 중앙값을 강등
                        min.add(max.poll());
                        max.add(arr[cnt-1]);
                    }else{
                        // 아에 작다면 중앙값 후보로 들이기도 애매하므로 min에 넣기
                        min.add(arr[cnt-1]);
                    }
                } else {
                    if(max.peek() <= arr[cnt-1]){
                        // 둘 크기가 현재 같은상황에서는 현재 중앙값보다 같거나 크다면 같은 수준의 중앙값을 만들어낼 수 있음
                        max.add(arr[cnt-1]);
                    }else {
                        if(min.peek() < arr[cnt-1]){
                            // 중앙값 보다는 작은데 최소값들중에서 가장 크다면 새로운 중앙값이므로
                            max.add(arr[cnt-1]);
                        }else{
                            // 중앙값과 같거나 더 작다면 중앙값이 될 수 없다.
                            max.add(min.poll());
                            min.add(arr[cnt-1]);
                        }
                    }
                }
                if(cnt % 2 != 0){
                    sb1.append(max.peek()).append(" ");
                }
                cnt++;
            }
            sb.append(sb1.toString()).append("\n");
        }
        System.out.print(sb);
    }
}