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
            min.add(arr[0]);
            while(cnt - 1 < m){
                if(max.size() == 0){
                    if(min.peek() < arr[cnt-1]){
                        max.add(arr[cnt-1]);
                    }else{
                        max.add(min.poll());
                        min.add(arr[cnt-1]);
                    }
                } else {
                    if(max.peek() <= arr[cnt-1]){
                        if(max.size()+1 == min.size()){
                            max.add(arr[cnt-1]);
                        }else{
                            min.add(max.poll());
                            max.add(arr[cnt-1]);
                        }
                    }else{
                        if(min.peek() >= arr[cnt-1]){
                            if(min.size() > max.size()){
                                max.add(min.poll());
                                min.add(arr[cnt-1]);
                            }else if(min.size() == max.size()){
                                min.add(arr[cnt-1]);
                            }
                        } else {
                            if(min.size() > max.size()){
                                max.add(min.poll());
                                min.add(arr[cnt-1]);
                            }else if(min.size() == max.size()){
                                min.add(arr[cnt-1]);
                            }
                        }
                    }
                    
                }
                if(cnt % 2 != 0){
                    sb1.append(min.peek()).append(" ");
                }
                cnt++;
            }
            sb.append(sb1.toString()).append("\n");
        }
        System.out.print(sb);
    }
}