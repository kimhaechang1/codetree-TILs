import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String str;
    static long[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        str = bf.readLine();
        char[] chs = new char[n+1];
        for(int i = 1;i<n+1;i++) {
            chs[i] = str.charAt(i-1);
        }
        // 맨 앞에 C가 와야하고, 맨 끝에는 W가 와야함
        // 그러면 특정 가운데 O가 오는 경우의 수에서 왼쪽 C의 개수와 오른쪽에서 W의 개수의 곱을 누적하면 될라나?
        // 결국 LR 테크닉의 핵심은, 배열의 순서와 정답으로 나와야할 매커니즘이 동일해야함
        // C는 첫번째로 와야한다는 조건이 배열의 순서에서 O와 W보다 먼저나오는 C들이 정답후보가 됨
        long[] L = new long[n+1];
        long[] R = new long[n+1];
        L[1] = chs[1] == 'C' ? 1 : 0;
        for(int i= 1;i<n+1;i++){
            L[i] = L[i-1];
            if(chs[i] == 'C')
                L[i] += 1;
        }
        R[n] = chs[n] == 'W' ? 1 : 0;
        for(int j = n-1;j>0;j--){
            R[j] = R[j+1];
            if(chs[j] == 'W')
                R[j] += 1;
        }
        long ans = 0;
        for(int i = 2;i<n;i++)
            if(chs[i] == 'O'){
                ans += (L[i-1] * R[i+1]);
            }
                

        System.out.println(ans);
    }
}