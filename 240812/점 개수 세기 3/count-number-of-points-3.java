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
        lines = new int[q][2];
        stk = new StringTokenizer(bf.readLine());
        
        for(int i= 0;i<n;i++){
            points[i] = Integer.parseInt(stk.nextToken());
        }

        // -3까지 1, 5까지 2, 9까지 3
        Arrays.sort(points);
        
        TreeMap<Integer, Integer> pointCnt = new TreeMap<>();

        int cnt = 1;

        for(int point: points){
            pointCnt.put(point, cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<q;i++){
            stk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            int under = pointCnt.get(pointCnt.floorKey(s));
            int upper = pointCnt.get(pointCnt.ceilingKey(e));
            sb.append(upper - under + 1).append("\n");
        }
        System.out.print(sb);
    }
}