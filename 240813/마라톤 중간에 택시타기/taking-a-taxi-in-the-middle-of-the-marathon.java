import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    public static void main(String[] args) throws Exception{
        // 누적합을 응용하는것
        // 특정 인덱스까지의 왼쪽에서부터의 인접차의 합을 구하고
        // 오른쪽에서부터의 인접차의 합을 구한다.
        // 그러면 건너뛸 지점을 제외한 인접차의 합을 구할 수 있다.
        // 건너뛸 지점은 어떻게 구하는가? 생각해보면 건너뛸 대상이 되는 지점 이전점과 이후점의 사이거리를 구하면 그만이다.
        // 인접차의 구간합 문제에서 활용
        // 좌표점을 두개로 나눠서 풀면 안될듯
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] disL= new int[n];
        int[] disR= new int[n];
        int[] xrr = new int[n];
        int[] yrr = new int[n];
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            xrr[i] = x;
            yrr[i] = y;
        }

        
        for(int i = 1;i<n;i++){
            disL[i] = disL[i-1] + (Math.abs(xrr[i-1] - xrr[i]) + Math.abs(yrr[i-1] - yrr[i]));
        }

        for(int i = n-2;i>-1;i--){
            disR[i] = disR[i+1] + (Math.abs(xrr[i+1] - xrr[i]) + Math.abs(yrr[i+1] - yrr[i]));
        }

        int min = Integer.MAX_VALUE;
        

        for(int i= 1;i<n-1;i++){
            int absMin = disL[i-1] + disR[i+1] + Math.abs(xrr[i+1] - xrr[i-1]) + Math.abs(yrr[i+1] - yrr[i-1]);
            min = Math.min(absMin, min);
        }
        System.out.print(min);
    }
}