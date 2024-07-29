import java.util.*;
import java.io.*;


public class Main {
    static StringTokenizer stk;
    static int n;
    static int[][] info;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        info = new int[n][3]; // n: 10만
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken()); // a: ~ 10억
            info[i][1] = Integer.parseInt(stk.nextToken()); // t: ~ 10000
            info[i][2] = i; // 번호표 ~ 1 ~ N
        }
        // 이들 중 가장 오래 기다려야 하는 사람이 기다리는 시간을 출력
        // 정원에는 한사람만 들어갈 수 있고, 기다리는사람이 여럿이라면 숫자가 작은 사람부터 들어갈 수 있음
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[2] - b[2];
        }); // 번호표에 따라 오름차순

        Arrays.sort(info, (a, b)-> { 
            if(a[0] == b[0]){
                return a[2] - b[2];
            }
            return a[0] - b[0];
        });
        // 먼저 도착한 순서로 오름차순
        // 도착순서가 같다면, 번호순으로 오름차순
        int ans = 0;
        int pTime = info[0][0] + info[0][1];
        int ptr = 1;
        while(ptr < n){
            while(ptr < n && info[ptr][0] < pTime){
                pq.add(new int[]{ info[ptr][0], info[ptr][1], info[ptr][2] });
                ptr++;
            }
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                int cha = pTime - now[0];
                ans = Math.max(ans, cha);
                pTime += now[1];
                continue;
            }
            if(ptr < n && info[ptr][0] >= pTime){
                pTime = info[ptr][0];
                pTime += info[ptr][1];
                ptr++;
            }
            
        }
        System.out.println(ans);
    }
}