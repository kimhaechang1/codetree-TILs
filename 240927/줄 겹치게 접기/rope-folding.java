import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int l;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[] points = new boolean[10001];
        stk = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        
        for(int i = 0;i<n;i++) {
            int p = Integer.parseInt(bf.readLine());
            points[p] = true;
        } 
        int cnt = 0;
        for(int i = 1;i< l;i++) {
            int fP = i;
            boolean can = true;
            int out = 0;
            int right = 0;
            for(int j = 0;j<fP;j++) {
                if (points[j]) {
                    right++;
                }
                if((fP - j) + fP > l) {
                    if(points[j]) out++;
                    continue;
                }
                if (points[j] && !points[(fP - j) + fP]) {
                    can = false;
                    break;
                }
            }
            if(out == right) can = false;
            if(can) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}