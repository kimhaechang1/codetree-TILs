import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean [] v;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        v = new boolean[1000001];
        System.out.print(bfs());
    }
    static int bfs(){
        v[n] = true;
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        int res = 0;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            int val = now[0];
            int cnt = now[1];
            if(val == 1){
                res = cnt;
                break;
            }
            if(val-1 >= 1 && !v[val-1]){
                v[val-1]= true;
                queue.add(new int[]{val-1, cnt+1});
            }
            if(val+1 < 1000001 && !v[val+1]){
                v[val+1] = true;
                queue.add(new int[]{val+1, cnt+1});
            }
            if(val > 0 && val % 2 == 0 && !v[val/2]){
                v[val/2] = true;
                queue.add(new int[]{val/2, cnt+1});
            }
            if(val > 0 && val % 3 == 0 && !v[val/3]){
                v[val/3] = true;
                queue.add(new int[]{val/3, cnt+1});
            }
        }
        return res;
    }
}