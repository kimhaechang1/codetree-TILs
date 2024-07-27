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
                if(max.size() > min.size()){
                    if(max.peek() <= arr[cnt-1]){
                        min.add(max.poll());
                        max.add(arr[cnt-1]);
                    }else{
                        min.add(arr[cnt-1]);
                    }
                } else {
                    if(max.peek() <= arr[cnt-1]){
                        max.add(arr[cnt-1]);
                    }else {
                        if(min.peek() < arr[cnt-1]){
                            max.add(arr[cnt-1]);
                        }else{
                            max.add(min.poll());
                            min.add(arr[cnt-1]);
                        }
                    }
                }
                // System.out.println("minSize: "+min.size()+" maxSize: "+max.size());
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