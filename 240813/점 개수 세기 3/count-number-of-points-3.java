import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n, q;
    static int[] points;
    static int[][] lines;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        
        points = new int[n];

        stk = new StringTokenizer(bf.readLine());
        TreeSet<Integer> pointCnt = new TreeSet<>();
        for(int i= 0;i<n;i++){
            points[i] = Integer.parseInt(stk.nextToken());
            pointCnt.add(points[i]);
        }

        // -3까지 1, 5까지 2, 9까지 3

        int cnt = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int point: points){
            hashMap.put(pointCnt.pollFirst(), cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<q;i++){
            stk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(hashMap.get(e) - hashMap.get(s) + 1).append("\n");
        }
        System.out.print(sb);
    }
}