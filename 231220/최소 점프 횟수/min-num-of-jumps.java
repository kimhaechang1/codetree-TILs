import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [] arr;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        System.out.print(bfs());
    }
    static int bfs(){
        boolean [] v = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        pq.add(new int[]{0, 0});
        v[0] = true;
        while(!pq.isEmpty()){
            int [] now = pq.poll();
            int val = arr[now[0]];
            for(int i = now[0]+1;i<=now[0]+val;i++){
                if(i > arr.length-1) continue;
                if(i == arr.length-1){
                    return now[1]+1;
                }
                if(v[i]) continue;
                v[i] = true;
                pq.add(new int[]{i, now[1]+1});
                
            }
        }
        return -1;
    }
}