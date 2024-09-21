import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long b;
    static long[] prr;
    static long[] srr;
    static StringTokenizer stk;
    static class Data {
        long p;
        long s;
        long total;

        public Data(long p, long s) {
            this.p = p;
            this.s = s;
            this.total = p + s;
        }
    }
    static Data[] drr;
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        srr = new long[n];
        prr = new long[n];
        drr = new Data[n];
        for(int i = 0;i<n;i++) {
            stk = new StringTokenizer(bf.readLine());
            prr[i] = Integer.parseInt(stk.nextToken());
            srr[i] = Integer.parseInt(stk.nextToken());
            drr[i] = new Data(prr[i], srr[i]);
        }
        long sum = 0;
        Arrays.sort(drr, (a, b)-> {
            if(a.total == b.total) {
                return Long.compare(a.s, b.s);
            }
            return Long.compare(a.total, b.total);
        });
        long prev = 0;
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            if (sum + drr[i].total <= b) {
                sum += drr[i].total;
                cnt++;
            } else {
                for(int j = 0;j<i;j++) {
                    if ((sum - drr[j].total) + prev + (drr[j].p / 2 + drr[j].s) + drr[i].total <= b) {
                        cnt++;
                        prev = drr[j].p / 2;
                        break;
                    } 
                }
                if(sum + prev + (drr[i].p / 2 + drr[i].s) <= b) {
                    cnt++;
                    prev = drr[i].p / 2;
                }
                break;
            }
        }
        System.out.println(cnt);


    }
}